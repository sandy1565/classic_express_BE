package com.classicexpress.entity;

import javax.persistence.*;

@Entity
@Table(name="adminCreds")
public class AdminLogin {

	@Id
	@Column(name="adid")
	private long adminId;
	
	@Column(name="adpass")
	private String adminPass;
	
	@Column(name="adcity")
	private String adminLoc;
	
	@Column(name="active")
	private boolean adstat;
	
	public AdminLogin(){}
	
	
	public AdminLogin(long adminId, String adminPass, String adminLoc, boolean adstat) {
		this.adminId = adminId;
		this.adminPass = adminPass;
		this.adminLoc = adminLoc;
		this.adstat = adstat;
	}


	public String getAdminLoc() {
		return adminLoc;
	}
	public void setAdminLoc(String adminLoc) {
		this.adminLoc = adminLoc;
	}


	public boolean isAdstat() {
		return adstat;
	}


	public void setAdstat(boolean adstat) {
		this.adstat = adstat;
	}


	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	
	
}
