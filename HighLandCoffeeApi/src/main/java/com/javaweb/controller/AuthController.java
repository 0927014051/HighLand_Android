package com.javaweb.controller;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.config.JwtTokenProvider;
import com.javaweb.entity.Cart;
import com.javaweb.entity.Customer;
import com.javaweb.entity.User;
import com.javaweb.exception.UserException;
import com.javaweb.reponsitory.UserRepo;
import com.javaweb.request.LoginRequest;
import com.javaweb.response.AuthResponse;
import com.javaweb.service.CartService;
import com.javaweb.service.CustomerService;
import com.javaweb.service.CustomerUserDetails;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	private UserRepo userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	private CustomerUserDetails customUserDetails;
	private CartService cartService;
	private CustomerService customerService;
	
	public AuthController(UserRepo userRepository,PasswordEncoder passwordEncoder,JwtTokenProvider jwtTokenProvider,CustomerUserDetails customUserDetails,CartService cartService,CustomerService customerService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
		this.customUserDetails = customUserDetails;
		this.cartService = cartService;
		this.customerService = customerService;
	}
	@RequestMapping(value = "/signup",method = RequestMethod.POST)
	public ResponseEntity<AuthResponse> createUserHandler(@Valid @RequestBody User user) throws UserException{
		  	String username = user.getUsername();
	        String password = user.getPassword();
	        Long role_id = user.getRole_id();
	        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
	        SecurityContextHolder.getContext().setAuthentication(authentication);        
	        String token = jwtTokenProvider.generateToken(authentication);
	        AuthResponse authResponse = new AuthResponse(token,true);
	        User isEmailExist = userRepository.findByUsername(username);
	        // Check email exists
	        if (isEmailExist != null) {
	        // System.out.println("--------- exist "+isEmailExist).getEmail());
	            throw new UserException("Email Is Already Used With Another Account");
	        }
	        // Lấy ngày và giờ hiện tại
	        LocalDateTime currentTime = LocalDateTime.now();
	        // Cộng thêm 7 ngày
	        LocalDateTime expiredAccressToken = currentTime.plus(7, ChronoUnit.DAYS);
	        LocalDateTime expiredRefreshToken = currentTime.plus(30, ChronoUnit.DAYS);
	        // Chuyển LocalDateTime thành Timestamp
	        Timestamp expiredAccressTokenTimestamp = Timestamp.valueOf(expiredAccressToken);
	        Timestamp expiredRefreshTokenTimestamp = Timestamp.valueOf(expiredRefreshToken);
	        // Create new user
			User createdUser = new User();
			createdUser.setUsername(username);
	        createdUser.setPassword(passwordEncoder.encode(password));
	        createdUser.setRole_id(role_id);
	        createdUser.setCreated_at(LocalDateTime.now());
	        createdUser.setUpdated_at(LocalDateTime.now());
	        createdUser.setAccessToken(token);
	        createdUser.setRefreshToken(token);
	        createdUser.setExpiredAccessToken(expiredAccressTokenTimestamp);
	        createdUser.setExpiredRefreshToken(expiredRefreshTokenTimestamp);
	        User savedUser= userRepository.save(createdUser);
	        if(savedUser != null) {
	        	Customer customer = new Customer();
		        customer.setCreated_at(LocalDateTime.now());
		        customer.setUpdated_at(LocalDateTime.now());
		        customer.setUser_id(createdUser.getUser_id());
		        Customer createdCustomer = customerService.createCustomer(customer);
		        if(createdCustomer != null) {
		        	 Cart cart = new Cart();
		 	        cart.setCreated_at(LocalDateTime.now());
		 	        cart.setCustomer_id(customer.getCustomer_id());
		 	        cart.setUpdated_at(LocalDateTime.now());
		 	        Cart createdCart = cartService.createCart(cart);
		        }
	        }
	        return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);	
	}

	@PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();        
        Authentication authentication = authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();	
		authResponse.setStatus(true);
		authResponse.setToken(token);
		System.err.println(authentication);
        return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);
    }
	
	private Authentication authenticate(String username, String password) {
        UserDetails userDetails = customUserDetails.loadUserByUsername(username);        
        if (userDetails == null) {
        	System.out.println("sign in userDetails - null " + userDetails);
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
        	System.out.println("sign in userDetails - password not match " + userDetails);
            throw new BadCredentialsException("Invalid username or password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
