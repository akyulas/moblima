package com.moblima.BookingSystem;

import com.moblima.LoginSystem.User;

import java.util.HashMap;

public class BookingHistory {

    private User user;
    private Ticket ticket;

    public BookingHistory(User user, Ticket ticket) {
        this.user = user;
        this.ticket = ticket;
    }

}
