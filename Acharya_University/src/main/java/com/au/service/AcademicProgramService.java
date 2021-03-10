package com.au.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.AcademicProgram;
import com.au.repository.AcademicProgramRepository;

@Service
@Transactional
public class AcademicProgramService {

	private AcademicProgramRepository ap_repo;

	public AcademicProgramService(AcademicProgramRepository ap_repo) {
		this.ap_repo = ap_repo;
	} 
	
	public List<AcademicProgram> listAll(){
		return ap_repo.findAll();
	}
	
	public AcademicProgram save_AcademicProgram(AcademicProgram academic) {
		return ap_repo.save(academic);
	}
	
	public AcademicProgram get(Integer id) {
        return ap_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("AcademicProgram Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	AcademicProgram ay = ap_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("AcademicProgram Not Found:"+id));    	
    	ap_repo.delete(ay);
    }
    
    public List<Integer[]> getNumOfSemAndYearByProgram_IdAndAcYear_Id(Integer program_id,Integer ac_year_id){
    	return ap_repo.getNumOfSemAndYearByProgram_IdAndAcYear_Id(program_id, ac_year_id);
    }
}
