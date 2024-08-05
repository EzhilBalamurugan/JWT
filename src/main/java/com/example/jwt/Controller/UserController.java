package com.example.jwt.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.Entity.User;
import com.example.jwt.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostConstruct
	public void initRolesAndUsers() {
		service.initRolesAndUser();
	}
	
	@PostMapping("/registerNewUser")
	public User registerNewUser(@RequestBody User user) {
		return service.registerNewUser(user);
	}
	
	
	@GetMapping("/forAdmin")
	public String forAdmin() {
		return "this url only accessible to Admin";
	}
	@GetMapping("/forUser")
	public String forUser() {
		return "this url only accessible to User";
	}
}
