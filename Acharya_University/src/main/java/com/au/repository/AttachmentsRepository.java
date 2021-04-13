package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.Attachments;

@Repository
public interface AttachmentsRepository extends JpaRepository<Attachments, Integer> {

}
