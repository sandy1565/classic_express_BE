package com.classicexpress.entity;

import javax.persistence.*;

@Entity
@Table(name="userregister")
public class User {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", nullable=false)
	private long userId;
	
	@Column(name="fname", nullable=false, length=20)
	private String userFname;
	
	@Column(name="lname", nullable=false, length=20)
	private String userLname;
	
	@Column(name="userpass", nullable=false, length=20)
	private String userPass;
	
	@Column(name="gender", nullable=false, length=10)
	private String userGender;
	
	@Column(name="mobile_no")
	private long userMob;
	
	@Column(name="email", nullable=false, length=30)
	private String userMail;
	
	@Column(name="street", nullable=false, length=60)
	private String ustreet;
	
	@Column(name="city", nullable=false, length=20)
	private String ucity;
	
	@Column(name="country", nullable=false, length=20)
	private String ucountry;
	
	@Column(name="mcc", nullable=false)
	private int mobcode;
	
	@Column(name="active", nullable=false)
	private boolean ustat;
	
	public String getUstreet() {
		return ustreet;
	}

	public void setUstreet(String ustreet) {
		this.ustreet = ustreet;
	}

	public String getUcity() {
		return ucity;
	}

	public void setUcity(String ucity) {
		this.ucity = ucity;
	}

	public String getUcountry() {
		return ucountry;
	}

	public void setUcountry(String ucountry) {
		this.ucountry = ucountry;
	}

	public int getMobcode() {
		return mobcode;
	}

	public void setMobcode(int mobcode) {
		this.mobcode = mobcode;
	}

	public boolean isUstat() {
		return ustat;
	}

	public void setUstat(boolean ustat) {
		this.ustat = ustat;
	}

	public User(){}
	
	public long getUserId() {
		return userId;
	}
	
	
	public void setUId() {
		this.userId = this.Id_Generator();
	}
	
	
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserFname() {
		return userFname;
	}
	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}
	public String getUserLname() {
		return userLname;
	}
	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public long getUserMob() {
		return userMob;
	}
	public void setUserMob(long userMob) {
		this.userMob = userMob;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	
	private long Id_Generator(){
		String x="200";
		x+=(((Long)(long)(Math.random() * 10000)).toString());
		return (long)(Long.parseLong(x));
	}
	

	public User(String userFname, String userLname, String userPass, String userGender, long userMob, String userMail,
			String ustreet, String ucity, String ucountry, int mobcode, boolean ustat) {
		this.userFname = userFname;
		this.userLname = userLname;
		this.userPass = userPass;
		this.userGender = userGender;
		this.userMob = userMob;
		this.userMail = userMail;
		this.ustreet = ustreet;
		this.ucity = ucity;
		this.ucountry = ucountry;
		this.mobcode = mobcode;
		this.ustat = ustat;
	}	
	
	
}
