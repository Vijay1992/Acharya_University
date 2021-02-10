package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.ProgramMaster;
import com.au.repository.ProgramMasterRepository;

@Service
@Transactional
public class ProgramMasterService {

	@Autowired
	private ProgramMasterRepository pr_repo;
	
	public List<ProgramMaster> listAll(){
		return pr_repo.findAll();
	}
	
	public ProgramMaster save_ProgramMaster(ProgramMaster academic) {
		return pr_repo.save(academic);
	}
	
	public ProgramMaster get(Integer id) {
        return pr_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Program Master Not Found:"+id));
    }
     
    public void delete(Integer id) {
     ProgramMaster pm =	pr_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Program Master Not Found:"+id));    	
    	pr_repo.delete(pm);
    }
}
