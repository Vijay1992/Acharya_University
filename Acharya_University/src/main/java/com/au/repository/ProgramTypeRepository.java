package com.au.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.ProgramType;

@Repository
public interface ProgramTypeRepository extends JpaRepository<ProgramType, Integer> {

	@Query(value = "SELECT * FROM tbl_au_program_type where active=1", nativeQuery = true)
	public List<ProgramType> findAll();

}
