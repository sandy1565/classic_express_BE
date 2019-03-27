package com.classicexpress.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="trackit")
public class Tracking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="track_id")
	private long trackid;
	
	@Column(name="con_id")
	private long consignid;
	
	@Column(name="from_add")
	private String fromAdd;
	
	@Column(name="to_add")
	private String toAdd;
	
	@Column(name="mode")
	private String mode;
	
	@Column(name="prev_stat")
	private String prevStatus;
	
	@Column(name="cur_stat")
	private String curStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name="book_date")
	private Date bDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="recvd_date")
	private Date rDate;
	
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public long getTrackid() {
		return trackid;
	}
	public void setTrackid(long trackid) {
		this.trackid = trackid;
	}
	public long getConsignid() {
		return consignid;
	}
	public void setConsignid(long consignid) {
		this.consignid = consignid;
	}
	public String getFromAdd() {
		return fromAdd;
	}
	public void setFromAdd(String fromAdd) {
		this.fromAdd = fromAdd;
	}
	public String getToAdd() {
		return toAdd;
	}
	public void setToAdd(String toAdd) {
		this.toAdd = toAdd;
	}
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getPrevStatus() {
		return prevStatus;
	}
	public void setPrevStatus(String prevStatus) {
		this.prevStatus = prevStatus;
	}
	public String getCurStatus() {
		return curStatus;
	}
	public void setCurStatus(String curStatus) {
		this.curStatus = curStatus;
	}
	
	public Tracking(){}
	public Tracking(long consignid, String fromAdd, String toAdd, String mode, String prevStatus,
			String curStatus, Date bDate) {
		this.consignid = consignid;
		this.fromAdd = fromAdd;
		this.toAdd = toAdd;
		this.mode = mode;
		this.prevStatus = prevStatus;
		this.curStatus = curStatus;
		this.bDate = bDate;
	}
	
	
}
