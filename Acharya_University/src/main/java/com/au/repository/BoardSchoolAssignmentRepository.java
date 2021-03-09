package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.Board_School_Assignment;

@Repository
public interface BoardSchoolAssignmentRepository extends JpaRepository<Board_School_Assignment, Integer>{

	
	@Query(value = "select board_id  from au_db1.tbl_au_board_school_assignment where school_id=?1",nativeQuery = true)
	public Integer getBoardBySchool(Integer school_id);
	
	
	@Query(value = "select distinct board_unique_name from tbl_au_board inner join \r\n"
			+ "	tbl_au_board_school_assignment\r\n"
			+ "		on tbl_au_board_school_assignment.board_id=tbl_au_board.board_unique_id \r\n"
			+ "        where tbl_au_board_school_assignment.school_id=?1",nativeQuery = true)
	public List<String> getBoardSchool(Integer school_id);
}
