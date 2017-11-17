package com.moblima.Controller;
import java.util.Scanner;

import com.moblima.Model.LoginSystem.Moviegoer;

/**
 * This is the main controller that will create other controllers.
 * It controls the flow of the program.
 */
public class MainController{

	/**
	 * The Import Controller that imports data from the text files
	 */
	private ImportController importController = new ImportController();

	/**
	 * The Login Controller that controls the login process
	 */
    private LoginController loginController;

	/**
	 * The Moviegoer Controller that controls the flow of the moviegoer part of the program
	 */
	private MoviegoerController moviegoerController;

	/**
	 * The Admin Controller that controls the flow of the admin part of the program
	 */
    private AdminController adminController;

	/**
	 * The Scanner that will be used to get input from the user
	 */
	private Scanner reader;

	/**
	 * Construction of the main controller
	 */
    public MainController() {
    	importController = new ImportController();
    	//Populate populate = new Populate(importController);
		reader = new Scanner(System.in);
	}

	/**
	 * The start of the main controller
	 */
    public void start() {
        System.out.println("Starting application");     
        System.out.println("Welcome to moblima.");
        importController.importData();
        continueInstructions();
    }

	/**
	 * The continuation of instructions inside the main controller.
	 * The part that controls the flow of the program.
	 */
	private void continueInstructions() {
		AllTheManagers allTheManagers = importController.getAllTheManagers();
		allTheManagers.clearOldDate();
    	MovieManager movieManager = allTheManagers.getMovieManager();
    	CineplexManager cineplexManager = allTheManagers.getCineplexManager();
    	UserManager userManager = allTheManagers.getUserManager();
    	BookingManager bookingManager = allTheManagers.getBookingManager();
		loginController = new LoginController(userManager, reader);
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
					adminController = new AdminController(movieManager, cineplexManager, bookingManager, userManager, reader);
					adminController.getAdminCommands();
				}
			}
		}
		end();
	}

	/**
	 * The ending of the main controller
	 */
    private void end() {
        System.out.println("Ending application");
        importController.export();
        reader.close();
        System.out.println("Goodbye!");
    }

}