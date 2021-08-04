package com.hotelreservationsystem;

import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
    private static Map<String, Hotel> hotelMap;

    public HotelReservation() {
    hotelMap = new HashMap<>();
    }
// Method to add Hotel names and rates
    public boolean addHotel(String name, int regWeekdayRate) {
        Hotel hotelObject = new Hotel(name, regWeekdayRate);
        hotelMap.put(name, hotelObject);
        return true;
    }

    public void printHotels() {
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            System.out.println("Hotel Name : " + entry.getKey());
            System.out.println("Rate on weekdays for regular customers : " + entry.getValue().getRegWeekdayRate());
        }
    }
        public static void main (String[]args){
            System.out.println("Welcome to Hotel reservation system");
        }
    }
