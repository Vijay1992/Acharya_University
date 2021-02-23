package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Year_Sem;

@Repository
public interface Year_Sem_Repository extends JpaRepository<Year_Sem	,Integer>{

}
