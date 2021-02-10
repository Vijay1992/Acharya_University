package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.CreditSystem;

@Repository
public interface CreditSystemRepository extends JpaRepository<CreditSystem, Integer> {

}
