package com.moblima.Controller;

import java.io.Serializable;

public class AllTheManagers implements Serializable{

	/**
	 * This is the booking manager that stores things related to the booking system and it is
	 * used to control the booking processes.
	 */
	private BookingManager bookingManager;
	
	/**
	 * This is the cineplex manager that stores the cineplexes and it is used to control
	 * the cineplex processes.
	 */
	private CineplexManager cineplexManager;
	
	/**
	 * This is the user manager that stores the users and it is used to control
	 * the user processes.
	 */
	private UserManager userManager;
	
	/**
	 * This is the movie manager that stores the movies and it is used to control
	 * the movies processes.
	 */
	private MovieManager movieManager;

	/**
	 * Construction of the all the managers class.
	 * @param bookingManager This is the booking manager that stores things related to the booking system and it is
	 * used to control the booking processes.
	 * @param cineplexManager This is the cineplex manager that stores the cineplexes and it is used to control
	 * the cineplex processes.
	 * @param userManager This is the user manager that stores the users and it is used to control
	 * the user processes.
	 * @param movieManager This is the movie manager that stores the movies and it is used to control
	 * the movies processes.
	 */
	public AllTheManagers(BookingManager bookingManager, CineplexManager cineplexManager, UserManager userManager, MovieManager movieManager) {
		this.bookingManager = bookingManager;
		this.cineplexManager = cineplexManager;
		this.userManager = userManager;
		this.movieManager = movieManager;
	}
	
	/**
	 * Remove outdated data inside each manager.
	 */
	public void clearOldDate() {
		movieManager.removeOldMovies();
		cineplexManager.removeOldMovieListings();
		bookingManager.removeOldHolidayDates();
	}
	
	/**
	 * Return the booking manager to the caller.
	 * @return The booking manager.
	 */
	public BookingManager getBookingManager() {
		return bookingManager;
	}
	
	/**
	 * Return the cineplex manager to the caller.
	 * @return The cineplex manager.
	 */
	public CineplexManager getCineplexManager() {
		return cineplexManager;
	}
	
	/**
	 * Return the user manager to the caller.
	 * @return The user manager.
	 */
	public UserManager getUserManager() {
		return userManager;
	}
	
	/**
	 * Return the movie manager to the caller.
	 * @return The movie manager.
	 */
	public MovieManager getMovieManager() {
		return movieManager;
	}
	
}
