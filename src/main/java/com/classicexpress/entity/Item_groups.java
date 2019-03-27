package com.classicexpress.entity;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="items")
public class Item_groups {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="group_id")
	private long groupId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="qty")
	private int noOfItems;
	
	@Column(name="wpi")
	private float weightPerItem;
	
	@Column(name="ppi")
	private double pricePerItem;
	
	@Column(name="dimension")
	private String dimension;
	
	@Autowired
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="consign_id")
	private Bookings booking;

	public Item_groups(){}

	public float getWeightPerItem() {
		return weightPerItem;
	}

	public void setWeightPerItem(float weightPerItem) {
		this.weightPerItem = weightPerItem;
	}

	public long getGroupId() {
		return groupId;
	}
	
	public void setGroupd() {
		this.groupId = this.Id_Generator();
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	
	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	
	public Bookings getBooking() {
		return booking;
	}
	
	public void setBooking(Bookings booking) {
		this.booking = booking;
	}
	
	private long Id_Generator(){
		String x="400";
		x+=(((Long)(long)(Math.random() * 100000)).toString());
		return (long)(Long.parseLong(x));
	}
	
}

