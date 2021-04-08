package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.UserAuthentication;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, Integer> {

}
