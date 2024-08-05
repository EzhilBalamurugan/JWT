package com.example.jwt.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwt.Dao.RoleDao;
import com.example.jwt.Dao.UserDao;
import com.example.jwt.Entity.Role;
import com.example.jwt.Entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao repo;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PasswordEncoder encoder;
	
	public User registerNewUser(User user) {
		return repo.save(user);
	}
	public void initRolesAndUser() {
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleDao.save(adminRole);
		
		Role userRole=new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("User Role");
		roleDao.save(userRole);
		
		User adminUser = new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@123"));
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		repo.save(adminUser);
		
		User user = new User();
		user.setUserFirstName("ezhil");
		user.setUserLastName("bala");
		user.setUserName("ezhil123");
		user.setUserPassword(getEncodedPassword("ezhil@pass"));
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		repo.save(user);
	}
	public String getEncodedPassword(String password) {
		return encoder.encode(password);
	}
}
