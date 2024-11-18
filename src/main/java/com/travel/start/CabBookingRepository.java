package com.travel.start;



import org.springframework.data.jpa.repository.JpaRepository;
import com.travel.start.entity.CabBooking;

public interface CabBookingRepository extends JpaRepository<CabBooking, Integer> {
}
