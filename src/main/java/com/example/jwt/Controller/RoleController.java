package com.example.jwt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.Entity.Role;
import com.example.jwt.Service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService service;
	
	@PostMapping("/createNewRole")
	public Role createNewRole(@RequestBody Role role) {
		return service.createNewRole(role);
	}
	
}
