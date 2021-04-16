package com.au.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amazonaws.services.s3.AmazonS3;
import com.au.dto.Candidate_walkinRequest;
import com.au.exception.ResourceNotFoundException;
import com.au.model.ApplicantDetails;
import com.au.model.Candidate_Walkin;
import com.au.model.PGApplicable;
import com.au.model.StudentAttachments;
import com.au.repository.ApplicantDetailsRepository;
import com.au.repository.CandidateWalkinRepository;
import com.au.repository.PGApplicableRepository;
import com.au.repository.StudentAttachmentsRepository;

@Service
@Transactional
public class CandidateWalkInService {

	@Autowired
	private CandidateWalkinRepository can_repo;

	@Autowired
	AmazonClientService acs;

	@Autowired
	ApplicantDetailsRepository ap_repo;

	@Autowired
	StudentAttachmentsRepository sa_repo;

	@Autowired
	PGApplicableRepository pg_repo;

	private AmazonS3 s3client;

	private Logger logger = LoggerFactory.getLogger(AmazonClientService.class);
/*
	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;
	@Value("${amazonProperties.bucketName}")
	private String bucketName;
	@Value("${amazonProperties.accessKey}")
	private String accessKey;
	@Value("${amazonProperties.secretKey}")
	private String secretKey;

	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = new AmazonS3Client(credentials);
	}
*/
	public List<Candidate_Walkin> listAll() {
		return can_repo.findAll();
	}

	public Candidate_Walkin save_Candidate_Walkin(Candidate_Walkin c) {
		System.out.println("=====service");
		return can_repo.save(c);
	}

	public Candidate_Walkin getcandidates(Candidate_walkinRequest cd) {
		Candidate_Walkin c1=null;
		try {
		save_Candidate_Walkin(cd.getCd());
		
		ApplicantDetails ad = new ApplicantDetails();
		 c1 = can_repo.findByCandidateId(cd.getCd().getCandidate_id());

		ad.setCandidate_id(c1.getCandidate_id());
		ad.setStd_id(cd.getAd().getStd_id());
		ad.setAuid(cd.getAd().getAuid());
		ad.setBoard_university(cd.getAd().getBoard_university());
		ad.setCollege_name(cd.getAd().getCollege_name());
		ad.setModified_by(cd.getAd().getModified_by());
		ad.setModified_date(cd.getAd().getModified_date());
		ad.setEntrance_exam_name(cd.getAd().getEntrance_exam_name());
		ad.setEntrance_score(cd.getAd().getEntrance_score());
		ad.setFirst_language(cd.getAd().getFirst_language());
		ad.setMarks_total(cd.getAd().getMarks_total());
		ad.setModified_by(cd.getAd().getModified_by());
		ad.setModified_date(cd.getAd().getModified_date());
		ad.setPassed_year(cd.getAd().getPassed_year());
		ad.setPercentage_scored(cd.getAd().getPercentage_scored());
		ad.setQualifying_exam_year(cd.getAd().getQualifying_exam_year());
		ad.setQualifying_year(cd.getAd().getQualifying_year());
		ad.setRemarks(cd.getAd().getRemarks());
		ad.setSecond_language(cd.getAd().getSecond_language());
		ad.setState(cd.getAd().getState());
		ad.setSubjects_studied(cd.getAd().getSubjects_studied());
		ad.setTotal_obtained(cd.getAd().getTotal_obtained());
		ad.setYear_of_entrance(cd.getAd().getYear_of_entrance());
		System.out.println(ad);
		ap_repo.save(ad);		

		PGApplicable pg = new PGApplicable();
		c1 = can_repo.findByCandidateId(cd.getCd().getCandidate_id());

		pg.setCandidate_id(c1.getCandidate_id());
		pg.setPg_exam_passed_name(cd.getPgapp().getPg_exam_passed_name());
		pg.setPg_total_percentage(cd.getPgapp().getPg_total_percentage());
		pg.setUg_degree(cd.getPgapp().getUg_degree());
		pg.setUg_board(cd.getPgapp().getUg_board());
		pg.setStd_id(cd.getPgapp().getStd_id());
		pg.setSubject_studied_lang(cd.getPgapp().getSubject_studied_lang());
		pg.setUniversity(cd.getPgapp().getUniversity());
		pg.setYear_1(cd.getPgapp().getYear_1());
		pg.setYear_2(cd.getPgapp().getYear_2());
		pg.setYear_3(cd.getPgapp().getYear_3());
		pg.setYear_4(cd.getPgapp().getYear_4());
		pg.setYear_of_passing(cd.getPgapp().getYear_of_passing());
		pg.setAuid(cd.getPgapp().getAuid());
		pg.setCreated_by(cd.getPgapp().getCreated_by());
		pg.setModified_by(cd.getPgapp().getModified_by());
		pg.setModified_Date(cd.getPgapp().getModified_Date());
		pg.setRemarks(cd.getPgapp().getRemarks());
		pg_repo.save(pg);

		StudentAttachments stu_attach = new StudentAttachments();
		c1 = can_repo.findByCandidateId(cd.getCd().getCandidate_id());
	
		stu_attach.setCandidate_id(c1.getCandidate_id());
		stu_attach.setAttachments_subcategory_id(cd.getStu_attach().getAttachments_subcategory_id());
		stu_attach.setEducational_attach(cd.getStu_attach().getEducational_attach());
		stu_attach.setModified_by(cd.getStu_attach().getModified_by());
		stu_attach.setModified_date(cd.getStu_attach().getModified_date());
		stu_attach.setPersonal_attach(cd.getStu_attach().getPersonal_attach());
		stu_attach.setQualification_attach(cd.getStu_attach().getQualification_attach());
		stu_attach.setAttachments_file_name(cd.getStu_attach().getAttachments_file_name());
		stu_attach.setAttachments_file_path(cd.getStu_attach().getAttachments_file_path());		
		stu_attach.setStudent_id(cd.getStu_attach().getStudent_id());
		sa_repo.save(stu_attach);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return c1;
	}
/*
	public Candidate_Walkin uploadFilToAWS(Candidate_Walkin c) throws IOException {
		MultipartFile multipartFile = null;

		String fileUrl = "";
		try {
			File file = acs.convertMultiPartToFile(multipartFile);
			String fileName = acs.generateFileName(multipartFile);
			fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
			acs.uploadFileTos3bucket(fileName, file); // file.delete();
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
		return can_repo.save(c);
	}
*/
	
	public Candidate_Walkin get(Integer id) {
		return can_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate_Walkin Not Found:" + id));
	}

	public void delete(Integer id) {
		Candidate_Walkin ay = can_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate_Walkin Not Found:" + id));
		can_repo.delete(ay);
	}

}
