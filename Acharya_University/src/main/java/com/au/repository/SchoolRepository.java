package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.Schools;

@Repository
public interface SchoolRepository extends JpaRepository<Schools, Integer> {

	// @Query("FROM Course c join CourseAssignment ca on c.course_id = ca.course_id
	// where ca.school_id=?1")
	// @Query(value="SELECT distinct course_short_name FROM tbl_au_course c inner
	// join tbl_au_course_assignment ca on c.course_id = ca.course_id where
	// ca.school_id=?1",nativeQuery=true)
	// public Schools findById123(int school_id);

}
