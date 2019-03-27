package com.classicexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.classicexpress.dao.*;
import com.classicexpress.entity.*;
import java.util.*;

@Service
public class AdminService {

	@Autowired
	private AdminDaoImpl adminDao;
	
	public List<Admin> tester(){
		return adminDao.getRecords();
	}
	
	public List<User> getAdUsers(String city){
		return adminDao.getUser_City(city);
	}
	
	public boolean poster(Admin b)
	{
		return adminDao.addAdmin(b);
	}
	
	public boolean updater(long x, Admin y)
	{
		return adminDao.updateAdmin(x, y);
	}
	
	public boolean Deleter( long x){
		return adminDao.DelAdmin(x);
	}
	
	public boolean adminEnDb(long x, boolean b){
		return adminDao.adminMod(x, b);
	}
	
	public Admin fetchAdminSvc(long x){
		return adminDao.fetchAdminObj(x);
	}
	
	public boolean PassUpdate(long x, String y){
		return adminDao.ChangePass(x, y);
	}
}
