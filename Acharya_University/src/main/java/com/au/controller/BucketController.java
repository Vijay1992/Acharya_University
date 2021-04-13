package com.au.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.au.dto.FileRequest;
import com.au.service.AmazonClientService;

@RestController
@RequestMapping("/api")
public class BucketController {

	private AmazonClientService amazonClient;

	@Autowired
	BucketController(AmazonClientService amazonClient) {
		this.amazonClient = amazonClient;
	}

	@PostMapping("/uploadFile")
	public FileRequest uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException {
		return this.amazonClient.uploadFile(file);
	}

	//https://s3.ap-southeast-1.amazonaws.com/demoacharyabucket/1613374923658-demopurpose.txt
	@DeleteMapping("/deleteFile")
	public String deleteFile(@RequestPart(value = "url") String fileUrl) {
		return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
	}
}