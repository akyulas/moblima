package com.moblima.Model.BookingSystem;

import com.moblima.Model.LoginSystem.Moviegoer;
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
	 * Construction of the Ticket class
	 * @param movie The movie that the moviegoer booked to see.
	 * @param cineplex The cineplex the moviegoer booked to see the movie in.
	 * @param cinema The cinema that the moviegoer booked to see the movie in.
	 * @param startTiming The starting time of the movie.
	 * @param bookedTiming The time the moviegoer booked the movie.
	 * @param moviegoerUserName The username of the moviegoer that booked the movie.
	 */
    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, LocalDateTime startTiming, LocalDateTime bookedTiming, String moviegoerUserName) {
        this(movie, cineplex, cinema, startTiming, bookedTiming, moviegoerUserName, 1);
    }

	/**
	 *
	 * @param movie The movie that the moviegoer booked to see.
	 * @param cineplex The cineplex the moviegoer booked to see the movie in.
	 * @param cinema The cinema that the moviegoer booked to see the movie in.
	 * @param startTiming The starting time of the movie.
	 * @param bookedTiming The time the moviegoer booked the movie.
	 * @param moviegoerUserName The username of the moviegoer that booked the movie.
	 * @param numberOfTickets The number of tickets the moviegoer booked during the booking.
	 */
    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, LocalDateTime startTiming, LocalDateTime bookedTiming, String moviegoerUserName, int numberOfTickets) {
    	this.movie = movie;
    	this.cinema = cinema;
    	this.startTiming = startTiming;
    	this.bookedTiming = bookedTiming;
    	this.cineplex = cineplex;
    	this.moviegoerUserName = moviegoerUserName;
    	this.numberOfTickets = numberOfTickets;
    }

	/**
	 * Get the movie that the moviegoer booked to see.
	 * @return The movie that the moviegoer booked to see.
	 */
	public Movie getMovie() {
    	return this.movie;
    }

	/**
	 * The calculation of the ticket price
	 * @param movie The movie that the moviegoer booked to see.
	 * @param cinema The cinema that the moviegoer booked to see the movie in.
	 * @param startTiming The starting time of the movie.
	 * @param age Age of the moviegoer.
	 * @param holidays The holidays inside the system.
	 * @return The price of the ticket.
	 */
    public static double calculateTicketPrice(Movie movie, Cinema cinema, LocalDateTime startTiming, int age, Holidays holidays) {
    	double result = 0.0;
    	switch(movie.getMovieType()) {
    		case _3D:
    			result += TicketPriceConfiguration.get3DPrice();
    			break;
    		case BlockBuster:
    			result += TicketPriceConfiguration.getBlockBusterPrice();
    			break;
    	}
    	switch(cinema.getClassType()) {
    		case NORMAL:
    			result += TicketPriceConfiguration.getNormalCinemaPrice();
    			break;
    		case PLANTINUM:
    			result += TicketPriceConfiguration.getPlantinumPrice();
    			break;
    		case ELITE:
    			result += TicketPriceConfiguration.getElitePrice();
    			break;
    	}
    	LocalDate startDate = startTiming.toLocalDate();
    	if (holidays.isHoliday(startDate)) {
    		result += TicketPriceConfiguration.getHolidayPrice();
    	} else if (startDate.getDayOfWeek() == DayOfWeek.SUNDAY || startDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
    		result += TicketPriceConfiguration.getWeekendPrice();
    	} else {
    		result += TicketPriceConfiguration.getWeekdayPrice();
    	}
    	if (age < 18) {
    		result += TicketPriceConfiguration.getChildrenPrice();
    	} else if (age < 55) {
    		result += TicketPriceConfiguration.getAdultPrice();
    	} else {
    		result += TicketPriceConfiguration.getSeniorCitizenPrice();
    	}
    	double GST = TicketPriceConfiguration.getGST() * result;
    	result += GST;
    	return result;
    }

	/**
	 * The toString that will be generated.
	 * @return toString
	 */
	public String toString() {
    	return "Movie: " + movie.getName() + ", Cineplex: " + cineplex.getName() + ", Cinema: " + cinema.getCode() +
    			", Movie Start Timing: " + Utilities.timeToString(startTiming) + ", Booking Time: " + 
    			Utilities.timeToString(bookedTiming) + ", Number Of Tickets: " + numberOfTickets;
    }

}
