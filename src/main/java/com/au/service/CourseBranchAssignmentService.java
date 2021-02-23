package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.CourseBranchAssignment;
import com.au.repository.CourseBranchAssignmentRepository;

@Service
@Transactional
public class CourseBranchAssignmentService {

	@Autowired
	private CourseBranchAssignmentRepository cba_repo;
	
	public List<CourseBranchAssignment> listAll(){
		return cba_repo.findAll();
	}
	
	public CourseBranchAssignment save_CourseBranchAssignment(CourseBranchAssignment academic) {
		return cba_repo.save(academic);
	}
	
	public CourseBranchAssignment get(Integer id) {
        return cba_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("CourseBranchAssignment Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	CourseBranchAssignment ay = cba_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("CourseBranchAssignment Not Found:"+id));    	
    	cba_repo.delete(ay);
    }
}