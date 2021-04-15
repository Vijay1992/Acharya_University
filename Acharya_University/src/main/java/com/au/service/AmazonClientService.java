package com.au.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.au.dto.FileRequest;

@Service
public class AmazonClientService {

	private AmazonS3 s3client;

	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;
	@Value("${amazonProperties.bucketName}")
	private String bucketName;
	@Value("${amazonProperties.accessKey}")
	private String accessKey;
	@Value("${amazonProperties.secretKey}")
	private String secretKey;

	private final long EXPIRATION_TIME = 1000 * 60 * 60;

	private Logger logger = LoggerFactory.getLogger(AmazonClientService.class);

	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = new AmazonS3Client(credentials);
	}

	public FileRequest uploadFile(MultipartFile multipartFile) throws IOException {

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

	public String deleteFileFromS3Bucket(String fileUrl) {
		try {
			String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
			System.out.println(fileName);
			//s3client.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
			 s3client.deleteObject(bucketName, fileName);
			 System.out.println("enter in try block");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Successfully deleted";
	}

	private void uploadFileTos3bucket(String fileName, File file) {
		final String uniqueFileName = LocalDate.now() + "/" + fileName; // file.getName()
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

/*
 * 
 * String fileUrl = ""; try { File file = convertMultiPartToFile(multipartFile);
 * String fileName = generateFileName(multipartFile); fileUrl = endpointUrl +
 * "/" + bucketName + "/" + fileName; uploadFileTos3bucket(fileName, file);
 * file.delete(); }
 */ /*
	 * catch (Exception e) { e.printStackTrace(); }
	 */ /*
		 * catch (AmazonServiceException ase) { logger.
		 * info("Caught an AmazonServiceException from GET requests, rejected reasons:"
		 * ); logger.info("Error Message:    " + ase.getMessage());
		 * logger.info("HTTP Status Code: " + ase.getStatusCode());
		 * logger.info("AWS Error Code:   " + ase.getErrorCode());
		 * logger.info("Error Type:       " + ase.getErrorType());
		 * logger.info("Request ID:       " + ase.getRequestId());
		 * 
		 * 
		 * } catch (AmazonClientException ace) {
		 * logger.info("Caught an AmazonClientException: ");
		 * logger.info("Error Message: " + ace.getMessage()); } catch (IOException ioe)
		 * { logger.info("IOE Error Message: " + ioe.getMessage());
		 * 
		 * } return fileUrl;
		 */