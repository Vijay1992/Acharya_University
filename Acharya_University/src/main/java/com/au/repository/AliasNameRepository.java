package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.AliasName;

@Repository
public interface AliasNameRepository extends JpaRepository<AliasName, Integer> {

}
