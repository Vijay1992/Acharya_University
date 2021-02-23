package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Major_struc;

@Repository
public interface Major_struc_Repository extends JpaRepository<Major_struc, Integer>{

}
