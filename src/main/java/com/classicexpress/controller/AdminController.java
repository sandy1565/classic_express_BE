package com.classicexpress.controller;

import com.classicexpress.service.AdminService;
import com.classicexpress.entity.*;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @RequestMapping("api/showadmins")
    public List<Admin> getStockType() {
        return adminService.tester();
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @PostMapping(value="api/newadmin")
	public String postAdmin(@RequestBody Admin bk){
    	if(adminService.poster(bk)){
    		return "Posted";
    	}
    	return "Nposted";
	}
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @DeleteMapping(value="api/delAdmin/{id}")
	public String deleteAdmin(@PathVariable long id){
    	if(adminService.Deleter(id)){
    		return "Deleted";
    	}
    	return "Ndeleted";
    }
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @PutMapping(value="api/upAdmin/{id}")
	public String replaceAdmin(@RequestBody Admin bk, @PathVariable long id){
		if(adminService.updater(id, bk)){
			return "Updated";
		}
		return "Nupdated";
	}
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping(value="api/permitAdmin/{id}/{status}")
	public String disableAdmin(@PathVariable long id, @PathVariable boolean status){
    	if(adminService.adminEnDb(id, status)){
    		return "Changed";
    	}
    	return "Nchanged";	
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping(value="api/getAdminObj/{id}")
    public Admin getAdminObj(@PathVariable long id){
    	return adminService.fetchAdminSvc(id);
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping(value="api/chAdminPass/{id}/{pass}")
    public String chAdminPass(@PathVariable long id, @PathVariable String pass){
    	if(adminService.PassUpdate(id, pass)){
    		return "Pass_Changed";
    	}
    	return "Pass_Nchanged";
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping("api/User_City/{city}") 
    List<User> getCityUsers(@PathVariable String city){
    	return adminService.getAdUsers(city);
    }
}
