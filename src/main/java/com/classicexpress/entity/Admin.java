package com.classicexpress.entity;

import javax.persistence.*;

@Entity
@Table(name="Admin")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adminid")
	private long adminId;
	
	@Column(name="adminpass", nullable=false, length=20)
	private String adminPass;

	@Column(name="admincity", nullable=false, length=30)
	private String admincity;
	
	@Column(name="adminctry", nullable=false, length=30)
	private String adminctry;
	
	@Column(name="adminName", nullable=false, length=40)
	private String adminName;
	
	@Column(name="loclatitude")
	private double adminLat;
	
	@Column(name="loclongitude")
	private double adminLong;
	
	@Column(name="active")
	private boolean active; 

	public Admin(){}
	
	public Admin(String adminPass, String admincity, String adminctry, String adminName, boolean active) {
		this.adminPass = adminPass;
		this.admincity = admincity;
		this.adminctry = adminctry;
		this.adminName = adminName;
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public long getAdminId() {
		return adminId;
	}
	
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public void setAdminId() {
		this.adminId = this.Id_Generator();
	}
	
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	
	public String getAdmincity() {
		return admincity;
	}

	public void setAdmincity(String admincity) {
		this.admincity = admincity;
	}

	public String getAdminctry() {
		return adminctry;
	}

	public void setAdminctry(String adminctry) {
		this.adminctry = adminctry;
	}

	public double getAdminLat() {
		return adminLat;
	}
	public void setAdminLat(double adminLat) {
		this.adminLat = adminLat;
	}
	public double getAdminLong() {
		return adminLong;
	}
	public void setAdminLong(double adminLong) {
		this.adminLong = adminLong;
	}
	
	
	private long Id_Generator()
	{
		String x="100";
		x+=(((Long)(long)(Math.random() * 10000)).toString());
		return (long)(Long.parseLong(x));
	}
}
