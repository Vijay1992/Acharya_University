package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Graduation;
import com.au.repository.Graduation_Repository;

@Service
@Transactional
public class Graduation_Service {

	@Autowired
	private Graduation_Repository gr;

	
	public List<Graduation> listAll(){
		return gr.findAll();
	}
	
	public Graduation save_Graduation(Graduation g) {
		return gr.save(g);
	}
	
	public Graduation get(Integer id) {
        return gr.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Graduation Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Graduation ay = gr.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Graduation  Not Found:"+id));    	
    	gr.delete(ay);
    }
	
}
