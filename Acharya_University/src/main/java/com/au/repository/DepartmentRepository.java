package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>
{

	@Query(value = "SELECT count(*) FROM tbl_au_dept where dept_name=?1 and school_id=?2 and active=1",nativeQuery = true)
	public Integer getDeptCountByDnameSchool(String dept_name,Integer school_id);
	
}
