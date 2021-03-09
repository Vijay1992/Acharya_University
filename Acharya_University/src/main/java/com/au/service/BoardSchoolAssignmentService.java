package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Board_School_Assignment;
import com.au.repository.BoardSchoolAssignmentRepository;

@Service
@Transactional
public class BoardSchoolAssignmentService {

	@Autowired
	private BoardSchoolAssignmentRepository bs_repo;

	public List<Board_School_Assignment> listAll(){
		return bs_repo.findAll();
	}
	
	public Board_School_Assignment save_Board_School_Assignment(Board_School_Assignment academic) {
		return bs_repo.save(academic);
	}
	
	public Board_School_Assignment get(Integer id) {
        return bs_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Board_School_Assignment Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Board_School_Assignment ay = bs_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Board_School_Assignment Not Found:"+id));    	
    	bs_repo.delete(ay);
    }

    public Integer getBoardBySchool(Integer school_id){
    	return bs_repo.getBoardBySchool(school_id);
    }
    
    public List<String> getBoardSchool(Integer school_id){
    	return bs_repo.getBoardSchool(school_id);
    }
    
}
