package com.example.jwt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.Dao.RoleDao;
import com.example.jwt.Entity.Role;

@Service
public class RoleService {

	@Autowired
	private RoleDao repo;
	
	public Role createNewRole(Role role) {
		return repo.save(role);
		
	}
	
}
