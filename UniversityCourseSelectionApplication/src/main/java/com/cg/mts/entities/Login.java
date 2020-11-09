package com.cg.mts.entities;


public class Login {

	private String userId;
	private String password;
	private String role;
	private String fullName;
	private String mobile;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Login(String userId, String password, String role, String fullName, String mobile) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.fullName = fullName;
		this.mobile = mobile;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", password=" + password + ", role=" + role + ", fullName=" + fullName
				+ ", mobile=" + mobile + "]";
	}
	
	

}
