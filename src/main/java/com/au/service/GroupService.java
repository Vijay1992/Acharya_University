package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Academic_year;
import com.au.model.Group;
import com.au.repository.GroupRepository;

@Service
@Transactional
public class GroupService {

	@Autowired
	private GroupRepository gp;
	
	
	public List<Group> listAll(){
		return gp.findAll();
	}
	
	public Group save_Group(Group academic) {
		return gp.save(academic);
	}
	
	public Group get(Integer id) {
        return gp.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Group Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Group ay = gp.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Group Not Found:"+id));    	
    	gp.delete(ay);
    }
}
