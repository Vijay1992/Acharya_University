package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.model.Student;
import com.au.repository.Student_Repository;

@Service
@Transactional
public class Student_Service {

	@Autowired
	private Student_Repository stu_repo;
	
	public List<Student> listAll(){
		return stu_repo.findAll();
	}
	
	public Student save_Student(Student s) {
		return stu_repo.save(s);
	}
	
	public Student get(Integer id) {
        return stu_repo.findById(id).get();
    }
     
    public void delete(Integer id) {
    	stu_repo.deleteById(id);
    }
	
}
