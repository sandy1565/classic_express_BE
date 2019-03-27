package com.classicexpress.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="bookings")
public class Bookings implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cons_id")
	private long conId;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="fromstreet")
	private String fromStreet;
	
	@Column(name="fromcity")
	private String fromCity;
	
	@Column(name="fromcountry")
	private String fromCountry;
	
	@Column(name="tostreet")
	private String toStreet;

	@Column(name="tocity")
	private String toCity;
	
	@Column(name="tocountry")
	private String toCountry;
	
	@Column(name="Tweight")
	private double weight;
	
	@Column(name="Tprice")
	private double price;
	
	@Column(name="pyStat")
	private boolean pystat;
	
	@Temporal(TemporalType.DATE)
	@Column(name="booking_date")
	private Date bDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="received_date")
	private Date rDate;
	
	@Column(name="mode")
	private String mode;
	
	@Column(name="status")
	private String status;
	
	@Transient
	private List<Item_groups> items = new ArrayList(0);
	
	public Bookings(){}
	
	public Bookings(long userId, String fromStreet, String fromCity, String fromCountry, String toStreet, String toCity,
			String toCountry, double weight, double price, Date bDate, Date rDate, String mode, String status) {
		this.userId = userId;
		this.fromStreet = fromStreet;
		this.fromCity = fromCity;
		this.fromCountry = fromCountry;
		this.toStreet = toStreet;
		this.toCity = toCity;
		this.toCountry = toCountry;
		this.weight = weight;
		this.price = price;
		this.bDate = bDate;
		this.rDate = rDate;
		this.mode = mode;
		this.status = status;
	}



	public long getConId() {
		return conId;
	}

	public void setConId(long conId) {
		this.conId = conId;
	}
	
	public void setConsignId() {
		this.conId = this.Id_Generator();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

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
	
	public List<Item_groups> getItems() {
		return items;
	}

	public void setItems(List<Item_groups> items) {
		this.items = items;
	}
	
	public String getFromStreet() {
		return fromStreet;
	}

	public void setFromStreet(String fromStreet) {
		this.fromStreet = fromStreet;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getFromCountry() {
		return fromCountry;
	}

	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}

	public String getToStreet() {
		return toStreet;
	}

	public void setToStreet(String toStreet) {
		this.toStreet = toStreet;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getToCountry() {
		return toCountry;
	}

	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean isPystat() {
		return pystat;
	}

	public void setPystat(boolean pystat) {
		this.pystat = pystat;
	}

	private long Id_Generator(){
		String x="300";
		x+=(((Long)(long)(Math.random() * 100000)).toString());
		return (long)(Long.parseLong(x));
	}
	
}
