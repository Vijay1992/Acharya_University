package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.StudentAttachments;

@Repository
public interface StudentAttachmentsRepository extends JpaRepository<StudentAttachments, Integer>{

}
