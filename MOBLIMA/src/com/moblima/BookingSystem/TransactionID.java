package com.moblima.BookingSystem;

import java.io.Serializable;

public class TransactionID implements Serializable{

    private final String code;
    private final int year;
    private final int month;
    private final int day;
    private final int hour;
    private final int minutes;
    private final String transactionIDString;

    public TransactionID(String code, int year, int month, int day, int hour, int minutes) {
        this.code = code;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minutes = minutes;
        transactionIDString = code + Integer.toString(year) + Integer.toString(month) + Integer.toString(day) + Integer.toString(hour) + Integer.toString(minutes);
    }

    public String getCode() {
        return code;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getTransactionIDString() {
        return transactionIDString;
    }

}
