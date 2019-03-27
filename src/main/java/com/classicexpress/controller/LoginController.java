package com.classicexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.classicexpress.entity.AdminLogin;
import com.classicexpress.entity.UserLogin;
import com.classicexpress.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
	@PostMapping(value="api/adminLogin")
	public String adminCheck(@RequestBody AdminLogin ref){
		if(loginService.adminLogin(ref)){
			return "AdminFound";
		}
		return "Nfound";
	}
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
	@PostMapping(value="api/userLogin")
	public String userCheck(@RequestBody UserLogin ref){
		if(loginService.userLogin(ref)){
			return "UserFound";
		}
		return "Nfound";
	}
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
	@PostMapping(value="api/userLoginMail")
	public String userCheck_mail(@RequestBody UserLogin ref){
		Long t = loginService.userMailLogin(ref);
		if(t!=0){
			return t.toString();
		}
		return "Nfound";
	}
}

