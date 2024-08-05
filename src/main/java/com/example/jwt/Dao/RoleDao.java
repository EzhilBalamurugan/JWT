package com.example.jwt.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.Entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role,String>{

}
