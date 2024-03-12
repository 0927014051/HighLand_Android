package com.javaweb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.Category;
import com.javaweb.entity.Role;
import com.javaweb.service.RoleService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private RoleService roleService;

	public AdminController(RoleService roleService) {
		this.roleService = roleService;
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
	
}
