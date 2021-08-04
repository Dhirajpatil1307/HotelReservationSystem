package com.hotelreservationsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationSystemTest {
    HotelReservation hotelReservation = new HotelReservation();
    @Test
    public void whenGivenHotelAdded_ShouldReturnTrue() {
        Assertions.assertTrue(hotelReservation.addHotel("Lakewood",110));
        Assertions.assertTrue(hotelReservation.addHotel("Bridgewood",160));
        Assertions.assertTrue(hotelReservation.addHotel("Ridgewood",110));
    }
    @Test
//    Test case to find the cheapest Hotel
    public void whenFindCheapestHotel_shouldReturn_nameOfHotel() {
        Assertions.assertTrue(hotelReservation.addHotel("Lakewood",110));
        Assertions.assertTrue(hotelReservation.addHotel("Bridgewood",160));
        Assertions.assertTrue(hotelReservation.addHotel("Ridgewood",210));
        Assertions.assertEquals("Lakewood", hotelReservation.findCheapestHotel("10Sep2020","11Sep2020"));
    }
}

