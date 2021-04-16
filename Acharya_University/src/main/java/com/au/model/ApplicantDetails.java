package com.au.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_au_applicant_details")
public class ApplicantDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer applicant_id;
	
	private String qualifying_exam_year;
	private Integer std_id;
	private String board_university;
	private String college_name;
	private String subjects_studied;
	private Integer marks_total;
	private Integer total_obtained;
	private float percentage_scored;
	private String entrance_exam_name;
	private String state;
	private Integer year_of_entrance;
	private float entrance_score;
	private String first_language;
	private String second_language;
	private String auid;
	private Integer created_by;
	private Integer modified_by;

	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;
	
	@Temporal(TemporalType.DATE) 
	private Date qualifying_year;

	private String remarks;
	private Integer passed_year;
	private Integer candidate_id;
	                
	public ApplicantDetails() {
		super();
	}
	
	
	public ApplicantDetails(Integer applicant_id, String qualifying_exam_year, Integer std_id, String board_university,
			String college_name, String subjects_studied, Integer marks_total, Integer total_obtained,
			float percentage_scored, String entrance_exam_name, String state, Integer year_of_entrance,
			float entrance_score, String first_language, String second_language, String auid, Integer created_by,
			Integer modified_by, Date created_date, Date modified_date, Date qualifying_year, String remarks,
			Integer passed_year, Integer candidate_id) {
		super();
		this.applicant_id = applicant_id;
		this.qualifying_exam_year = qualifying_exam_year;
		this.std_id = std_id;
		this.board_university = board_university;
		this.college_name = college_name;
		this.subjects_studied = subjects_studied;
		this.marks_total = marks_total;
		this.total_obtained = total_obtained;
		this.percentage_scored = percentage_scored;
		this.entrance_exam_name = entrance_exam_name;
		this.state = state;
		this.year_of_entrance = year_of_entrance;
		this.entrance_score = entrance_score;
		this.first_language = first_language;
		this.second_language = second_language;
		this.auid = auid;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.qualifying_year = qualifying_year;
		this.remarks = remarks;
		this.passed_year = passed_year;
		this.candidate_id = candidate_id;
	}


	public Integer getApplicant_id() {
		return applicant_id;
	}


	public void setApplicant_id(Integer applicant_id) {
		this.applicant_id = applicant_id;
	}


	public String getQualifying_exam_year() {
		return qualifying_exam_year;
	}
	public void setQualifying_exam_year(String qualifying_exam_year) {
		this.qualifying_exam_year = qualifying_exam_year;
	}
	
	public Integer getStd_id() {
		return std_id;
	}


	public void setStd_id(Integer std_id) {
		this.std_id = std_id;
	}


	public String getBoard_university() {
		return board_university;
	}
	public void setBoard_university(String board_university) {
		this.board_university = board_university;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getSubjects_studied() {
		return subjects_studied;
	}
	public void setSubjects_studied(String subjects_studied) {
		this.subjects_studied = subjects_studied;
	}
	public Integer getMarks_total() {
		return marks_total;
	}
	public void setMarks_total(Integer marks_total) {
		this.marks_total = marks_total;
	}
	public Integer getTotal_obtained() {
		return total_obtained;
	}
	public void setTotal_obtained(Integer total_obtained) {
		this.total_obtained = total_obtained;
	}
	public float getPercentage_scored() {
		return percentage_scored;
	}
	public void setPercentage_scored(float percentage_scored) {
		this.percentage_scored = percentage_scored;
	}
	public String getEntrance_exam_name() {
		return entrance_exam_name;
	}
	public void setEntrance_exam_name(String entrance_exam_name) {
		this.entrance_exam_name = entrance_exam_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getYear_of_entrance() {
		return year_of_entrance;
	}
	public void setYear_of_entrance(Integer year_of_entrance) {
		this.year_of_entrance = year_of_entrance;
	}
	public float getEntrance_score() {
		return entrance_score;
	}
	public void setEntrance_score(float entrance_score) {
		this.entrance_score = entrance_score;
	}
	public String getFirst_language() {
		return first_language;
	}
	public void setFirst_language(String first_language) {
		this.first_language = first_language;
	}
	public String getSecond_language() {
		return second_language;
	}
	public void setSecond_language(String second_language) {
		this.second_language = second_language;
	}
	public String getAuid() {
		return auid;
	}
	public void setAuid(String auid) {
		this.auid = auid;
	}
	public Integer getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}
	public Integer getModified_by() {
		return modified_by;
	}
	public void setModified_by(Integer modified_by) {
		this.modified_by = modified_by;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	
	
	
	public Date getQualifying_year() {
		return qualifying_year;
	}
	public void setQualifying_year(Date qualifying_year) {
		this.qualifying_year = qualifying_year;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getPassed_year() {
		return passed_year;
	}
	public void setPassed_year(Integer passed_year) {
		this.passed_year = passed_year;
	}
	public Integer getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(Integer candidate_id) {
		this.candidate_id = candidate_id;
	}


	@Override
	public String toString() {
		return "ApplicantDetails [applicant_id=" + applicant_id + ", qualifying_exam_year=" + qualifying_exam_year
				+ ", std_id=" + std_id + ", board_university=" + board_university + ", college_name=" + college_name
				+ ", subjects_studied=" + subjects_studied + ", marks_total=" + marks_total + ", total_obtained="
				+ total_obtained + ", percentage_scored=" + percentage_scored + ", entrance_exam_name="
				+ entrance_exam_name + ", state=" + state + ", year_of_entrance=" + year_of_entrance
				+ ", entrance_score=" + entrance_score + ", first_language=" + first_language + ", second_language="
				+ second_language + ", auid=" + auid + ", created_by=" + created_by + ", modified_by=" + modified_by
				+ ", created_date=" + created_date + ", modified_date=" + modified_date + ", qualifying_year="
				+ qualifying_year + ", remarks=" + remarks + ", passed_year=" + passed_year + ", candidate_id="
				+ candidate_id + "]";
	}

	
	
}