package com.travel.start.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.start.HotelRepository;
import com.travel.start.entity.Hotel;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public Hotel updateHotel(Long id, Hotel hotelDetails) {
        Optional<Hotel> existingHotel = hotelRepository.findById(id);
        if (existingHotel.isPresent()) {
            Hotel hotel = existingHotel.get();
            hotel.setName(hotelDetails.getName());
            hotel.setAddress(hotelDetails.getAddress());
            hotel.setRoomsAvailable(hotelDetails.getRoomsAvailable());
           // hotel.setAvailable(hotelDetails.isAvailable());
            hotel.setPricePerNight(hotelDetails.getPricePerNight());
            return hotelRepository.save(hotel);
        }
        return null;
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
