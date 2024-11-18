package com.travel.start.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.start.entity.CabBooking;
import com.travel.start.service.CabBookingService;


@RestController
@RequestMapping("/api/cabBookings")
public class App {
	
	
	@GetMapping("/travel")
	public CabBooking getCab() {
		CabBooking cb = new CabBooking();
		cb.setCabType("SUV");
		cb.setContactNumber("mgct1425");
		cb.setCustomerName("Kalabai");
		cb.setDropLocation("jalna");
		cb.setPickupLocation("Pune");
	    return cb;  // This will be a direct response
	}
	
	 @Autowired
	    private CabBookingService cabBookingService;

	    // POST  to create a new cab booking
	    @PostMapping
	    public CabBooking createCabBooking(@RequestBody CabBooking cabBooking) {
	        return cabBookingService.createCabBooking(cabBooking);
	    }
	    
	    // GET  to retrieve all cab bookings
	    @GetMapping
	    public List<CabBooking> getAllCabBookings() {
	        return cabBookingService.getAllCabs();
	    }
	    
	    // GET  to retrieve a specific cab booking by ID
	    @GetMapping("/{id}")
	    public Optional<CabBooking> getCabBookingById(@PathVariable Integer id) {
	        return cabBookingService.getCabBookingById(id);
	    }

	    // PUT  to update an existing cab booking
	    @PutMapping("/{id}")
	    public CabBooking updateCabBooking(@PathVariable Integer id, @RequestBody CabBooking newDetails) {
	        return cabBookingService.updateCabBooking(id, newDetails);
	    }

	    // DELETE  to delete a cab booking by ID
	    @DeleteMapping("/{id}")
	    public void deleteCabBookingById(@PathVariable Integer id) {
	        cabBookingService.deleteCabBookingById(id);
	    }
	}
	


