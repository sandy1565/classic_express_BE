package com.classicexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classicexpress.sender.SmsSender;

@Service
public class SmsService {

	@Autowired
	private SmsSender smsender;
	
	public String OTP_Service(String x){
		return smsender.OTP_SenderGateway(x);
	}
	
	public boolean Email_Service(String send, String fname, long uid, String pass){
		return smsender.Email_SenderGateway(send,fname, uid, pass);
	}

	public boolean Email_OrderService(String send, String fname, long cid, int it_len,long tid,String cstat){
		return smsender.Email_NewBooking(send, fname, cid, it_len, tid, cstat);
	}
	
	public boolean Email_AlertService(String send, String fname, long cid, long tid, String cstat){
		return smsender.Email_StatusChange(send, fname, cid, tid, cstat);
	}
	
	public boolean Email_delivered(String send, String fname, long cid, long tid){
		return smsender.Email_Delivered(send, fname, cid, tid);
	}
}
