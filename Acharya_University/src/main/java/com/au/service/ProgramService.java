package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ProgramNotFoundException;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Program;
import com.au.model.Schools;
import com.au.repository.ProgramRepository;

@Service
@Transactional
public class ProgramService {
	
	@Autowired
	private ProgramRepository pro_repo;
	
	public List<Program> listAll(){
		return pro_repo.findAll();
	}
	
	public ResponseEntity<Program> save_ProgramType(Program p) {
		if(getProgramByPnameSchool(p.getProgram_name(), p.getSchool_id())>=1)
		{
			throw new ProgramNotFoundException("Program already exist");
		}
		else {		
		//	return pro_repo.save(p);
			return new ResponseEntity<Program>(pro_repo.save(p),HttpStatus.OK);
		}
	}
	
	public Program get(Integer id) {
        return pro_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("ProgramType Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Program p=pro_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("ProgramType Not Found:"+id));    	
    	pro_repo.delete(p);
    }

	public List<Program> findById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		return pro_repo.findBySchoolId(id);
	}

	public Integer countRecords(Integer id) {
		// TODO Auto-generated method stub
		return pro_repo.countRecords(id);
	}
	
	public Integer getProgramByPnameSchool(String program_name,Integer school_id) {
		return pro_repo.getProgramByPnameSchool(program_name, school_id);
	}
}