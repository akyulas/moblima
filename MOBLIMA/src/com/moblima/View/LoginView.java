package com.moblima.View;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.moblima.Controller.UserManager;

/**
 * This is the login view that will be used to interact with the user for
 * login purposes.
 */
public class LoginView {

    /**
     * This is the scanner that will be used to get input from the user.
     */
    private Scanner reader;

    /**
     * The construction of the class
     * @param reader This is the scanner that will be used to get input from the user.
     */
    public LoginView(Scanner reader) {
    	this.reader = reader;
    }

    /**
     * This will be used to get the login input from the user.
     * @return The integer that indicates whether choice the user has made.
     */
    public int getLoginInput() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Do you want to login as:");
            System.out.println("1.Movie goer");
            System.out.println("2.Admin");
            System.out.println("0.Exit");
            try {
                input = Integer.parseInt(reader.nextLine());
                switch(input) {
                    case 0:
                        continueLoop = false;
                        break;
                    case 1:
                        continueLoop = false;
                        break;
                    case 2:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Please give the correct input.");
                }
            } catch(Exception e) {
                System.out.println("Please give an integer as an input.");
            }
        }
        return input;
    }

    /**
     * Show the moviegoer options to login or to register as a new moviegoer.
     * @return Integer that indicates the choice the moviegoer.
     */
    public int getMoviegoerLoginInput() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Do you want to:");
            System.out.println("1. Login as an existing user");
            System.out.println("2. Register as a new user");
            System.out.println("0. Exit");
            try {
                input = Integer.parseInt(reader.nextLine());
                switch (input) {
                    case 0:
                        continueLoop = false;
                        break;
                    case 1:
                        continueLoop = false;
                        break;
                    case 2:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Please give the correct input.");
                }
            } catch(Exception e) {
                System.out.println("Please give an integer as an input.");
            }
        }
        return input;
    }

    /**
     * Gets the username from the user
     * @return Username from the user
     */
    public String getUserName() {
        boolean continueLoop = true;
        String input = "";
        while (continueLoop) {
            System.out.println("Please enter your username:");
            try {
                input = reader.nextLine();
                if (input.equals("")) {
                    throw new RuntimeException();
                }
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not give an empty string.");
            }
        }
        return input;
    }

    /**
     * Gets the password from the user
     * @return Password from the user
     */
    public String getPassword() {
        boolean continueLoop = true;
        String input = "";
        while (continueLoop) {
            System.out.println("Please enter your password:");
            try {
                input = reader.nextLine();
                if (input.equals("")) {
                    throw new RuntimeException();
                }
                continueLoop = false;
            } catch(Exception e) {
                System.out.println("Please do not give an empty string.");
            }
        }
        return input;
    }

    /**
     * Used to tell the user the login is successful.
     */
    public void tellUserLoginIsSuccessful() {
        System.out.println("The login is successful.");
        System.out.println("Please press enter to continue.");
        reader.nextLine();
    }

    /**
     * Used to get the username that the moviegoer wants to register with.
     * @return The username the moviegoer wants to register with.
     */
    public String getNewUserName() {
        boolean continueLoop = true;
        String input = "";
        while (continueLoop) {
            System.out.println("Please enter new username:");
            try {
                input = reader.nextLine();
                if (input.equals("")) {
                    throw new RuntimeException();
                }
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not give an empty string.");
            }
        }
        return input;
    }

    /**
     * Used to get the password that the moviegoer wants to register with.
     * @return The password the moviegoer wants to register with.
     */
    public String getNewPassword() {
        boolean continueLoop = true;
        String input = "";
        String tempinput = "";
        while (continueLoop) {
            System.out.println("Please enter new password:");
            try {
                input = reader.nextLine();
                if (input.equals("")) {
                    throw new RuntimeException();
                }
                System.out.println("Please reenter the same password:");
                tempinput = reader.nextLine();
                if (input.equals(tempinput)) {
                    continueLoop = false;
                } else {
                    System.out.println("Please reuse the same password.");
                }
            } catch(RuntimeException e) {
                System.out.println("Please do not give an empty string.");
            }
        }
        return input;
    }

    /**
     * Used to get the age of the moviegoer.
     * @return The age of the moviegoer.
     */
    public int getMoviegoerAge() {
        boolean continueLoop = true;
        int age = 0;
        while (continueLoop) {
            System.out.println("Please enter your age:");
            try {
                age = Integer.parseInt(reader.nextLine());
                continueLoop = false;
            } catch(Exception e) {
                System.out.println("Please enter an integer");
            }
        }
        return age;
    }

    /**
     * Used to get the moviegoer's name.
     * @return The moviegoer's name.
     */
    public String getMoviegoerName() {
        boolean continueLoop = true;
        String name = "";
        while (continueLoop) {
            System.out.println("Please enter your name:");
            try {
                name = reader.nextLine();
                if (name.equals(""))
                    throw new RuntimeException();
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not give an empty string.");
            }
        }
        return name;
    }

    /**
     * Used to get the moviegoer's phone number.
     * @return The moviegoer's phone number.
     */
    public int getMoviegoerMobileNumber() {
        boolean continueLoop = true;
        int mobileNumber = 0;
        while (continueLoop) {
            System.out.println("Please enter your mobile number:");
            try {
                mobileNumber = Integer.parseInt(reader.nextLine());
                continueLoop = false;
            } catch(Exception e) {
                System.out.println("Please enter a series of integer");
            }
        }
        return mobileNumber;
    }

    /**
     * Used to get the moviegoer's email address.
     * @return The moviegoer's email address.
     */
    public String getEmailAddress() {
        boolean continueLoop = true;
        String emailAddress = "";
        while (continueLoop) {
            try {
                System.out.println("Please enter your email address:");
                emailAddress = reader.nextLine();
                if (emailAddress.equals("")) {
                    throw new RuntimeException();
                }
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not give an empty string.");
            }
        }
        return emailAddress;
    }

    /**
     * Used to tell the user the login is not successfully
     * @return The boolean that indicates whether the user wants to continue with the login.
     */
    public boolean tellUserLoginIsNotSuccessful() {
        boolean continueWithLogin = false;
        System.out.println("The login is not successful. Please enter the correct details.");
        System.out.println("Do you want to continue with the login:");
        System.out.println("Enter 1 for yes, others for no");
        try {
            int input = Integer.parseInt(reader.nextLine());
            switch(input) {
                case 1:
                    continueWithLogin = true;
                    break;
                default:
            }
        } catch(Exception e) {
        }
        return continueWithLogin;
    }

    /**
     * This will be used to get the admin login input.
     * @return The integer that will indicates the choice the user has made.
     */
    public int getAdminLoginInput() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Do you want to:");
            System.out.println("1. Login as an existing admin");
            System.out.println("0. Exit");
            try {
                input = Integer.parseInt(reader.nextLine());
                switch (input) {
                    case 0:
                        continueLoop = false;
                        break;
                    case 1:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Please give the correct input.");
                }
            } catch(Exception e) {
                System.out.println("Please give an integer as an input.");
            }
        }
        return input;
    }

    /**
     * Used to tell the user that the username has been chosen.
     */
    public void tellUserUserNameIsChosen() {
        System.out.println("Please choose another username. The current username is already being used.");
        System.out.println("Please press enter to continue.");
        reader.nextLine();
    }
}