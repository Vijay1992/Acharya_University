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
@Table(name = "tbl_au_attachments_category")
public class AttachmentsCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attachments_category_id;
	private String attachments_category_name;
	private String attachments_category_name_short;
	private Integer created_by;
	private Integer modified_by;
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_date;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_date;
	private Boolean active;

	public AttachmentsCategory() {
		super();
	}

	public Integer getAttachments_category_id() {
		return attachments_category_id;
	}

	public void setAttachments_category_id(Integer attachments_category_id) {
		this.attachments_category_id = attachments_category_id;
	}

	public String getAttachments_category_name() {
		return attachments_category_name;
	}

	public void setAttachments_category_name(String attachments_category_name) {
		this.attachments_category_name = attachments_category_name;
	}

	public String getAttachments_category_name_short() {
		return attachments_category_name_short;
	}

	public void setAttachments_category_name_short(String attachments_category_name_short) {
		this.attachments_category_name_short = attachments_category_name_short;
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

}
