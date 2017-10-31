package com.moblima.LoginSystem;

import java.util.Scanner;

public class Admin extends User{

    private int id;

    public Admin(String username, String password, int id) {
        super(username, password);
        this.id = id;
    }

    public boolean verify(String username, String password) {
        if (getUsername().equals(username) && getPassword().equals(password)) {
            System.out.println("Please enter your staff ID for verification.");
            int id = new Scanner(System.in).nextInt();
            if (id == this.id)
                return true;
            return false;
        }
        return false;
    }

}
