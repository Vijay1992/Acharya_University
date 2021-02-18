package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Schools;

@Repository
public interface SchoolRepository  extends JpaRepository<Schools, Integer>{

}