
package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.model.Syllabus_semester;
import com.au.repository.Syllabus_Semester_Repository;


@Service
@Transactional
public class Syllabus_Semester_Service {

	@Autowired
	private Syllabus_Semester_Repository sy_repo;
	
	public List<Syllabus_semester> listAll(){
		return sy_repo.findAll();
	}
	
	public Syllabus_semester save_Syllabus_Semester(Syllabus_semester syllabus) {
		return sy_repo.save(syllabus);
	}
	
	public Syllabus_semester get(Integer id) {
        return sy_repo.findById(id).get();
    }
     
    public void delete(Integer id) {
    	sy_repo.deleteById(id);
    }
}
