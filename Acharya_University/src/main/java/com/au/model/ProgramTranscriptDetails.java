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
@Table(name = "tbl_au_transcrption_details")
public class ProgramTranscriptDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transcript_id;
	private String transcript_details;
	private String transcript_short_name;
	private Integer program_id;
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
	
	private Boolean active;
	
	private Integer foriegn_status;

	public ProgramTranscriptDetails() {
		super();
	}

	public Integer getTranscript_id() {
		return transcript_id;
	}

	public void setTranscript_id(Integer transcript_id) {
		this.transcript_id = transcript_id;
	}

	public String getTranscript_details() {
		return transcript_details;
	}

	public void setTranscript_details(String transcript_details) {
		this.transcript_details = transcript_details;
	}

	public String getTranscript_short_name() {
		return transcript_short_name;
	}

	public void setTranscript_short_name(String transcript_short_name) {
		this.transcript_short_name = transcript_short_name;
	}

	public Integer getProgram_id() {
		return program_id;
	}

	public void setProgram_id(Integer program_id) {
		this.program_id = program_id;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getForiegn_status() {
		return foriegn_status;
	}

	public void setForiegn_status(Integer foriegn_status) {
		this.foriegn_status = foriegn_status;
	}

	@Override
	public String toString() {
		return "ProgramTranscriptDetails [transcript_id=" + transcript_id + ", transcript_details=" + transcript_details
				+ ", transcript_short_name=" + transcript_short_name + ", program_id=" + program_id + ", created_by="
				+ created_by + ", modified_by=" + modified_by + ", created_date=" + created_date + ", modified_date="
				+ modified_date + ", active=" + active + ", foriegn_status=" + foriegn_status + "]";
	}
}
