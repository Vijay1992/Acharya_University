package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.PreAdmissionProcess;

@Repository
public interface PreAdmissionProcessRepository  extends JpaRepository<PreAdmissionProcess	, Integer>{

}
