package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program,Integer> {

}
