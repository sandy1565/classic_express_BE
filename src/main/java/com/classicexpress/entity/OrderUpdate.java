package com.classicexpress.entity;

import javax.persistence.*;

@Entity
@Table(name="orderLink")
public class OrderUpdate {
	
	@Column(name="user_id")
	private long userid;
	
	@Id
	@Column(name="consign_id")
	private long consign_id;
	
	@Column(name="track_id")
	private long trackid;
	
	@Column(name="padmin_id")
	private long pckAdminid;
	
	@Column(name="radmin_id")
	private long rcvAdminid;
	
	@Column(name="cStatus")
	private String curStatus;
	
	@Column(name="pStatus")
	private String prevStatus;
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getConsign_id() {
		return consign_id;
	}
	public void setConsign_id(long consign_id) {
		this.consign_id = consign_id;
	}
	public long getTrackid() {
		return trackid;
	}
	public void setTrackid(long trackid) {
		this.trackid = trackid;
	}
	public long getPckAdminid() {
		return pckAdminid;
	}
	public void setPckAdminid(long pckAdminid) {
		this.pckAdminid = pckAdminid;
	}
	public long getRcvAdminid() {
		return rcvAdminid;
	}
	public void setRcvAdminid(long rcvAdminid) {
		this.rcvAdminid = rcvAdminid;
	}
	public String getCurStatus() {
		return curStatus;
	}
	public void setCurStatus(String curStatus) {
		this.curStatus = curStatus;
	}
	public String getPrevStatus() {
		return prevStatus;
	}
	public void setPrevStatus(String prevStatus) {
		this.prevStatus = prevStatus;
	}
	
	public OrderUpdate(){}
	public OrderUpdate(long userid, long consign_id, long trackid, String curStatus, String prevStatus) {
		this.userid = userid;
		this.consign_id = consign_id;
		this.trackid = trackid;
		this.curStatus = curStatus;
		this.prevStatus = prevStatus;
	}
	
	
	
}
