package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.TallyHead;

@Repository
public interface TallyHeadRepository extends JpaRepository<TallyHead,Integer>{

}
