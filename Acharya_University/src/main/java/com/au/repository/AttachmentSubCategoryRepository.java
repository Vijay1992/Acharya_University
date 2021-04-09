package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.AttachmentSubCategory;

@Repository
public interface AttachmentSubCategoryRepository extends JpaRepository<AttachmentSubCategory, Integer>{

}
