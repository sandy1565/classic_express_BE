package com.classicexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classicexpress.dao.LoginDaoImpl;
import com.classicexpress.entity.AdminLogin;
import com.classicexpress.entity.UserLogin;

@Service
public class LoginService {

	@Autowired
	private LoginDaoImpl loginDao;
	
	public boolean userLogin(UserLogin ref){
		return loginDao.UserAuth(ref);
	}
	
	public boolean adminLogin(AdminLogin ref){
		return loginDao.AdminAuth(ref);
	}
	
	public long userMailLogin(UserLogin ref){
		return loginDao.UserAuth_mail(ref);
	}
}
