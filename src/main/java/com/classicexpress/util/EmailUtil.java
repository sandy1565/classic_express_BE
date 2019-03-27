package com.classicexpress.util;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	public static boolean sendEmail(String rcpAdd, String msgBody, String msgSub){
		final String username = "care.postrack@gmail.com";
	    final String password = "chgayadfvyeksyxn";

	    Properties props = new Properties();
	      props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465"); 

	    Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	      });
	    
	    session.setDebug(true);

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));
	        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(rcpAdd));
	        message.setSubject(msgSub);
	        message.setText(msgBody);

	        Transport.send(message);
	        
	        return true;
	    } catch (MessagingException e) {
	    	e.printStackTrace();
	        return false;
	    }
	}
}
