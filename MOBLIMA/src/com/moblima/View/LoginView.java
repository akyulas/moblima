package com.moblima.View;

import java.util.Scanner;

import com.moblima.Controller.UserManager;

/**
 * Created by jodiakyulas on 3/11/17.
 */
public class LoginView {

    private Scanner reader = new Scanner(System.in);

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

    public void tellUserLoginIsSuccessful() {
        System.out.println("The login is successful.");
    }

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
            } catch(RuntimeException e) {
                System.out.println("Please do not give an empty string.");
            }
        }
        return emailAddress;
    }

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

    public int getAdminID() {
        boolean continueLoop = true;
        int adminID = 0;
        while (continueLoop) {
            System.out.println("Please enter your admin ID:");
            try {
                adminID = Integer.parseInt(reader.nextLine());
                continueLoop = false;
            } catch(Exception e) {
                System.out.println("Please enter an integer");
            }
        }
        return adminID;
    }

}