package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.DeptNotFoundException;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Course_Type;
import com.au.model.Department;
import com.au.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService 
{

	@Autowired
	DepartmentRepository deptrepo;
	
	public List<Department> listAll(){
		return deptrepo.findAll();
	}
	
	public ResponseEntity<Department> save_Department(Department dept) {
		
		if(getDeptCountByDnameSchool(dept.getDept_name(), dept.getSchool_id())>=1)
		{
			throw new DeptNotFoundException("Department already exist");
		}
		else
		{
	//		 deptrepo.save(dept);
			 return new  ResponseEntity<Department>(deptrepo.save(dept), HttpStatus.OK);
		}
	}
	
	public Department get(Integer id) {
        return deptrepo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Department Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Department dept = deptrepo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Department Not Found:"+id));    	
    	deptrepo.delete(dept);
    }
    
    public Integer getDeptCountByDnameSchool(String dept_name,Integer school_id) {
    	return deptrepo.getDeptCountByDnameSchool(dept_name, school_id);
    }
}
