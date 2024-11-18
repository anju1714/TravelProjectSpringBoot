package com.travel.start.controller;

import com.travel.start.entity.Train;
import com.travel.start.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    // Add a new train
    @PostMapping
    public ResponseEntity<Train> addTrain(@RequestBody Train train) {
        Train savedTrain = trainService.saveTrain(train);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrain);
    }

    // Get a list of all trains
    @GetMapping
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    // Get details of a train by ID
    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable Long id) {
        Optional<Train> train = trainService.getTrainById(id);
        return train.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a train by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrain(@PathVariable Long id) {
        trainService.deleteTrain(id);
        return ResponseEntity.noContent().build();
    }

    // Get the schedule of a specific train
    @GetMapping("/schedule/{trainNumber}")
    public ResponseEntity<String> getTrainSchedule(@PathVariable String trainNumber) {
        String schedule = trainService.getTrainSchedule(trainNumber);
        if (schedule != null) {
            return ResponseEntity.ok(schedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Check seat availability for a specific train on a given date
    @GetMapping("/availability/{trainNumber}/{date}")
    public ResponseEntity<String> checkSeatAvailability(@PathVariable String trainNumber, @PathVariable String date) {
        String availability = trainService.checkSeatAvailability(trainNumber, date);
        if (availability != null) {
            return ResponseEntity.ok(availability);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
