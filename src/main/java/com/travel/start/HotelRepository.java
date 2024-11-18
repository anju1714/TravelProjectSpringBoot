package com.travel.start;
import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.start.entity.Hotel;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
}