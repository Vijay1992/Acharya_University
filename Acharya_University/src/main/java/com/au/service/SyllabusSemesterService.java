
package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.SyllabusSemester;
import com.au.repository.SyllabusSemesterRepository;


@Service
@Transactional
public class SyllabusSemesterService {

	@Autowired
	private SyllabusSemesterRepository sy_repo;
	
	public List<SyllabusSemester> listAll(){
		return sy_repo.findAll();
	}
	
	public SyllabusSemester save_SyllabusSemester(SyllabusSemester syllabus) {
		return sy_repo.save(syllabus);
	}
	
	public SyllabusSemester get(Integer id) {
        return sy_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Syllabus semester id Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	SyllabusSemester ss = sy_repo.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Syllabus semester id Not Found:"+id));
		sy_repo.delete(ss);
    }
}
