package com.classicexpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classicexpress.dao.BookingDaoImpl;
import com.classicexpress.entity.*;

@Service
public class BookingService {

	@Autowired 
	private BookingDaoImpl bookingDao;
	
	public boolean bookPost( Bookings b, List<Item_groups> ref)
	{
		return bookingDao.add_Bookings( b, ref);
	}
	
	public boolean idcheck(long x){
		return bookingDao.userCheck(x);
	}
	
	public List<OrderUpdate> getAdminCon(long x){
		return bookingDao.getAdminOrders(x);
	}
	
	public boolean StatChange(long cid, String pstat, String cstat){
		return bookingDao.statusChange(cid, pstat, cstat);
	}
	
	public List<Bookings> getSvcOrders(){
		return bookingDao.getOrders();
	}
	
	public Tracking TrackingFetchService(long id){
		return bookingDao.TrackObjById(id);
	}

}
