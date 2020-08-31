package com.pdf.tool.model;

public class LoginModel {
	
	private String userid;
	private String password;	
	
	
	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginModel(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
