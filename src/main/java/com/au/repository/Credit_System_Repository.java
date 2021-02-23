package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.Credit_System;

@Repository
public interface Credit_System_Repository extends JpaRepository<Credit_System, Integer>{

}
