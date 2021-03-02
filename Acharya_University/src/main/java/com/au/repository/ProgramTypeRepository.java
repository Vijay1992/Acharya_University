
package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.ProgramType;


@Repository
public interface ProgramTypeRepository extends JpaRepository<ProgramType, Integer>{

}
