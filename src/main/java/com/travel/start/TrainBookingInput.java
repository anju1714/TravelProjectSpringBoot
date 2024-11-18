package com.travel.start;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.travel.start.service.TrainService;

@Component
public class TrainBookingInput implements CommandLineRunner {

    @Autowired
    private TrainService trainService;

    private Scanner scanner = new Scanner(System.in); // Keep the scanner open throughout

    @Override
    public void run(String... args) {
        try {
            // Take input from user for train number and date
            String trainNumber = getTrainNumber();
            String schedule = getTrainSchedule(trainNumber);
            System.out.println("Train Schedule: " + schedule);

            String date = getDate();
            String availability = checkSeatAvailability(trainNumber, date);
            System.out.println("Seat Availability on " + date + ": " + availability);

            // Optionally, add logic for booking the train or continue with other functionality.
            System.out.println("Would you like to book a ticket? (yes/no)");
            String bookingChoice = scanner.nextLine();
            if (bookingChoice.equalsIgnoreCase("yes")) {
                // Trigger booking functionality (add booking code here if necessary)
                System.out.println("Proceeding with ticket booking...");
            } else {
                System.out.println("Returning to main menu...");
            }

        } catch (Exception e) {
            // Handle exceptions, such as invalid input or issues with TrainService
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private String getTrainNumber() {
        System.out.println("Enter Train Number: ");
        return scanner.nextLine();
    }

    private String getTrainSchedule(String trainNumber) throws Exception {
        // Fetch and return train schedule from TrainService
        return trainService.getTrainSchedule(trainNumber);
    }

    private String getDate() {
        System.out.println("Enter Date (YYYY-MM-DD): ");
        return scanner.nextLine();
    }

    private String checkSeatAvailability(String trainNumber, String date) throws Exception {
        // Check and return seat availability from TrainService
        return trainService.checkSeatAvailability(trainNumber, date);
    }
}
