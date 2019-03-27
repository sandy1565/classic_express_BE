package com.classicexpress.dao;

import org.springframework.stereotype.Repository;

import com.classicexpress.entity.*;
import com.classicexpress.util.Sessionfactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.util.*;

@Repository
public class AdminDaoImpl {
	
	public List<Admin> getRecords()
	{
			Session session = Sessionfactory.getSessionFactory().openSession();
			session.beginTransaction();
			
			try{
					List<Admin> adlist = session.createQuery("FROM Admin").list();
					session.getTransaction().commit();
					return adlist;
			}catch(HibernateException e){
				if(session.getTransaction()!=null) session.getTransaction().rollback();
				e.printStackTrace();
				return null;
			}finally{
				session.close();
			}
	}
	
	public boolean addAdmin(Admin b){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		try{
			session.save(b);
			session.save(new AdminLogin(b.getAdminId(), b.getAdminPass(), b.getAdmincity(), b.isActive()));
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
	
	public boolean updateAdmin(long x, Admin y){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			Admin newRef = session.get(Admin.class, x);
			newRef.setAdminName(y.getAdminName());
			newRef.setAdmincity(y.getAdmincity());
			newRef.setAdminctry(y.getAdminctry());
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
	
	public boolean DelAdmin(long x){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			Admin newRef = session.get(Admin.class, x);
			session.delete(newRef);
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
	
	public boolean adminMod(long x, boolean b){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		try{
			Admin newRef = session.get(Admin.class, x);
			newRef.setActive(b);
			session.update(newRef);
			AdminLogin adlg =session.get(AdminLogin.class, x);
			adlg.setAdstat(b);
			session.update(adlg);
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
	
	public Admin fetchAdminObj(long x){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			Admin gAdmin = session.get(Admin.class, x);
			return gAdmin;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	public boolean ChangePass(long x, String y){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		try{
			Admin gAdmin = session.get(Admin.class, x);
			gAdmin.setAdminPass(y);
			session.update(gAdmin);
			AdminLogin lgAdmin = session.get(AdminLogin.class, x);
			lgAdmin.setAdminPass(y);
			session.update(lgAdmin);	
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
	
	public List<User> getUser_City(String city){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		try{
				List<User> usList = session.createQuery("FROM User as U where U.ucity = :scity").setParameter("scity",city).list();
				session.getTransaction().commit();
				return usList;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
}