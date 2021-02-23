package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Graduation;

@Repository
public interface GraduationRepository extends JpaRepository<Graduation, Integer> {

}
