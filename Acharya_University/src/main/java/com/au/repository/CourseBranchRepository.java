package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.CourseBranch;

@Repository
public interface CourseBranchRepository extends JpaRepository<CourseBranch	, Integer>{

}
