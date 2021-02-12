package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.UserAuthentication;

@Repository
public interface AuthenticationRepository extends JpaRepository<UserAuthentication, Integer> {
    
	
	@Query("select u from UserAuthentication u where u.username=:username")	
	UserAuthentication findByUsername(String username);

}
