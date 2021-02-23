package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.CourseBranchAssignment;

@Repository
public interface CourseBranchAssignmentRepository extends JpaRepository<CourseBranchAssignment, Integer> {

}
