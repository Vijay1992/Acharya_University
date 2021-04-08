package com.au.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_au_user_role")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_role_id;
	private Integer id;
	private Integer role_id;

	public UserRole() {
		super();
	}

	public UserRole(Integer user_role_id, Integer id, Integer role_id) {
		super();
		this.user_role_id = user_role_id;
		this.id = id;
		this.role_id = role_id;
	}

	public Integer getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(Integer user_role_id) {
		this.user_role_id = user_role_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

}
