package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Academic_year;

@Repository
public interface Academic_year_repository extends JpaRepository<Academic_year,Integer>{

}
