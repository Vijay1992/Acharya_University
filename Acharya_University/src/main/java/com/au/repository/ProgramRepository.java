package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program,Integer> {
	
	@Query("SELECT u FROM Program u where u.school_id=?1 and active=1")
	public List<Program> findById123(Integer school_id);
	
	//@Query("SELECT count(u) FROM Program u where u.school_id=?1")
	//public Integer findById12(Integer school_id);
	
	
	@Query(value=" SELECT count(*) FROM tbl_au_program where school_id=?1",nativeQuery = true)
	public Integer findById12(Integer school_id);

}
