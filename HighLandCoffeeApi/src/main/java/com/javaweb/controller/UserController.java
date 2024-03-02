package com.javaweb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.Customer;
import com.javaweb.entity.User;
import com.javaweb.exception.UserException;
import com.javaweb.request.ProfileUserRequest;
import com.javaweb.response.ProfileUserAndCustomerResponse;
import com.javaweb.service.CustomerService;
import com.javaweb.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;
	private CustomerService customerService;

	public UserController(UserService userService,CustomerService customerService) {
		this.userService = userService;
		this.customerService = customerService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsersHandler() throws UserException{
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/profile")
	public ResponseEntity<ProfileUserRequest> getUserProfileAndCustomerProfileHandler(@RequestHeader("Authorization") String jwt) throws UserException{
		System.err.println("/api/users/profile");
		System.err.println("println jwt: " + jwt);
		ProfileUserRequest profileUserResponse = userService.findUserProfileByJwt(jwt);
		return new ResponseEntity<ProfileUserRequest>(profileUserResponse,HttpStatus.ACCEPTED);	
	}
	
	  @PutMapping("/profile/update")
	    public ResponseEntity<ProfileUserAndCustomerResponse> updateUserAndCustomerProfileHandler  (
	            @RequestHeader("Authorization") String jwt, @RequestBody ProfileUserRequest update) throws UserException{
	        try {
	            // Update user and customer profile using userService
	        	ProfileUserAndCustomerResponse res =   userService.updateUserAndCustomerProfileByJwt(jwt, update);


	            // Return ResponseEntity with success message and updated profile
	            return new ResponseEntity<ProfileUserAndCustomerResponse>(res, HttpStatus.OK);
	        } catch (UserException e) {
	            // Return ResponseEntity with error message if UserException is thrown
	            return new ResponseEntity<ProfileUserAndCustomerResponse>(HttpStatus.NOT_FOUND); // Or appropriate error status
	        }
	    }
	
	
	
	
}
