package com.au.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ProgramSpecilizationNotFoundException;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Academic_year;
import com.au.model.ProgramSpecilization;
import com.au.repository.ProgramSpecilizationRepository;

@Service
@Transactional
public class ProgramSpecilizationService {

	@Autowired
	private ProgramSpecilizationRepository ps_repo;
	
	public List<ProgramSpecilization> listAll(){
		return ps_repo.findAll();
	}
	
	public ProgramSpecilization save_ProgramSpecilization(ProgramSpecilization p)
	{
		if(getProgramSpecilization(p.getSchool_id(), p.getDept_id(), p.getProgram_id(), p.getAuid_format())>=1) {
			throw new RuntimeException("ProgramSpecilization already Exist");
			//throw new ProgramSpecilizationNotFoundException("ProgramSpecilization already Exist");
		}
		else
		{
			return ps_repo.save(p);
		}
	}
	
	public ProgramSpecilization get(Integer id) {
        return ps_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("ProgramSpecilization Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	ProgramSpecilization ay = ps_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("ProgramSpecilization Not Found:"+id));    	
    	ps_repo.delete(ay);
    }
    
    
    public List<ProgramSpecilization> get1(){
		return ps_repo.findAll();
	}

	public List<ProgramSpecilization> findById(Integer id1, Integer id2) {
		// TODO Auto-generated method stub
		return ps_repo.findById1(id1, id2);
	}

	public Integer countRecords(Integer id) {
		// TODO Auto-generated method stub
		return ps_repo.findById2(id);
	}
    
	public Integer getProgramSpecilization(Integer school_id,Integer dept_id,
			Integer program_id,String auid_format) {
		return ps_repo.getProgramSpecilization(school_id, dept_id, program_id, auid_format);
	}
}
