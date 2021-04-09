package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.AttachmentCategory;

@Repository
public interface AttachmentCategoryRepository  extends JpaRepository<AttachmentCategory, Integer>{

}
