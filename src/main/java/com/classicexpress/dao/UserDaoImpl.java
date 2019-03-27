package com.classicexpress.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.classicexpress.entity.*;
import com.classicexpress.util.Sessionfactory;

@Repository
public class UserDaoImpl{

	public List<User> getRecords()
	{
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			List<User> uslist = session.createQuery("FROM User").list();
			session.getTransaction().commit();
			return uslist;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
			System.out.println("Users Fetched !!");
		}
	}
	
	public long addUser(User ref){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			session.save(ref);
			session.save(new UserLogin(ref.getUserId(), ref.getUserPass(),ref.getUserMail(), ref.isUstat()));
			session.getTransaction().commit();
			return ref.getUserId();
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	
	public boolean updateUser(long x, User y){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		try{
			User newRef = session.get(User.class, x);
			newRef.setUserFname(y.getUserFname());
			newRef.setUserLname(y.getUserLname());
			
			if(!newRef.getUserMail().equals(y.getUserMail())){
				newRef.setUserMail(y.getUserMail());
				UserLogin logref = session.get(UserLogin.class, x);
				logref.setUmail(y.getUserMail());
				session.update(logref);
			}
			newRef.setUserMob(y.getUserMob());
			newRef.setUstreet(y.getUstreet());
			newRef.setUcountry(y.getUcountry());
			newRef.setUcity(y.getUcity()); 
			newRef.setMobcode(y.getMobcode());
			session.update(newRef);
			
			session.getTransaction().commit();
			return true;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	public boolean DelUser(long x){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			User newRef = session.get(User.class, x);
			session.delete(newRef);
			
			UserLogin logref = session.get(UserLogin.class, x);
			session.delete(logref);
			
			session.getTransaction().commit();
			return true;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	public boolean fetchUser(long x){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			UserLogin user = session.get(UserLogin.class, x);
			if(user!=null){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}finally{
			session.close();
		}
	}
	
	public boolean userMod(long x, boolean b){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			User newRef = session.get(User.class, x);
			newRef.setUstat(b);
			session.update(newRef);
			UserLogin uCr = session.get(UserLogin.class, x);
			uCr.setUstat(b);
			session.update(uCr);
			session.getTransaction().commit();
			return true;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
	}
	
	public User fetchUserObj(long x){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			User gUser = session.get(User.class, x);
			return gUser;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	public Long availUser(){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			List ref = session.createQuery("select max(userId) from UserLogin").list();
			Long x = (Long)ref.get(0);
			if(x!=null)
				return x;
			else
				return null;
		}catch(Exception e){
			return null;
		}finally{
			session.close();
		}
	}
	
	public boolean ChangeUpass(long x, String y){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		try{
			User gUser = session.get(User.class, x);
			gUser.setUserPass(y);
			session.update(gUser);
			
			UserLogin lgUser = session.get(UserLogin.class, x);
			lgUser.setUserPass(y);
			session.update(lgUser);
			
			session.getTransaction().commit();
			return true;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	public List<UserBookings> getUserOrders(long uid)
	{
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			List<UserBookings> uslist = session.createQuery("FROM UserBookings as U where U.userId = :uid").setParameter("uid", uid).list();
			session.getTransaction().commit();
			return uslist;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	public String getUserCity(long id){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			User user = session.get(User.class, id);
			session.getTransaction().commit();
			return user.getUcity();
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	public Bookings getTbooko(long id){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			Bookings cbk = session.get(Bookings.class, id);
			session.getTransaction().commit();
			return cbk;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
}
	
