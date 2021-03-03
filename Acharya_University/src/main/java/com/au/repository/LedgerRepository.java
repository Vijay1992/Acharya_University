package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Ledger;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Integer> {

}
