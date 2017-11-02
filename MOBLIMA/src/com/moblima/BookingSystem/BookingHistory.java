package com.moblima.BookingSystem;

import com.moblima.LoginSystem.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class BookingHistory implements Serializable{

    private User user;
    private ArrayList<Ticket> tickets;

    public BookingHistory(User user) {
        this.user = user;
        tickets = new ArrayList<Ticket>();
    }

}
