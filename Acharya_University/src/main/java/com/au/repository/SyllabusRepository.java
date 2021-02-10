package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Syllabus;

@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus, Integer> {

}
