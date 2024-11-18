package com.travel.start;

import com.travel.start.entity.CabBooking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CabBookingInput implements CommandLineRunner {

    @Autowired
    private CabBookingRepository cabBookingRepository;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Cab Booking Menu ---");
            System.out.println("1. Create Booking");
            System.out.println("2. Read Booking");
            System.out.println("3. Update Booking");
            System.out.println("4. Delete Booking");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:  // Create Booking
                    createBooking(scanner);
                    break;
                case 2:  // Read Booking
                    readBooking(scanner);
                    break;
                case 3:  // Update Booking
                    updateBooking(scanner);
                    break;
                case 4:  // Delete Booking
                    deleteBooking(scanner);
                    break;
                case 5:  // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to create a new booking
    private void createBooking(Scanner scanner) {
        System.out.print("Enter Pickup Location: ");
        String pickupLocation = scanner.nextLine();

        System.out.print("Enter Drop Location: ");
        String dropLocation = scanner.nextLine();

        System.out.print("Enter Cab Type: ");
        String cabType = scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        // Create new CabBooking object
        CabBooking newBooking = new CabBooking(pickupLocation, dropLocation, cabType, customerName, contactNumber);

        // Save to database
        cabBookingRepository.save(newBooking);
        System.out.println("Booking created successfully!");
    }

    // Method to read a booking by ID
    private void readBooking(Scanner scanner) {
        System.out.print("Enter Booking ID to view: ");
        int id = scanner.nextInt();

        CabBooking booking = cabBookingRepository.findById(id).orElse(null);
        if (booking != null) {
            System.out.println("Booking Details:");
            System.out.println("Pickup Location: " + booking.getPickupLocation());
            System.out.println("Drop Location: " + booking.getDropLocation());
            System.out.println("Cab Type: " + booking.getCabType());
            System.out.println("Customer Name: " + booking.getCustomerName());
            System.out.println("Contact Number: " + booking.getContactNumber());
        } else {
            System.out.println("Booking not found with ID: " + id);
        }
    }

    // Method to update a booking by ID
    private void updateBooking(Scanner scanner) {
        System.out.print("Enter Booking ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline

        CabBooking booking = cabBookingRepository.findById(id).orElse(null);
        if (booking != null) {
            System.out.println("Booking found. Enter new details (leave blank to keep current value):");

            System.out.print("Enter Pickup Location: ");
            String pickupLocation = scanner.nextLine();
            if (!pickupLocation.isEmpty()) booking.setPickupLocation(pickupLocation);

            System.out.print("Enter Drop Location: ");
            String dropLocation = scanner.nextLine();
            if (!dropLocation.isEmpty()) booking.setDropLocation(dropLocation);

            System.out.print("Enter Cab Type: ");
            String cabType = scanner.nextLine();
            if (!cabType.isEmpty()) booking.setCabType(cabType);

            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();
            if (!customerName.isEmpty()) booking.setCustomerName(customerName);

            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine();
            if (!contactNumber.isEmpty()) booking.setContactNumber(contactNumber);

            // Save updated booking
            cabBookingRepository.save(booking);
            System.out.println("Booking updated successfully!");
        } else {
            System.out.println("Booking not found with ID: " + id);
        }
    }

    // Method to delete a booking by ID
    private void deleteBooking(Scanner scanner) {
        System.out.print("Enter Booking ID to delete: ");
        int id = scanner.nextInt();

        if (cabBookingRepository.existsById(id)) {
            cabBookingRepository.deleteById(id);
            System.out.println("Booking deleted successfully!");
        } else {
            System.out.println("Booking not found with ID: " + id);
        }
    }
}
