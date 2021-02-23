package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Graduation;

@Repository
public interface Graduation_Repository extends JpaRepository<Graduation	, Integer>{

}
