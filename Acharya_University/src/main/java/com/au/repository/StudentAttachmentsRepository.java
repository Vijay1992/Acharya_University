package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.au.model.PGApplicable;
import com.au.model.StudentAttachments;

@Repository
public interface StudentAttachmentsRepository extends JpaRepository<StudentAttachments, Integer>{

	
	//public StudentAttachments save(MultipartFile file) ;

	
	@Query(value = "SELECT * FROM tbl_au_student_attachment where student_attachments_id=?1",nativeQuery = true)
	public StudentAttachments findByStuId(Integer student_attachments_id);
}
