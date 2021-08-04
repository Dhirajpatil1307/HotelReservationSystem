package com.hotelreservationsystem;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// class declaration
public class HotelReservation {
    private static Map<String, Hotel> hotelMap;
// constructor of class
    public HotelReservation() {
    hotelMap = new HashMap<>();
    }
// Method to add Hotel names and their regular weekday rates
    public boolean addHotel(String name, int regWeekdayRate) {
        Hotel hotelObject = new Hotel(name, regWeekdayRate);
        hotelMap.put(name, hotelObject);
        return true;
    }
    // Method to add Hotel names, rates of regular weekdays and weekends rates
    public boolean addHotel(String name, int regWeekdayRate, int regWeekendRate) {
        Hotel hotelObject = new Hotel(name, regWeekdayRate, regWeekendRate);
        hotelMap.put(name, hotelObject);
        return true;
    }
    // Method to find cheapest hotel
        public String findCheapestHotel(String fromDate, String toDate) {
        Map<Integer, ArrayList<Hotel>> rentMap = createRentMap(fromDate, toDate);
        int minimumRent = Integer.MAX_VALUE; // Assigns max possible value
            for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
                if (entry.getKey()<minimumRent){
                    minimumRent = entry.getKey();
                }
            }
            return rentMap.get(minimumRent).get(0).getHotelName();
        }
        // Method to calculate total rates of hotels  for given days
        public static Map<Integer, ArrayList<Hotel>> createRentMap(String fromDate, String toDate) {
        HashMap<Integer, ArrayList<Hotel>> rentMap = new HashMap<>();
        int numOfDays = numberOfDays(fromDate, toDate);
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            int rent = entry.getValue().getRegWeekdayRate()*numOfDays;
            rentMap.computeIfAbsent(rent, k -> new ArrayList<>()).add(entry.getValue());
        }
        return rentMap;
        }
        // method to calculate number fo days for given dates
        public static int numberOfDays(String fromDate, String toDate) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
            LocalDate from = LocalDate.parse(fromDate, formatter); // convert String to LocalDate
            LocalDate to = LocalDate.parse(toDate, formatter);
            int numOfDays = 0;
            for (LocalDate date = from; date.isBefore(to); date = date.plusDays(1)) {
                numOfDays++;
            }
        return numOfDays;
        }
        // Main method
        public static void main (String[]args){
            System.out.println("Welcome to Hotel reservation system");
        }
    }

