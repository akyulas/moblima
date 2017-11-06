package com.moblima.Model.BookingSystem;

import com.moblima.Model.LoginSystem.User;

import java.io.Serializable;
import java.util.ArrayList;

public class BookingHistory implements Serializable{

    private User user;
    private ArrayList<Ticket> tickets;

    public BookingHistory(User user) {
        this.user = user;
        tickets = new ArrayList<Ticket>();
    }

}
