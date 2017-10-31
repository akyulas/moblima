package com.moblima.LoginSystem;

public class Moviegoer extends User{

    private int age;
    private String name;
    private int mobileNumber;
    private String emailAddress;

    public Moviegoer(String username, String password, int age, String name, int mobileNumber, String emailAddress) {
        super(username, password);
        this.age = age;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
    }

    public boolean verify(String username, String password) {
        if (getUsername().equals(username) && getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
