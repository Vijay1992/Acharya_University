package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.ProgramTranscriptDetails;
import com.au.repository.ProgramTranscriptDetailsRepository;

@Service
@Transactional
public class ProgramTranscriptDetailsService {

	@Autowired
	private ProgramTranscriptDetailsRepository p_repo;

	

	public List<ProgramTranscriptDetails> listAll(){
		return p_repo.findAll();
	}
	
	public  Integer getProgramTranscriptDetails(String name,Integer program_id) {
		return p_repo.getProgramTranscriptDetails(name,program_id);
	}
	
	public ProgramTranscriptDetails saveProgramTranscriptDetails(ProgramTranscriptDetails p) 
	{
		Integer tdCount = p_repo.getProgramTranscriptDetails(p.getTranscript_details(),p.getProgram_id());
		
		if(tdCount>=1) 
		{
			//System.out.println("Trascription already exist");
			throw new RuntimeException("Trascription already exist");
		}
		else
		{
		return	p_repo.save(p);
		}
		
	}
	/*
		String name = p.getTranscript_details();
		System.out.println("-------TRANS--------"+transcript_details);
		System.out.println("======DETAILS======"+p.getTranscript_details());
		
		
		for(int i=0;i<transcript_details.size();i++) {
			if(name.contains((CharSequence) transcript_details)) {
				System.out.println("Exist");
			}
			else {
				return p_repo.save(p);
			}
		}
		*/
		
	
	public ProgramTranscriptDetails get(Integer id) {
        return p_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("ProgramTranscriptDetails Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	ProgramTranscriptDetails ay = p_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("ProgramTranscriptDetails Not Found:"+id));    	
    	p_repo.delete(ay);
    }
}
