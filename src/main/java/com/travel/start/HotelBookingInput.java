package com.travel.start;

import com.travel.start.entity.Hotel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class HotelBookingInput implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Hotel Booking Menu ---");
            System.out.println("1. Create Hotel");
            System.out.println("2. Read Hotel");
            System.out.println("3. Update Hotel");
            System.out.println("4. Delete Hotel");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:  // Create Hotel
                    createHotel(scanner);
                    break;
                case 2:  // Read Hotel
                    readHotel(scanner);
                    break;
                case 3:  // Update Hotel
                    updateHotel(scanner);
                    break;
                case 4:  // Delete Hotel
                    deleteHotel(scanner);
                    break;
                case 5:  // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to create a new hotel
    private void createHotel(Scanner scanner) {
        System.out.print("Enter Hotel ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();  // consume newline

        System.out.print("Enter Hotel Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Hotel Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Rooms Available: ");
        int roomsAvailable = scanner.nextInt();

        System.out.print("Enter Price Per Night: ");
        double pricePerNight = scanner.nextDouble();

        // Create new Hotel object
        Hotel newHotel = new Hotel(id, name, address, roomsAvailable, pricePerNight);

        // Save to database
        hotelRepository.save(newHotel);
        System.out.println("Hotel created successfully!");
    }

    // Method to read a hotel by ID
    private void readHotel(Scanner scanner) {
        System.out.print("Enter Hotel ID to view: ");
        Long id = scanner.nextLong();

        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            System.out.println("Hotel Details:");
            System.out.println("ID: " + hotel.getId());
            System.out.println("Name: " + hotel.getName());
            System.out.println("Address: " + hotel.getAddress());
            System.out.println("Rooms Available: " + hotel.getRoomsAvailable());
            System.out.println("Price Per Night: " + hotel.getPricePerNight());
        } else {
            System.out.println("Hotel not found with ID: " + id);
        }
    }

    // Method to update a hotel by ID
    private void updateHotel(Scanner scanner) {
        System.out.print("Enter Hotel ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine();  // consume newline

        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            System.out.println("Hotel found. Enter new details (leave blank to keep current value):");

            System.out.print("Enter Hotel Name: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) hotel.setName(name);

            System.out.print("Enter Hotel Address: ");
            String address = scanner.nextLine();
            if (!address.isEmpty()) hotel.setAddress(address);

            System.out.print("Enter Rooms Available: ");
            int roomsAvailable = scanner.nextInt();
            if (roomsAvailable > 0) hotel.setRoomsAvailable(roomsAvailable);

            System.out.print("Enter Price Per Night: ");
            double pricePerNight = scanner.nextDouble();
            if (pricePerNight > 0) hotel.setPricePerNight(pricePerNight);

            // Save updated hotel
            hotelRepository.save(hotel);
            System.out.println("Hotel updated successfully!");
        } else {
            System.out.println("Hotel not found with ID: " + id);
        }
    }

    // Method to delete a hotel by ID
    private void deleteHotel(Scanner scanner) {
        System.out.print("Enter Hotel ID to delete: ");
        Long id = scanner.nextLong();

        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            System.out.println("Hotel deleted successfully!");
        } else {
            System.out.println("Hotel not found with ID: " + id);
        }
    }
}
