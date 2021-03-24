package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Currency_Type;

@Repository
public interface CurrencyTypeRepository extends JpaRepository<Currency_Type, Integer>{

}
