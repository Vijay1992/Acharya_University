package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Program_Master;

@Repository
public interface Program_Master_Repository extends JpaRepository<Program_Master, Integer>{ 

}
