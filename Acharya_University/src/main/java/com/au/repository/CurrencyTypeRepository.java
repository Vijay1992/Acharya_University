package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.CurrencyType;

@Repository
public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Integer> {

}
