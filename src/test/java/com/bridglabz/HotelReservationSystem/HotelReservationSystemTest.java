package com.hotelreservationsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationSystemTest {
    HotelReservation hotelReservation = new HotelReservation();
    @Test
    public void whenNewHotelAdded_ShouldReturnTrue() {
        Assertions.assertTrue(hotelReservation.addHotel("Lakewood",110));
        Assertions.assertTrue(hotelReservation.addHotel("Bridgewood",160));
        Assertions.assertTrue(hotelReservation.addHotel("Ridgewood",110));

        hotelReservation.printHotels();
    }
}

