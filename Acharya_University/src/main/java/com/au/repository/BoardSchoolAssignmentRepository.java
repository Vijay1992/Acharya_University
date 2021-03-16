package com.au.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.BoardSchoolAssignment;

@Repository
public interface BoardSchoolAssignmentRepository extends JpaRepository<BoardSchoolAssignment, Integer> {
	// @Query("select u.board_unique_name from tbl_au_board u inner join
	// u.tbl_au_board_school_assignment ar where ar.school_id = :school_id")
	@Query(value = "select board_unique_name from au_db1.tbl_au_board Inner Join tbl_au_board_school_assignment \r\n"
			+ "on tbl_au_board.board_unique_id=tbl_au_board_school_assignment.board_unique_id\r\n"
			+ " where tbl_au_board_school_assignment.school_id=?1", nativeQuery = true)
	public List<String> findById12(Integer school_id);

	@Query(value = " SELECT count(*) FROM au_db1.tbl_au_board_school_assignment where school_id=?1", nativeQuery = true)
	public Integer findById123(Integer school_id);
}
