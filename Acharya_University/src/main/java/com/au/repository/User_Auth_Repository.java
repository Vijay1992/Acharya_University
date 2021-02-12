package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.UserAuthentication;

@Repository
public interface User_Auth_Repository  extends JpaRepository<UserAuthentication, Integer>{
	
	//@Query("select u from UserAuthentication u where u.username = ?1 ")
	UserAuthentication findByUsername(String username);
}
