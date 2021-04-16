package com.au.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.au.dto.FileRequest;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Attachments;
import com.au.repository.AttachmentsRepository;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

@Service
@Transactional
public class AttachmentsService {

	private Logger logger = LoggerFactory.getLogger(AttachmentsService.class);

	private AmazonS3 s3client;

	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;
	@Value("${amazonProperties.bucketName}")
	private String bucketName;
	@Value("${amazonProperties.accessKey}")
	private String accessKey;
	@Value("${amazonProperties.secretKey}")
	private String secretKey;
	@Value("${amazonProperties.keyexpression}")
	private String keyexpression;

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

	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = new AmazonS3Client(credentials);
	}

	public FileRequest uploadFile1(MultipartFile multipartFile) throws IOException {

		FileRequest filerequest = new FileRequest();
		try {
			File file = convertMultiPartToFile(multipartFile);
			String fileName = generateFileName(multipartFile);
			filerequest.setBucketName(bucketName);
			filerequest.setFileName(fileName);
			filerequest.setPath(bucketName + "/" + fileName);
			filerequest.setEndpointUrl(endpointUrl + "/" + bucketName + "/" + fileName);
			uploadFileTos3bucket(fileName, file);
			file.delete();
		} catch (AmazonServiceException ase) {

			logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());

		} catch (AmazonClientException ace) {
			logger.info("Caught an AmazonClientException: ");
			logger.info("Error Message: " + ace.getMessage());
		} catch (IOException ioe) {
			logger.info("IOE Error Message: " + ioe.getMessage());

		}
		return filerequest;

	}

	private void uploadFileTos3bucket(String fileName, File file) {
		final String uniqueFileName = keyexpression + "/" + LocalDate.now() + "/" + fileName; // file.getName()
		s3client.putObject(new PutObjectRequest(bucketName, uniqueFileName, file));
		// .withCannedAcl(CannedAccessControlList.PublicRead));
	}

	private String generateFileName(MultipartFile multiPart) {
		return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

}
