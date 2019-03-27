package com.classicexpress.sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.springframework.stereotype.Repository;

import com.classicexpress.util.*;

@Repository
public class SmsSender {
	
	private String msgBody;
	private String msgSub;
	
	public String OTP_SenderGateway(String x){
		OtpUtil myOTP =new OtpUtil();
		
		final String username = "jitkuk";
        final String authkey = "b1bf5eaf89XX";
        final String mobiles = x;
        final String senderId = "CLNIND";
        String message = myOTP.OTP_len(5) ;
        final String accusage="1";
        
        URLConnection myURLConnection=null;
        URL myURL=null;
        BufferedReader reader=null;

        @SuppressWarnings("deprecation")
		String encoded_message=URLEncoder.encode(message);

        String mainUrl="http://sms.bulkssms.com/submitsms.jsp?";

        StringBuilder sbPostData= new StringBuilder(mainUrl);
	        sbPostData.append("user="+username);
	        sbPostData.append("&key="+authkey);
	        sbPostData.append("&mobile="+mobiles);
	        sbPostData.append("&message="+encoded_message);
	        sbPostData.append("&accusage="+accusage);
	        sbPostData.append("&senderid="+senderId);
 
        mainUrl = sbPostData.toString();
        try{
        	myURL = new URL(mainUrl);
	        myURLConnection = myURL.openConnection();
	        myURLConnection.connect();
	        reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
	        String response;
	        while ((response = reader.readLine()) != null)
	        reader.close();
	        return message;
	    }
        catch (IOException e)
        {
        	e.printStackTrace();
        	return message;
        }
   }

	public boolean Email_SenderGateway(String send, String fname, long uid, String pass){
			this.msgBody = "Greetings From PosTrack"+"\n\nHello "+fname+", You Have Successfully Completed Your Registration With Us."
							+"\nYour User ID: "+uid+"\nYour Password: "+pass+"\n\n\nGo To your DashBoard & Book Couriers with Us For Safe, Secured & Speedy Deliveries";
			this.msgSub = "New Registration";
			return EmailUtil.sendEmail(send, msgBody, msgSub);
	}
	
	public boolean Email_NewBooking(String send, String fname, long cid, int it_len, long tid, String cstat){
		this.msgBody = "Hello "+fname+", You Have Successfully Booked a Courier with Us.\n\nYour Order with ID: "+cid
						+" Contains "+it_len+" Groups of Items.\nAWB or Tracking Id for You Courier is "+tid+
						"\nCurrent Status of Courier is "+cstat+"\nWe will keep you posted for status changes";
		
		this.msgSub = "New Order Booked";
		return EmailUtil.sendEmail(send, msgBody, msgSub);
	}
	
	public boolean Email_StatusChange(String send, String fname, long cid, long tid, String cstat){
		this.msgBody = "Alert From PosTrack.\nHello "+fname+".\n\nStatus of Your Order with ID: "+cid
				+" and AWB : "+tid+" is "+cstat+"\nWe will keep you posted for further status changes";
		this.msgSub = "Order Status Changed";
		return EmailUtil.sendEmail(send, msgBody, msgSub);
	}
	
	public boolean Email_Delivered(String send, String fname, long cid, long tid){
		this.msgBody = "Greetings From PosTrack.\nHello "+fname+".\n\nYour Order with ID: "+cid
				+" and AWB : "+tid+" has been Successfully Delivered.\nGive us Your Feedback On the Quality of Service. "
				+"We are Eager to provide Seamless service for your future Orders";
		this.msgSub = "Order Delivered";
		return EmailUtil.sendEmail(send, msgBody, msgSub);
	}

}
