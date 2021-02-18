package com.au.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name ="tbl_au_organization")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int org_id;
	@NotBlank
	private String org_name;
	@NotBlank
	private String org_type;

	public Organization(int org_id, @NotBlank String org_name, @NotBlank String org_type) {
		super();
		this.org_id = org_id;
		this.org_name = org_name;
		this.org_type = org_type;
	}

	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getOrg_type() {
		return org_type;
	}

	public void setOrg_type(String org_type) {
		this.org_type = org_type;
	}

}