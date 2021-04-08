package com.au.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
	
    // @Query(value = "select r from Roles r where role_id=?1")
		//public List<Roles> findByroleId(Integer role_id);

}
