package com.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// class declaration
public class HotelReservation {
    // instance of the class
    private static Map<String, Hotel> hotelMap;

    /**
     * class constructor
     */
    public HotelReservation() {
        hotelMap = new HashMap<>();
    }
    /**
     * this is the method to add the hotel name and regular weekday rates.
     * @param name;
     * @param regWeekdayRate;
     * @return boolean type
     * @throws HotelReservationException;
     */
    public boolean addHotel(String name, int regWeekdayRate) throws HotelReservationException {
        try {
            Hotel hotel = new Hotel(name, regWeekdayRate);
            hotelMap.put(name, hotel);
            if (name.length() < 2) {
                throw new HotelReservationException("Please enter the proper hotel name and RegWeekdayRate");
            }
            return true;
        } catch (NullPointerException exception) {
            throw new HotelReservationException("Please entered the proper name and rate");
        }
    }

    /**
     * method overloading
     * this is the method to add hotel name, regular weekday rates and regular weekend rates.
     * @param name;
     * @param regWeekdayRate;
     * @param regWeekendRate;
     * @return boolean type;
     * @throws HotelReservationException;
     */
    public boolean addHotel(String name, int regWeekdayRate, int regWeekendRate) throws HotelReservationException {
        try {
            Hotel hotel = new Hotel(name, regWeekdayRate, regWeekendRate);
            hotelMap.put(name, hotel);
            if (name.length() < 2) {
                throw new HotelReservationException("Please enter the proper hotel name and RegWeekdayRate");
            }
            return true;
        } catch (NullPointerException exception) {
            throw new HotelReservationException("Please entered the proper name and rate");
        }
    }

    /**
     * method overloading to add hotel hotelName, regular weekday rates, regular weekend rates and hotel rating
     * @param hotelName;
     * @param regWeekdayRate;
     * @param regWeekendRate;
     * @param hotelRating;
     * @return boolean type;
     * @throws HotelReservationException;
     */
    public boolean addHotel(String hotelName, int regWeekdayRate, int regWeekendRate, int hotelRating) throws HotelReservationException {
        try {
            Hotel hotel = new Hotel(hotelName, regWeekdayRate, regWeekendRate, hotelRating);
            hotelMap.put(hotelName, hotel);
            if (hotelName.length() < 2) {
                throw new HotelReservationException("Please enter the proper hotel hotelName and RegWeekdayRate");
            }
            return true;
        } catch (NullPointerException exception) {
            throw new HotelReservationException("Please entered the proper hotelName and rate");
        }
    }

    /**
     * this is the method to find the cheapest hotel.
     * @param fromDate;
     * @param toDate;
     * @return boolean;
     */
    public boolean findCheapestHotel(String fromDate, String toDate) {
        Map<Integer, ArrayList<Hotel>> rentMap = createRentMap(fromDate, toDate);
        int minimumRent = Integer.MAX_VALUE; // Assigns max possible value
        for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
            if (entry.getKey() < minimumRent) {
                minimumRent = entry.getKey();
            }
        }
        for (Hotel hotel : rentMap.get(minimumRent)) {
            System.out.print(hotel.getHotelName() + "  ");
        }
        return true;
    }

    /**
     * this is the method to find the cheapest hotel with best rating.
     * @param fromDate;
     * @param toDate;
     * @return boolean type;
     */
    public boolean cheapestBestRatedHotel(String fromDate, String toDate) {
        Map<Integer, ArrayList<Hotel>> rentMap = createRentMap(fromDate, toDate);
        int minimumRent = Integer.MAX_VALUE;
        for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
            if (entry.getKey() < minimumRent)
                minimumRent = entry.getKey();
        }
        ArrayList<Hotel> cheapestHotels = rentMap.get(minimumRent);
        String bestRatedCheapestHotel = "";
        int rating = 0;
        for (Hotel hotel : cheapestHotels) {
            if (hotel.getHotelRating() > rating) {
                bestRatedCheapestHotel = hotel.getHotelName();
                rating = hotel.getHotelRating();
            }
        }
        System.out.println("Cheapest Hotel for you is " + bestRatedCheapestHotel + " with Rating " + rating + " Total Rent : "
                + minimumRent + "\n");
        return true;
    }

    /**
     * this is method to find the best rated hotel for given dates.
     * @param fromDate;
     * @param toDate;
     * @return boolean type;
     */
    public boolean findBestRatedHotelForGivenDates(String fromDate, String toDate) {
        int rating = 0;
        int rent = 0;
        String bestRatedHotel = "";
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            if (entry.getValue().getHotelRating() > rating) {
                rating = entry.getValue().getHotelRating();
                bestRatedHotel = entry.getKey();
                rent = calculateRent(fromDate, toDate, entry.getValue().getRegWeekdayRate(),
                        entry.getValue().getRegWeekendRate());
            }
        }
        System.out.println("Best Rated Hotel : " + bestRatedHotel + ", Rent : " + rent);
        return true;
    }

    /**
     * this is method to calculate total rent for given date.
     * @param fromDate;
     * @param toDate;
     * @param weekdayRate;
     * @param weekendRate;
     * @return integer type;
     */
    public static int calculateRent(String fromDate, String toDate, int weekdayRate, int weekendRate) {
        int[] numOfDays = numberOfDays(fromDate, toDate);
        int weekdayRent = weekdayRate * numOfDays[0];
        int weekendRent = weekendRate * numOfDays[1];
        return weekdayRent + weekendRent;
    }
    /**
     * this is the method to calculate total rate for given days.
     * @param fromDate;
     * @param toDate;
     * @return rent
     */
    public static Map<Integer, ArrayList<Hotel>> createRentMap(String fromDate, String toDate) {
        HashMap<Integer, ArrayList<Hotel>> rentMap = new HashMap<>();
        int[] days = numberOfDays(fromDate, toDate);
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            int weekdayRent = entry.getValue().getRegWeekdayRate() * days[0];
            int weekendRent = entry.getValue().getRegWeekendRate() * days[1];
            int totalRent = weekdayRent + weekendRent;
            rentMap.computeIfAbsent(totalRent, k -> new ArrayList<>()).add(entry.getValue());
        }
        return rentMap;
    }

    /**
     * this is the method to calculate the number of the days for given date date range.
     * @param fromDate;
     * @param toDate;
     * @return days.
     */
    public static int[] numberOfDays(String fromDate, String toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDate from = LocalDate.parse(fromDate, formatter); // convert String to LocalDate
        LocalDate to = LocalDate.parse(toDate, formatter);
        int numWeekdays = 0;
        int numWeekendDays = 0;
        int[] days;
        days = new int[2];
        for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
            DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
            switch (day) {
                case SATURDAY, SUNDAY -> numWeekendDays++;
                default -> numWeekdays++;
            }
        }
        days[0] = numWeekdays;
        days[1] = numWeekendDays;
        return days;
    }
    // Main method
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel reservation system");
    }
}


