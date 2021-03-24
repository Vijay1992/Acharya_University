package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.au.model.Program;

@Repository
@Transactional
public interface ProgramRepository extends JpaRepository<Program,Integer> {


	@Query("SELECT u FROM Program u where u.school_id=?1")
	public List<Program> findBySchoolId(Integer school_id);

	
	 @Query("select count(u) from Program u where u.school_id=?1")
	public Integer countRecords(Integer id);
	
}
