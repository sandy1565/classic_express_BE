package com.classicexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.classicexpress.dao.*;
import com.classicexpress.entity.*;
import java.util.*;

@Service
public class UserService {

	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Autowired
	private SmsService smservice;
	
	public List<User> tester(){
		return userDaoImpl.getRecords();
	}
	
	public List<UserBookings> userOrdersSvc(long uid){
		return userDaoImpl.getUserOrders(uid);
	}
	
	public boolean poster(User b){
		long t = userDaoImpl.addUser(b);
		if(t!=0){
			if(smservice.Email_Service(b.getUserMail(), b.getUserFname(), t, b.getUserPass())){
				System.out.println("Message Sent");
			}
			return true;	
		}
		return false;
	}
	
	public String OTP_generate(String mob){
		return smservice.OTP_Service(mob);
	}
	
	public boolean updater(long x, User y)
	{
		return userDaoImpl.updateUser(x, y);
	}
	
	public boolean Deleter( long x){
	 	return userDaoImpl.DelUser(x);
	}
	
	public boolean userCheck(long x){
		return userDaoImpl.fetchUser(x);
	}
	
	public boolean userEnDb(long x, boolean b){
		return userDaoImpl.userMod(x, b);
	}
	
	public User fetchUserSvc(long x){
		return userDaoImpl.fetchUserObj(x);
	}
	
	public Long fetchMaxUser(){
		return userDaoImpl.availUser();
	}
	
	public boolean PassUpdate(long x, String y){
	 	return userDaoImpl.ChangeUpass(x, y);
	}
	
	public String cityComm(long id){
		return userDaoImpl.getUserCity(id);
	}
	
	public Bookings trackBookingSvc(long id){
		return userDaoImpl.getTbooko(id);
	}
}
