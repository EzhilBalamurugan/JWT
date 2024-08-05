package com.example.jwt.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.Entity.User;

@Repository
public interface UserDao extends CrudRepository<User,String> {

}
