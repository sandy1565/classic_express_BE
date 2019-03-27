package com.classicexpress.application;

import com.classicexpress.dao.UserDaoImpl;
import com.classicexpress.entity.*;
import com.classicexpress.sender.SmsSender;
import com.classicexpress.util.Sessionfactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.util.*;

public class HiberApp {

	public static void main(String[] args) {
		/*Session session = Sessionfactory.getSessionFactory().openSession();
		session.beginTransaction();
		Bookings boo = new Bookings("Delhi","Pune",20,2000.50,new Date(5/11/2017),new Date(7/11/2017),"Air","In-Transit");
		boo.setConId(100029102);
		session.save(new Item_groups(500,"Household",1,200.20,"2x4x8",10,boo));
		session.save(new Item_groups(501,"Men Fashion",1,200.20,"2x4x8",20,boo));
		session.save(new Item_groups(502,"Women Fashion",1,200.20,"2x4x8",30,boo));
		
		List ref = session.createQuery("select max(userId) from UserLogin").list();
		Long x = (Long)ref.get(0);*/
		User u = new User("Gash","Hell","gullu","male",1234567890L,"abc@123.com","Pinki Atta","a","b",12, true);
		UserDaoImpl us =new UserDaoImpl();
		System.out.println(us.addUser(u));
		
		//Admin admin = new Admin("chappati","Honolulu","Hawai","Holiday Yadav",true);
		//session.save(new Bookings(2001,"A","B","C","D","E","F",23.1, 25000.234,new Date(),new Date(),"Air","Booked"));
		//session.save(new Tracking(1000056,"A","B","C","D","E"));
		//session.save(new OrderUpdate(100, 2, 3, 4, 5, "A","B"));
		/*List ref = session.createQuery("select max(userId) from UserLogin").list();
		Long x = (Long)ref.get(0);
		System.out.println(x);
		long adid=100003;
		List<OrderUpdate> ref = session.createQuery("from OrderUpdate as O where O.pckAdminid = :adminid or O.rcvAdminid = :adminid").setParameter("adminid", ((Long)adid)).list();
		System.out.println(ref.get(0).getUserid());
	
		session.getTransaction().commit();
		session.close();*/
		System.out.println("Saved");
		//SmSender sms = new SmSender();
		//System.out.println(sms.OTP_SenderGateway("9654414891"));
		//System.out.println(sms.Email_SenderGateway("gangster.thesecretgun@gmail.com"));
	}

}
