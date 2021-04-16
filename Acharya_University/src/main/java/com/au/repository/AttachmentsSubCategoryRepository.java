package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.AttachmentsSubCategory;

@Repository
public interface AttachmentsSubCategoryRepository extends JpaRepository<AttachmentsSubCategory, Integer> {

}
