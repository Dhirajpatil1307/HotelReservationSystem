package com.hotelreservationsystem;

public class Hotel {
    // Instance Variables
    private String hotelName;
    private int regWeekdayRate;
    private int regWeekendRate;

    //getter and setter method for hotelName
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    // getter and setter method for regular weekday rates
    public int getRegWeekdayRate() {
        return regWeekdayRate;
    }
    public void setRegWeekdayRate(int regWeekdayRate) {
        this.regWeekdayRate = regWeekdayRate;
    }
    // getter and setter method for regular weekend days
    public int getRegWeekendRate() {
        return regWeekendRate;
    }
    public void setRegWeekendRate(int regWeekendRate) {
        this.regWeekendRate = regWeekendRate;
    }
    // constructor
    public Hotel(String hotelName, int regWeekdayRate) {
        this.hotelName = hotelName;
        this.regWeekdayRate = regWeekdayRate;
    }
    // constructor overloading
    public Hotel(String hotelName, int regWeekdayRate, int regWeekendRate) {
        super();
        this.hotelName = hotelName;
        this.regWeekdayRate = regWeekdayRate;
        this.regWeekendRate = regWeekendRate;
    }
}
