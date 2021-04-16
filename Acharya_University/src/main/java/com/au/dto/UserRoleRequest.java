package com.au.dto;

import java.util.List;

public class UserRoleRequest {

	private int id;
	private String username;
	private String password;
	private String usertype;
	private Boolean status;
	private String email;
	private String usercode;

	public List<Integer> role_id;
	
	public UserRoleRequest() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public List<Integer> getRole_id() {
		return role_id;
	}
	public void setRole_id(List<Integer> role_id) {
		this.role_id = role_id;
	}

	
	
}
