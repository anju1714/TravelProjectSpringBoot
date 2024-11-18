package com.travel.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BookingInput implements CommandLineRunner {

    @Autowired
    private TrainBookingInput trainBookingInput; // Inject TrainBookingInput to call train booking functionality

    @Autowired
    private CabBookingInput cabBookingInput; // Inject CabBookingInput to call cab booking functionality

    @Autowired
    private HotelBookingInput hotelBookingInput; // Inject HotelBookingInput to call hotel booking functionality

    private Scanner scanner = new Scanner(System.in); // Do not close this scanner

    @Override
    public void run(String... args) {
        try {
            // Loop until user chooses to exit
            boolean running = true;
            while (running) {
                showMenu();
                System.out.println("Would you like to make another booking? (yes/no)");
                String continueChoice = scanner.nextLine();
                if (continueChoice.equalsIgnoreCase("no")) {
                    running = false;
                    System.out.println("Thank you for using the booking system!");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void showMenu() {
        try {
            // Show the booking options to the user
            System.out.println("Choose Booking Type:");
            System.out.println("1. Hotel Booking");  // Hotel booking as first option
            System.out.println("2. Train Booking");  // Train booking as second option
            System.out.println("3. Cab Booking");   // Cab booking as third option
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Call HotelBookingInput to handle hotel booking
                    hotelBookingInput.run();
                    break;
                case 2:
                    // Call TrainBookingInput to handle train booking
                    trainBookingInput.run();
                    break;
                case 3:
                    // Invoke cab booking functionality
                    cabBookingInput.run(); // Call run() method on injected instance
                    break;
                case 4:
                    System.out.println("Exiting the booking system...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while processing the booking: " + e.getMessage());
        }
    }
}
