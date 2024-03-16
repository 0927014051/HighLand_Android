package com.javaweb.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.Category;
import com.javaweb.entity.Role;
import com.javaweb.entity.Staff;
import com.javaweb.entity.Topping;
import com.javaweb.entity.User;
import com.javaweb.exception.UserException;
import com.javaweb.service.RoleService;
import com.javaweb.service.StaffService;
import com.javaweb.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	private RoleService roleService;
	private UserService userService;
	private StaffService staffService;
	
	
	public AdminController(RoleService roleService, UserService userService, StaffService staffService) {
		super();
		this.roleService = roleService;
		this.userService = userService;
		this.staffService = staffService;
	}

	@PostMapping("/role/add")
	public ResponseEntity<Role> createRoleHanlder(@RequestBody Map <String, Object> roleObjects ){
		Role role = new Role();
		String roleName = null;
		 if (roleObjects.containsKey("role_name")) {
			 roleName   = (String) roleObjects.get("role_name");
	     }
		role.setRole_name(roleName);
		Role createdRole = roleService.createRole(role);
		return new ResponseEntity<Role>(createdRole,HttpStatus.ACCEPTED);
	}
	
//	@PostMapping("/topping/add")
//	public ResponseEntity<Topping> createToppingHalder(@RequestBody Map<String, Object> toppingMap,@RequestHeader("Authorization") String jwt) throws UserException{
//		User user = userService.findUserByJwt(jwt);
//		Staff staff = staffService.findStaffByUserId(user.getUser_id());
//		Topping topping = new Topping();
//		String toppingName = null;
//		int price = 0;
//		if(toppingMap.containsKey("topping_name")) {
//			toppingName = (String) toppingMap.get("topping_name");
//		}
//		if(toppingMap.containsKey("price")) {
//			price = (int) toppingMap.get("price");
//		}
//		topping.setTopping_name(toppingName);
//		topping.setCreated_at(LocalDateTime.now());
//		topping.setCreated_by(staff.getStaff_id());
//		topping.setUpdated_at(LocalDateTime.now());
//		topping.setUpdated_by(staff.getStaff_id());
//		
//	}
	
}
