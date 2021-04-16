package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.AttachmentsCategory;

@Repository
public interface AttachmentsCategoryRepository extends JpaRepository<AttachmentsCategory, Integer> {

}
