package com.au.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.BoardSchoolAssignment;

@Repository
public interface BoardSchoolAssignmentRepository extends JpaRepository<BoardSchoolAssignment, Integer> {

	@Query(value = "select new map (boa.board_unique_name as board_unique_name ,boa.board_unique_short_name as board_unique_short_name)"
			+ " from BoardSchoolAssignment as bs left join Board as boa on boa.board_unique_id= bs.board_unique_id where bs.school_id =?1 and bs.active=true")
	public List<HashMap<String, Object>> findById1(Integer school_id);

	@Query(value = " SELECT count(*) FROM au_db1.tbl_au_board_school_assignment where school_id=?1 ", nativeQuery = true)
	public Integer findById123(Integer school_id);

}
