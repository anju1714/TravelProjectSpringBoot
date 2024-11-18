package com.travel.start.service;

import com.travel.start.entity.Train;
import com.travel.start.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    private static final String TRAIN_API_URL = "https://api.example.com/train/"; // Replace with real API URL

    // Save a train to the database
    public Train saveTrain(Train train) {
        return trainRepository.save(train);
    }

    // Fetch all trains
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    // Fetch a specific train by its ID
    public Optional<Train> getTrainById(Long id) {
        return trainRepository.findById(id);
    }

    // Delete a train by ID
    public void deleteTrain(Long id) {
        trainRepository.deleteById(id);
    }

    // Fetch train schedule using an external API
    public String getTrainSchedule(String trainNumber) {
        RestTemplate restTemplate = new RestTemplate();
        String url = TRAIN_API_URL + "schedule?trainNumber=" + trainNumber;
        // Assuming the response is a simple string (e.g., "Scheduled: 10:00 AM")
        return restTemplate.getForObject(url, String.class);
    }

    // Check seat availability for a specific train and date using an external API
    public String checkSeatAvailability(String trainNumber, String date) {
        RestTemplate restTemplate = new RestTemplate();
        String url = TRAIN_API_URL + "availability?trainNumber=" + trainNumber + "&date=" + date;
        return restTemplate.getForObject(url, String.class);
    }
}
