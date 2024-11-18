package com.travel.start.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.start.CabBookingRepository;
import com.travel.start.entity.CabBooking;

@Service
public class CabBookingService {
    @Autowired
    private CabBookingRepository cabBookingRepository;

    // Create
    public CabBooking createCabBooking(CabBooking cabBooking) {
        return cabBookingRepository.save(cabBooking);
    }
    
    public List<CabBooking> getAllCabs() {
		// TODO Auto-generated method stub
		return cabBookingRepository.findAll();
	}

    
    // Read
    public Optional<CabBooking> getCabBookingById(Integer id) {
        return cabBookingRepository.findById(id);
    }

    
    
    
    
    
    
    // Update
    public CabBooking updateCabBooking(Integer id, CabBooking newDetails) {
        return cabBookingRepository.findById(id).map(cabBooking -> {
            cabBooking.setPickupLocation(newDetails.getPickupLocation());
            cabBooking.setDropLocation(newDetails.getDropLocation());
            cabBooking.setCabType(newDetails.getCabType());
            cabBooking.setCustomerName(newDetails.getCustomerName());
            cabBooking.setContactNumber(newDetails.getContactNumber());
            return cabBookingRepository.save(cabBooking);
        }).orElse(null);
    }

    // Delete
    public void deleteCabBookingById(Integer id) {
        cabBookingRepository.deleteById(id);
    }
    
 
}


