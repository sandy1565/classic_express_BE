package com.classicexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.classicexpress.entity.*;
import com.classicexpress.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingSvc; 
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
    @PostMapping("api/postBooking")
	public String postBookings( @RequestBody Bookings b)
	{
		if(bookingSvc.bookPost(b, b.getItems())){
			return "Posted";
		}
		return "Nposted";
	}
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
	@GetMapping("api/checkUser/{x}")
	public String checker(@PathVariable long x){
		if(bookingSvc.idcheck(x)){
			return "Found";
		}
		return "Nfound";
	}
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
	@GetMapping("api/getAdminOrders/{id}")
	public List<OrderUpdate> getAdminOrds(@PathVariable long id){
		return bookingSvc.getAdminCon(id);
	}
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
	@GetMapping("api/statusChange/{cid}/{pstat}/{cstat}")
	public String statusControl(@PathVariable long cid, @PathVariable String pstat, @PathVariable String cstat){
		if(bookingSvc.StatChange(cid, pstat, cstat)){
			return "Stat_Changed";
		}
		return "Stat_Unchanged";
	}
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
	@GetMapping("api/getAllOrders")
	public List<Bookings> returnOrders(){
		return bookingSvc.getSvcOrders();
	}
	
	@CrossOrigin(allowedHeaders="*", allowCredentials="true")
	@GetMapping("api/getTrackoObj/{id}")
	public Tracking getTracko(@PathVariable long id){
		return bookingSvc.TrackingFetchService(id);  
	}
	
}
