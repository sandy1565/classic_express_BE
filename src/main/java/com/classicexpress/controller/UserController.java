package com.classicexpress.controller;

import com.classicexpress.service.UserService;
import com.classicexpress.entity.*;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @RequestMapping("api/showusers")
    public List<User> getAllUsers() {
        return userService.tester();
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping("api/getUserOrders/{uid}")
    public List<UserBookings> getDashOrders(@PathVariable long uid){
    	return userService.userOrdersSvc(uid);
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @PostMapping(value="api/newuser")
	public String postUser(@RequestBody User bk){
    	if(userService.poster(bk)){
    		return "Posted";	
    	}
    	return "Nposted";
	}
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @DeleteMapping(value="api/delUser/{id}")
	public String deleteUser(@PathVariable long id){
    	if(userService.Deleter(id)){
    		return "Deleted";
    	}
    	return "Ndeleted";
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @PutMapping(value="api/upUser/{id}")
	public String replaceUser(@RequestBody User bk, @PathVariable long id){
		if(userService.updater(id, bk)){
			return "Updated";
		}
		return "Nupdated";
	}
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping(value="api/getUser/{id}")
    public String getUser(@PathVariable long id){
    	if(userService.userCheck(id)){
    		return "Found";
    	}
    	return "Nfound";
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping(value="api/permitUser/{id}/{status}")
	public String disableUser(@PathVariable long id, @PathVariable boolean status){
    	if(userService.userEnDb(id, status)){
    		return "Changed";
    	}
    	return "Unchanged";
    	
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping(value="api/getUserObj/{id}")
    public User getUserObj(@PathVariable long id){
    	return userService.fetchUserSvc(id);
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping(value="api/chUserPass/{id}/{pass}")
    public String chUserPass(@PathVariable long id, @PathVariable String pass){
    	if(userService.PassUpdate(id, pass)){
    		return "Pass_Changed";
    	}
    	return "Pass_Nchanged";
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping(value="api/getMaxUser")
    public Long getMaxxer(){
    	if(userService.fetchMaxUser()!=null){
    		return userService.fetchMaxUser();
    	}
    	return (Long)(long)200101;
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping(value="api/OTP_generate/{mob}")
    public String getOTP(@PathVariable String mob){
    	return userService.OTP_generate(mob);
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping(value="api/getUserCity/{id}")
    public String getUcity(@PathVariable long id){
    	String Ucity = userService.cityComm(id);
    	if(Ucity!=null){
    		return Ucity;
    	}
    	return "Nfound";
    }
    
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @GetMapping("api/getTrackOrder/{id}")
	public Bookings getBookie(@PathVariable long id){
		return userService.trackBookingSvc(id);
	}
}
