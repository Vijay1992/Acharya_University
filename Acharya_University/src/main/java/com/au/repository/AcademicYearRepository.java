package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.AcademicYear;

@Repository
public interface AcademicYearRepository extends JpaRepository<AcademicYear, Integer> {

}
