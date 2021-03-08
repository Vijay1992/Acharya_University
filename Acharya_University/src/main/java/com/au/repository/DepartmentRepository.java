package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	
	
}
