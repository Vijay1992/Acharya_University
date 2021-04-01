package com.au.model;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_au_voucher_head")
public class VoucherHead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer voucher_head_id;
//	@NotBlank
	private String voucher_head;
//	private HashMap<Integer, String>  school_id;    //fk
//	@NotNull
	private Integer  school_id;   
	private Integer tally_id;     //fk

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
//	@NotBlank
	private String ledger_id;
//	@NotBlank
	private String voucher_type;
//	@NotBlank
	private String budget_head;
	
	public VoucherHead() {
		super();
	}

	public VoucherHead(Integer voucher_head_id, String voucher_head, Integer school_id, Integer tally_id,
			Integer created_by, Integer modified_by, Date created_date, Date modified_date, Boolean active,
			String ledger_id, String voucher_type, String budget_head) {
		super();
		this.voucher_head_id = voucher_head_id;
		this.voucher_head = voucher_head;
		this.school_id = school_id;
		this.tally_id = tally_id;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.active = active;
		this.ledger_id = ledger_id;
		this.voucher_type = voucher_type;
		this.budget_head = budget_head;
	}

	public Integer getVoucher_head_id() {
		return voucher_head_id;
	}

	public void setVoucher_head_id(Integer voucher_head_id) {
		this.voucher_head_id = voucher_head_id;
	}

	public String getVoucher_head() {
		return voucher_head;
	}

	public void setVoucher_head(String voucher_head) {
		this.voucher_head = voucher_head;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public Integer getTally_id() {
		return tally_id;
	}

	public void setTally_id(Integer tally_id) {
		this.tally_id = tally_id;
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

	public String getLedger_id() {
		return ledger_id;
	}

	public void setLedger_id(String ledger_id) {
		this.ledger_id = ledger_id;
	}

	public String getVoucher_type() {
		return voucher_type;
	}

	public void setVoucher_type(String voucher_type) {
		this.voucher_type = voucher_type;
	}

	public String getBudget_head() {
		return budget_head;
	}

	public void setBudget_head(String budget_head) {
		this.budget_head = budget_head;
	}

	
	
	
}
