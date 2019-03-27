package com.classicexpress.util;

import java.util.Random;

public class OtpUtil {

	public static String OTP_len(int len)
    {
		String numbers = "0123456789";
 
        Random rndm_method = new Random();
        String msg="";
        char[] otp = new char[len];
 
        for (int i = 0; i < len; i++)
        {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
            msg=msg+otp[i];   
        }
        return msg;
    }
	
}
