package com.moblima.Model.BookingSystem;

import com.moblima.Model.MovieSystem.Cinema;
import com.moblima.Model.MovieSystem.Cineplex;
import com.moblima.Model.MovieSystem.Movie;
import com.moblima.Utilities.Utilities;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The ticket is generated everytime a booking is made.
 */
public class Ticket implements Serializable{

	/**
	 * The movie that the moviegoer booked to see.
	 */
    private Movie movie;

	/**
	 * The cinema that the moviegoer booked to see the movie in.
	 */
	private Cinema cinema;

	/**
	 * The starting time of the movie.
	 */
    private LocalDateTime startTiming;

    /**
	 * The cineplex the moviegoer booked to see the movie in.
     */
    private Cineplex cineplex;

	/**
	 * The username of the moviegoer that booked the movie.
	 */
	private String moviegoerUserName;

	/**
	 * The number of tickets the moviegoer booked during the booking.
	 */
    private int numberOfTickets;

    /**
	 * The time the moviegoer booked the movie.
     */
    private LocalDateTime bookedTiming;

	/**
	 * The name of the moviegoer.
	 */
	private String name;

	/**
	 * The mobile number of the moviegoer.
	 */
    private int mobileNumber;

	/**
	 * The email address of the moviegoer.
	 */
	private String emailAddress;

	/**
	 * The age group the moviegoer belongs to.
	 */
	private int ageGroup;

	/**
	 * Construction of the Ticket class
	 * @param movie The movie that the moviegoer booked to see.
	 * @param cineplex The cineplex the moviegoer booked to see the movie in.
	 * @param cinema The cinema that the moviegoer booked to see the movie in.
	 * @param startTiming The starting time of the movie.
	 * @param bookedTiming The time the moviegoer booked the movie.
	 * @param moviegoerUserName The username of the moviegoer that booked the movie.
	 * @param name The name of the moviegoer.
	 * @param mobileNumber The mobile number of the moviegoer.
	 * @param emailAddress The email address of the moviegoer.
	 * @param ageGroup The age group the moviegoer belongs to.
	 */
    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, LocalDateTime startTiming, LocalDateTime bookedTiming, String moviegoerUserName, String name, int mobileNumber, String emailAddress, int ageGroup) {
        this(movie, cineplex, cinema, startTiming, bookedTiming, moviegoerUserName, name, mobileNumber, emailAddress, ageGroup, 1);
    }

	/**
	 *
	 * @param movie The movie that the moviegoer booked to see.
	 * @param cineplex The cineplex the moviegoer booked to see the movie in.
	 * @param cinema The cinema that the moviegoer booked to see the movie in.
	 * @param startTiming The starting time of the movie.
	 * @param bookedTiming The time the moviegoer booked the movie.
	 * @param moviegoerUserName The username of the moviegoer that booked the movie.
	 * @param name The name of the moviegoer.
	 * @param mobileNumber The mobile number of the moviegoer.
	 * @param emailAddress The email address of the moviegoer.
	 * @param ageGroup The age group the moviegoer belongs to.
	 * @param numberOfTickets The number of tickets the moviegoer booked during the booking.
	 */
    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, LocalDateTime startTiming, LocalDateTime bookedTiming, String moviegoerUserName, String name, int mobileNumber, String emailAddress, int ageGroup, int numberOfTickets) {
    	this.movie = movie;
    	this.cinema = cinema;
    	this.startTiming = startTiming;
    	this.bookedTiming = bookedTiming;
    	this.cineplex = cineplex;
    	this.moviegoerUserName = moviegoerUserName;
    	this.numberOfTickets = numberOfTickets;
    	this.name = name;
    	this.mobileNumber = mobileNumber;
    	this.emailAddress = emailAddress;
    	this.ageGroup = ageGroup;
    }

	/**
	 * Get the movie that the moviegoer booked to see.
	 * @return The movie that the moviegoer booked to see.
	 */
	public Movie getMovie() {
    	return this.movie;
    }

	/**
	 * Get the name of the moviegoer.
	 * @return The name of the moviegoer.
	 */
	public String getName() {return name;}

	/**
	 * Get the email address of the moviegoer.
	 * @return The email address of the moviegoer.
	 */
    public String getEmailAddress() {return emailAddress;}

	/**
	 * Get the mobile number of the moviegoer.
	 * @return The mobile number of the moviegoer.
	 */
	public int getMobileNumber() {return mobileNumber;}

	/**
	 * Get the age group of the moviegoer.
	 * @return The age group of the moviegoer.
	 */
    public int getAgeGroup() {return ageGroup;}

	/**
	 * The calculation of the ticket price
	 * @param movie The movie that the moviegoer booked to see.
	 * @param cinema The cinema that the moviegoer booked to see the movie in.
	 * @param startTiming The starting time of the movie.
	 * @param ageGroup Age Group of the moviegoer.
	 * @param holidays The holidays inside the system.
	 * @return The price of the ticket.
	 * @param ticketPriceConfiguration The ticket price configuration that stores all the ticket price.
	 */
    public static double calculateTicketPrice(Movie movie, Cinema cinema, LocalDateTime startTiming, int ageGroup, Holidays holidays, TicketPriceConfiguration ticketPriceConfiguration) {
    	double result = 0.0;
    	switch(movie.getMovieType()) {
    		case _3D:
    			result += ticketPriceConfiguration.get3DPrice();
    			break;
    		case BlockBuster:
    			result += ticketPriceConfiguration.getBlockBusterPrice();
    			break;
    	}
    	switch(cinema.getClassType()) {
    		case NORMAL:
    			result += ticketPriceConfiguration.getNormalCinemaPrice();
    			break;
    		case PLANTINUM:
    			result += ticketPriceConfiguration.getPlantinumPrice();
    			break;
    		case ELITE:
    			result += ticketPriceConfiguration.getElitePrice();
    			break;
    	}
    	LocalDate startDate = startTiming.toLocalDate();
    	if (holidays.isHoliday(startDate)) {
    		result += ticketPriceConfiguration.getHolidayPrice();
    	} else if (startDate.getDayOfWeek() == DayOfWeek.SUNDAY || startDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
    		result += ticketPriceConfiguration.getWeekendPrice();
    	} else {
    		result += ticketPriceConfiguration.getWeekdayPrice();
    	}
    	if (ageGroup == 1 || ageGroup == 2) {
    		result += ticketPriceConfiguration.getChildrenPrice();
    	} else if (ageGroup == 3 || ageGroup == 4) {
    		result += ticketPriceConfiguration.getAdultPrice();
    	} else {
    		result += ticketPriceConfiguration.getSeniorCitizenPrice();
    	}
    	double GST = ticketPriceConfiguration.getGST() * result;
    	result += GST;
    	return result;
    }

	/**
	 * The toString that will be generated.
	 * @return toString
	 */
	public String toString() {
    	return "Movie: " + movie.getName() + "(" + movie.getMovieType() + ")" + ", Cineplex: " + cineplex.getName() + ", Cinema: " + cinema.getCode() +
    			", Movie Start Timing: " + Utilities.timeToString(startTiming) + ", Booking Time: " +
    			Utilities.timeToString(bookedTiming) + ", Number Of Tickets: " + numberOfTickets;
    }

}
