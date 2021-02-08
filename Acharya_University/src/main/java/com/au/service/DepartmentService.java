package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public Department save_Department(Department dept) {
		return deptrepo.save(dept);
	}
	
	public Department get(Integer id) {
        return deptrepo.findById(id).get();
    }
     
    public void delete(Integer id) {
    	deptrepo.deleteById(id);
    }
}
