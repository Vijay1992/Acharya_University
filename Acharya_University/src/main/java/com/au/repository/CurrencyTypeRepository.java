package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.Currency_Type;

@Repository
public interface CurrencyTypeRepository extends JpaRepository<Currency_Type, Integer>{

	
	@Query(value = "SELECT * FROM tbl_au_currency_type where active=1",nativeQuery =  true)
	public	List<Currency_Type>  findAll();
	
}
