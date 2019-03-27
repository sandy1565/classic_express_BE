package com.classicexpress.dao;

import com.classicexpress.entity.*;
import com.classicexpress.service.SmsService;
import com.classicexpress.util.Sessionfactory;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDaoImpl {

	@Autowired
	private SmsService smservice;
	
	public boolean add_Bookings(Bookings b, List<Item_groups> ref){
		
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{			
				for(int i=0;i<ref.size();i++){
					ref.get(i).setBooking(b);
					session.save((Item_groups)ref.get(i));
				}
				
				Tracking track =new Tracking(b.getConId(),(b.getFromStreet()+", "+b.getFromCity()+", "+b.getFromCountry()), (b.getToStreet()+", "+b.getToCity()+", "+b.getToCountry()),b.getMode(),"Booked",b.getStatus(), b.getbDate());  
				session.save(track);
				
				UserBookings uBs = new UserBookings(b.getConId(), b.getUserId(), b.getbDate(), b.getPrice(), track.getTrackid(), b.getStatus());
				session.save(uBs);
				
				OrderUpdate ordUp = new OrderUpdate(b.getUserId(), b.getConId(), track.getTrackid(), track.getCurStatus(),track.getPrevStatus());
				List<AdminLogin> results = session.createQuery("FROM AdminLogin A WHERE A.adminLoc = :curcity").setParameter("curcity",b.getFromCity()).list();
				ordUp.setPckAdminid(results.get(0).getAdminId());
				
				String hql = "FROM AdminLogin A WHERE A.adminLoc = :tocity";
				Query query = session.createQuery(hql);
				query.setParameter("tocity",b.getToCity());
				List<AdminLogin> results2 = query.list();
				ordUp.setRcvAdminid(results2.get(0).getAdminId());
				session.save(ordUp);
			
				User us =  session.get(User.class, b.getUserId());
				if(smservice.Email_OrderService(us.getUserMail(), us.getUserFname(), b.getConId(), ref.size(), track.getTrackid(), track.getCurStatus()))
					System.out.println("Mail Sent");
				else
					System.out.println("Mail Not Sent");
				
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
	
	public boolean userCheck(long x){
		
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();		
		try{
			 User u = session.get(User.class, x);
			 session.getTransaction().commit();
			 if(u!=null)
				 return true;
			 else
				 return false;
		}catch(Exception e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	public List<OrderUpdate> getAdminOrders(long adid){
		
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			List<OrderUpdate> ref = session.createQuery("from OrderUpdate as O where O.pckAdminid = :adminid or O.rcvAdminid = :adminid").setParameter("adminid", ((Long)adid)).list();
			session.getTransaction().commit();
			return ref;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	public boolean statusChange(long cid, String pstat, String cstat){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		try{
			OrderUpdate ord = session.get(OrderUpdate.class, cid);
			ord.setPrevStatus(pstat);
			ord.setCurStatus(cstat);
			session.update(ord);
			
			Tracking trk = session.get(Tracking.class, ord.getTrackid());
			trk.setPrevStatus(pstat);
			trk.setCurStatus(cstat);
			if(cstat.equals("Delivered")){
				trk.setrDate(new Date());
			}
			session.update(trk);
			
			Bookings bks = session.get(Bookings.class, cid);
			bks.setStatus(cstat);
			if(cstat.equals("Received")){
				bks.setPystat(true);
			}else if(cstat.equals("Delivered")){
				bks.setrDate(new Date());
			}
			session.update(bks);
		
			UserBookings ubs = session.get(UserBookings.class, cid);
			ubs.setOrdStatus(cstat);
			session.update(ubs);
			
			User user = session.get(User.class, bks.getUserId());
			
			if(cstat.equals("Delivered")){
				if(smservice.Email_delivered(user.getUserMail(), user.getUserFname(), cid, trk.getTrackid()))
					System.out.println("DMail Sent");
				else
					System.out.println("DMail Not Sent");
			}else{
				if(smservice.Email_AlertService(user.getUserMail(), user.getUserFname(), cid, trk.getTrackid(), cstat))
					System.out.println("Alert Mail Sent");
				else
					System.out.println("Alert Mail Not Sent");
			}
			
			
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
	
	public List<Bookings> getOrders(){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			List<Bookings> blist = session.createQuery("FROM Bookings").list();
			session.getTransaction().commit();
			return blist;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	public Tracking TrackObjById(long id){
		Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			Tracking trkObj = session.get(Tracking.class, id);
			session.getTransaction().commit();
			return trkObj;
		}catch(HibernateException e){
			if(session.getTransaction()!=null) session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	
}
