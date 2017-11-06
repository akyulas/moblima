package com.moblima.Model.LoginSystem;

import java.io.Serializable;
import java.util.Scanner;

public class Admin extends User implements Serializable{

    private int id;

    public Admin(String username, String password, int id) {
        super(username, password);
        this.id = id;
    }

    public boolean verify(String username, String password, int id) {
        if (getUsername().equals(username) && getPassword().equals(password) && this.id == id)
            return true;
        return false;
    }
    
    public String toString() {
    	return super.getUsername();
    }

}
