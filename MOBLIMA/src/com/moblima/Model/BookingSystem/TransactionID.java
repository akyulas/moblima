package com.moblima.Model.BookingSystem;

import java.io.Serializable;

/**
 * This is the transactionID that is generated every booking.
 */
public class TransactionID implements Serializable{

    /**
     * The cinema code where the booking is made.
     */
    private final String code;

    /**
     * The year the booking is made.
     */
    private final int year;

    /**
     * The month the booking is made.
     */
    private final int month;

    /**
     * The day the booking is made.
     */
    private final int day;

    /**
     * The hour the booking is made.
     */
    private final int hour;

    /**
     * The minutes the booking is made.
     */
    private final int minutes;

    /**
     * The transactionID string that is generated.
     */
    private final String transactionIDString;

    /**
     *
     * @param code The cinema code where the booking is made.
     * @param year The year the booking is made.
     * @param month The month the booking is made.
     * @param day The day the booking is made.
     * @param hour The hour the booking is made.
     * @param minutes The minutes the booking is made.
     */
    public TransactionID(String code, int year, int month, int day, int hour, int minutes) {
        this.code = code;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minutes = minutes;
        transactionIDString = code + Integer.toString(year) + Integer.toString(month) + Integer.toString(day) + Integer.toString(hour) + Integer.toString(minutes);
    }

}
