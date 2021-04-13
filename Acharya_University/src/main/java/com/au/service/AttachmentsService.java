package com.au.service;

import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Attachments;
import com.au.repository.AttachmentsRepository;

@Service
@Transactional
public class AttachmentsService {

	@Autowired
	private AttachmentsRepository ar_repo;

	public List<Attachments> listAll() {
		return ar_repo.findAll();
	}

	public Attachments saveAttachments(@Valid Attachments attachments) throws IOException {
		return ar_repo.save(attachments);
	}

	public Attachments get(Integer id) {
		if (id.equals(0)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return ar_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attachments id Not Found:" + id));
	}

	public void delete(Integer id) {
		Attachments ay = ar_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Attachments id Not Found:" + id));
		ar_repo.delete(ay);
	}

}
