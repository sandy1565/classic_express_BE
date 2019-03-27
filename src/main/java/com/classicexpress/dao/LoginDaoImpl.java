package com.classicexpress.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.classicexpress.entity.*;
import com.classicexpress.util.Sessionfactory;

@Repository
public class LoginDaoImpl {

	public boolean UserAuth(UserLogin ref)
	{
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		try{
			UserLogin db_ref = session.get(UserLogin.class, ref.getUserId());
			if(db_ref!=null && ref.getUserPass().equals(db_ref.getUserPass()))
				return true;
			else
				return false;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
	}
	
	public long UserAuth_mail(UserLogin ref)
	{
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		try{
			List<UserLogin> result = session.createQuery("from UserLogin U where U.umail = :mmail").setParameter("mmail", ref.getUmail()).list();
			UserLogin db_ref = result.get(0);
			if(db_ref!=null && ref.getUserPass().equals(db_ref.getUserPass()))
				return db_ref.getUserId();
			else
				return 0;
		}catch(HibernateException e){
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
		
	}
	
	public boolean AdminAuth(AdminLogin ref)
	{
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		try{
			AdminLogin db_ref = session.get(AdminLogin.class, ref.getAdminId());
			if(db_ref!=null && ref.getAdminPass().equals(db_ref.getAdminPass()))
				return true;
			else
				return false;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
	}
}
