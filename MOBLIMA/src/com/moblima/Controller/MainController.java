package com.moblima.Controller;
import java.util.Scanner;

import com.moblima.Model.LoginSystem.Moviegoer;
import com.moblima.View.LoginView;

public class MainController{

	private ImportController importController = new ImportController();
	private Populate populate;
    private MovieManager movieManager;
    private CineplexManager cineplexManager;
    private UserManager userManager;
    private LoginController loginController;
    private BookingManager bookingManager;
    private MoviegoerController moviegoerController;
    private AdminController adminController;
    private Scanner reader;

    public MainController() {
    	importController = new ImportController();
    	populate = new Populate(importController);
    	importController.importData();
    	movieManager = importController.getMovieManager();
		cineplexManager = importController.getCineplexManager();
		userManager = importController.getUserManager();
		bookingManager = importController.getBookingManager();
		reader = new Scanner(System.in);
		loginController = new LoginController(userManager, reader);
	}

    public void start() {
        System.out.println("Starting application");     
        System.out.println("Welcome to moblima.");
        continueInstructions();
    }
	private void continueInstructions() {
    	boolean continueLoop= true;
    	while (continueLoop) {
    		loginController.getLoginInformation();
    		boolean quit = loginController.checkIfUserWantsToQuit();
    		if (quit) {
    			break;
			}
    		boolean loginSuccessful = loginController.checkSuccessOfLogin();
    		if (loginSuccessful) {
    			boolean runMoviegoerController = loginController.checkIfMoviegoer();
    			if (runMoviegoerController) {
    				Moviegoer moviegoer = loginController.getMoviegoer();
    				moviegoerController = new MoviegoerController(movieManager, cineplexManager, moviegoer, bookingManager, reader);
    				moviegoerController.getMoviegoerCommands();
				} else {
					adminController = new AdminController();
				}
			}
		}
		end();
	}

    private void end() {
        System.out.println("Ending application");
        importController.export();
        reader.close();
        System.out.println("Goodbye!");
    }

}