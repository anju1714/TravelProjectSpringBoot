package com.travel.start;




import com.travel.start.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
    // JpaRepository provides built-in methods like save(), findById(), findAll(), deleteById()
}

