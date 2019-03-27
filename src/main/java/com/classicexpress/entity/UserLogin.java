package com.classicexpress.entity;

import javax.persistence.*;

@Entity
@Table(name="userCreds")
public class UserLogin {

	@Id
	@Column(name="uid")
	private long userId;

	@Column(name="upass")
	private String userPass;
	
	@Column(name="umail")
	private String umail;
	
	@Column(name="active")
	private boolean ustat;
	
	public UserLogin(){}
	
	public UserLogin(long userId, String userPass, String umail, boolean ustat) {
		this.userId = userId;
		this.userPass = userPass;
		this.umail = umail;
		this.ustat = ustat;
	}

	public String getUmail() {
		return umail;
	}

	public void setUmail(String umail) {
		this.umail = umail;
	}

	public boolean isUstat() {
		return ustat;
	}
	
	public void setUstat(boolean ustat) {
		this.ustat = ustat;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
}
