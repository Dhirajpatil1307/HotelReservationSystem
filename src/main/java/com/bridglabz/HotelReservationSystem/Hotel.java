package com.hotelreservationsystem;

public class Hotel {
    // Instance Variables
    private String hotelName;
    private int regWeekdayRate;
    private int regWeekendRate;
    private int hotelRating;

    // getter and setter methods for getting hotel rating.
    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }

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
    /**
     * constructor for Hotel class
     * @param hotelName;
     * @param regWeekdayRate;
     */
    public Hotel(String hotelName, int regWeekdayRate) {
        this.hotelName = hotelName;
        this.regWeekdayRate = regWeekdayRate;
    }

    /**
     * constructor overloading
     * @param hotelName;
     * @param regWeekdayRate;
     * @param regWeekendRate;
     */
    public Hotel(String hotelName, int regWeekdayRate, int regWeekendRate) {
        super();
        this.hotelName = hotelName;
        this.regWeekdayRate = regWeekdayRate;
        this.regWeekendRate = regWeekendRate;
    }
    /**
     * constructor overloading
     * @param hotelName;
     * @param regWeekdayRate;
     * @param regWeekendRate;
     * @param hotelRating;
     */
    public Hotel(String hotelName, int regWeekdayRate, int regWeekendRate, int hotelRating) {
        super();
        this.hotelName = hotelName;
        this.regWeekdayRate = regWeekdayRate;
        this.regWeekendRate = regWeekendRate;
        this.hotelRating = hotelRating;
    }
}
