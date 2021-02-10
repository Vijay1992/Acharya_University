package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Student;
import com.au.repository.StudentRepository;


@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository stu_repo;
	
	public List<Student> listAll(){
		return stu_repo.findAll();
	}
	
	public Student save_Student(Student s) {
		return stu_repo.save(s);
	}
	
	public Student get(Integer id) {
        return stu_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Student Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Student s =stu_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Student Not Found:"+id));    	
    	stu_repo.delete(s);
    }
	
}
