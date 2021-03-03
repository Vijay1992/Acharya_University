package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Tally;

@Repository
public interface TallyRepository extends JpaRepository<Tally, Integer> {

}
