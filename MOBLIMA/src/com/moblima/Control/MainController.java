package com.moblima.Control;
import java.util.Scanner;

public class MainController{

	private Populate populate = new Populate();
    private MovieManager movieManager = new MovieManager();
    private CineplexManager cineplexManager = new CineplexManager();
    private UserManager userManager = new UserManager();
    Scanner reader = new Scanner(System.in);
    int input;

    public void start() {
        System.out.println("Starting application");     
        movieManager.importData();
        cineplexManager.importData();
        userManager.importData();
        System.out.println("Welcome to moblima.");
        login();
    }

    private void login() {
    	boolean continueLoop = true;
    	while (continueLoop) {
    		System.out.println("Do you want to login as:");
        	System.out.println("1.User");
        	System.out.println("2.Admin");
        	System.out.println("0.Exit");
        	input = reader.nextInt();
        	switch(input) {
        		case 0:
        			continueLoop = false;
        			end(); 
        			break;
        		case 1: 
        			continueLoop = false;
        			moviegoerLogin();  
        			break;
        		case 2: 
        			continueLoop = false;
        			adminLogin();  
        			break; 
        		default: 
        			System.out.println("Please give the correct input."); 
            }
    	}
    	
    }
    
    private void moviegoerLogin() {
    	boolean continueLoop = true;
    	while (continueLoop) {
    		System.out.println("Do you want to:");
        	System.out.println("1. Login as an existing user");
        	System.out.println("2. Register as a new user");
        	System.out.println("0. Exit");
        	input = reader.nextInt();
        	switch(input) {
        		case 0: 
        			continueLoop = false;
        			login();
        			break;
        		case 1:
        			continueLoop = false;
        			existingMoviegoerLogin();
        			break;
        		case 2:
        			createNewMovieGoer();
        			break;
        		default:
        			System.out.println("Please give the correct input.");
        	}
    	}	
    }
    
    public void existingMoviegoerLogin() {
    	boolean continueLoop = true;
    	while (continueLoop) {
    		System.out.println("Please enter your username:");
        	String username = reader.next();
        	System.out.println("Please enter your password:");
        	String password = reader.next();
        	continueLoop = !(userManager.validateMovieGoerData(username, password));
        	if (continueLoop) {
        		System.out.println("Please enter a valid username and password:");
        		System.out.println("Do you want to continue with the login:");
        		System.out.println("Enter 1 for yes, others for no");
        		input = reader.nextInt();
        		switch(input) {
        			case 1:
        				break;
        			default:
        				continueLoop = false;
        		}
        	} else {
        		moviegoerCommand();
        	}
    	}
    }
    
    public void createNewMovieGoer() {
    	String password = "";
    	String tempPassword = "";
    	System.out.println("Enter the username that you want to use:");
    	String username = reader.nextLine();
    	boolean continueLoop = true;
    	while (continueLoop) {
    		System.out.println("Enter the password that you want to use:");
    		password = reader.nextLine();
    		System.out.println("Enter the password again:");
    		tempPassword = reader.nextLine();
    		if (password.equals(tempPassword)) {
    			continueLoop = false;
    		} else {
    			System.out.println("Please enter the same password two times:");
    		}
    	}
    	System.out.println("Please enter your age:");
		int age = reader.nextInt(); 
		System.out.println("Please enter your name:");
		String name = reader.nextLine();
		System.out.println("Please enter your mobile number:");
		int mobileNumber = reader.nextInt();
		System.out.println("Please enter your email address:");
		String email = reader.nextLine();
		userManager.addNewMoviegoer(username, password, age, name, mobileNumber, email);
		System.out.println("New user created!");
    }
    
    public void moviegoerCommand() {
    	boolean continueLoop = true;
    	while (continueLoop) {
    		System.out.println("Choose an option:");
    		System.out.println("1. Search/List movie");
    		System.out.println("2. View movie details – including reviews and ratings");
    		System.out.println("3. Check seat availability and selection of seat/s.");
    		System.out.println("4. Book and purchase ticket");
    		System.out.println("5. View booking history");
    		System.out.println("6. List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings");
    		System.out.println("0. Return to Movie Goer Login menu");
    		input = reader.nextInt();
    		switch(input) {
    			case 0:
    				login();
    			case 1:
    			case 2:
    			case 3:
    			case 4:
    			case 5:
    			case 6:
    			default:
    				System.out.println("");
    		}
    	}
    	
    }
    
    private void adminLogin() {
    	boolean continueLoop = true;
    	while (continueLoop) {
    		System.out.println("Do you want to:");
        	System.out.println("1. Login:");
        	System.out.println("0. Exit");
    	}	
    }
    
    public void existingAdminLogin() {
    	boolean continueLoop = true;
    	while (continueLoop) {
    		System.out.println("Please enter your username:");
        	String username = reader.next();
        	System.out.println("Please enter your password:");
        	String password = reader.next();
        	continueLoop = !(userManager.validateAdmin(username, password));
        	if (continueLoop) {
        		System.out.println("Please enter a valid username and password:");
        		System.out.println("Do you want to continue with the login:");
        		System.out.println("Enter 1 for yes, others for no");
        		input = reader.nextInt();
        		switch(input) {
        			case 1:
        				break;
        			default:
        				continueLoop = false;
        		}
        	} else {
        		adminCommand();
        	}
    	}
    }
    
    public void adminCommand() {
    }

    private void end() {
        System.out.println("Ending application");
        movieManager.exportData();
        cineplexManager.exportData();
        userManager.exportData();
        System.out.println("Goodbye!");
    }

}