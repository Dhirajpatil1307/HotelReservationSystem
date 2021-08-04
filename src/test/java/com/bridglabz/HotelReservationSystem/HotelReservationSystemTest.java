package com.hotelreservationsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationSystemTest {
    HotelReservation hotelReservation = new HotelReservation();
    @Test
    public void whenGivenHotelAdded_ShouldReturnTrue()  {
        try {
            Assertions.assertTrue(hotelReservation.addHotel("Lakewood", 110));
            Assertions.assertTrue(hotelReservation.addHotel("Bridgewood", 160));
            Assertions.assertTrue(hotelReservation.addHotel("Ridgewood", 110));
        } catch (Exception | HotelReservationException exception) {
            System.out.println(exception);
        }
    }
    @Test
    public void whenFindCheapestHotel_shouldReturn_nameOfHotel() {
        try {
            Assertions.assertTrue(hotelReservation.addHotel("Lakewood", 110));
            Assertions.assertTrue(hotelReservation.addHotel("Bridgewood", 160));
            Assertions.assertTrue(hotelReservation.addHotel("Ridgewood", 80));
            Assertions.assertTrue(hotelReservation.findCheapestHotel("10Sep2020", "11Sep2020"));
        } catch (Exception | HotelReservationException exception) {
            System.out.println(exception);
        }
    }
    @Test
    public void whenNewHotelAddedWithWeekend_shouldReturnTrue() {
        try {
            Assertions.assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
            Assertions.assertTrue(hotelReservation.addHotel("Bridgewood", 150, 50));
            Assertions.assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
        } catch (Exception | HotelReservationException exception) {
            System.out.println(exception);
        }
    }
    @Test
    public void givenHotelNamesAndRates_findCheapestHotelAndReturnNameOfHotelWithRent() {
        try {
            Assertions.assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
            Assertions.assertTrue(hotelReservation.addHotel("Bridgewood", 150, 50));
            Assertions.assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
            Assertions.assertTrue(hotelReservation.findCheapestHotel("11Sep2020", "12Sep2020"));
        } catch (Exception | HotelReservationException exception) {
            System.out.println(exception);
        }
    }
    @Test
    public void whenNewHotelAddedWithRating_shouldReturnTrue() {
        try {
            Assertions.assertTrue(hotelReservation.addHotel("Lakewood", 110, 90, 3));
            Assertions.assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60, 4));
            Assertions.assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150, 5));
        } catch (Exception | HotelReservationException exception) {
            System.out.println(exception);
        }
    }
    @Test
    public void whenCheapestBestRatedCalled_shouldReturn_bestRatedHotel() {
        try {
            Assertions.assertTrue(hotelReservation.addHotel("Lakewood", 110, 90, 3));
            Assertions.assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60, 4));
            Assertions.assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150, 5));
            Assertions.assertTrue(hotelReservation.cheapestBestRatedHotel("11Sep2020", "12Sep2020"));
        } catch (Exception | HotelReservationException exception) {
            System.out.println(exception);
        }
    }
    @Test
    public void whenFindBestRatedMethodCalled_shouldReturn_bestRatedHotel() throws HotelReservationException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 110, 90, 3);
        hotelReservation.addHotel("Bridgewood", 150, 50, 4);
        hotelReservation.addHotel("Ridgewood", 220, 150, 5);
        Assertions.assertTrue(hotelReservation.findBestRatedHotelForGivenDates("11Sep2020", "12Sep2020"));
    }
    @Test
    public void whenAddedRatesForRewardCustomers_shouldAdd_hotelWithAllRates() throws HotelReservationException {
        HotelReservation hotelReservationObject = new HotelReservation();
        Assertions.assertTrue(hotelReservationObject.addHotel("Lakewood", 110, 90, 3, 80, 80));
        Assertions.assertTrue(hotelReservationObject.addHotel("Bridgewood", 150, 50, 4, 110, 50));
        Assertions.assertTrue(hotelReservationObject.addHotel("Ridgewood", 220, 150, 5, 100, 40));
    }
}


