package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.AliasName;

@Repository
public interface AliasNameRepository extends JpaRepository<AliasName, Integer> {

	
	@Query(value = "SELECT * FROM tbl_au_alias_name where active=true",nativeQuery =  true)
	public	List<AliasName>  findAll();
	
}
