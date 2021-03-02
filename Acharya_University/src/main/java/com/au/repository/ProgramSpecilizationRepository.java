package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.ProgramSpecilization;

@Repository
public interface ProgramSpecilizationRepository extends JpaRepository<ProgramSpecilization, Integer>{

}
