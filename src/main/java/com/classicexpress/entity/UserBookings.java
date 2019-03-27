package com.classicexpress.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="userOrders")
public class UserBookings {

	@Id
	@Column(name="ord_id")
	private long ordId;
	
	@Column(name="userid")
	private Long userId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ord_date")
	private Date ordDate;
	
	@Column(name="ord_price")
	private double ordPrice;
	
	@Column(name="ord_track")
	private long ordTrackid;
	
	@Column(name="ord_stat")
	private String ordStatus;
	
	public UserBookings(){}	

	public UserBookings(long ordId, Long userId, Date ordDate, double ordPrice, long ordTrackid, String ordStatus) {
		super();
		this.ordId = ordId;
		this.userId = userId;
		this.ordDate = ordDate;
		this.ordPrice = ordPrice;
		this.ordTrackid = ordTrackid;
		this.ordStatus = ordStatus;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public long getOrdId() {
		return ordId;
	}
	public void setOrdId(long ordId) {
		this.ordId = ordId;
	}
	
	public Date getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}
	public double getOrdPrice() {
		return ordPrice;
	}
	public void setOrdPrice(double ordPrice) {
		this.ordPrice = ordPrice;
	}
	public long getOrdTrackid() {
		return ordTrackid;
	}
	public void setOrdTrackid(long ordTrackid) {
		this.ordTrackid = ordTrackid;
	}
	public String getOrdStatus() {
		return ordStatus;
	}
	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}
	
	
}
