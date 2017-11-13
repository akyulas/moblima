package com.moblima.Controller;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.moblima.Model.BookingSystem.Holidays;
import com.moblima.Model.BookingSystem.Ticket;
import com.moblima.Model.BookingSystem.TicketPriceConfiguration;
import com.moblima.Model.BookingSystem.TransactionID;
import com.moblima.Model.MovieSystem.Movie;

/**
 * This is the booking manager that stores the relevant stuff to the booking system and it is used to control
 * the booking processes.
 */
public class BookingManager implements Serializable{

	/**
	 * This is the ticket price configuration that stores the price inside the system.
	 */
	private TicketPriceConfiguration ticketPriceConfiguration;

	/**
	 * This is the booking histories of moviegoers inside the system.
	 */
	private HashMap<String, ArrayList<Ticket>> bookingHistories;

	/**
	 * This is the transactionIDs that are stored inside the system.
	 */
	private ArrayList<TransactionID> transactionIDs;

	/**
	 * This is the holidays that are stored inside the system.
	 */
	private Holidays holidays;

	/**
	 * Construction of the booking manager
	 */
	public BookingManager() {
		ticketPriceConfiguration = new TicketPriceConfiguration();
		bookingHistories = new HashMap<String, ArrayList<Ticket>>();
		transactionIDs = new ArrayList<TransactionID>();
		holidays = new Holidays();
	}

	/**
	 * Return the ticket price configuration to the caller.
	 * @return The ticket price configuration.
	 */
	public TicketPriceConfiguration getTicketPriceConfiguration() {
		return ticketPriceConfiguration;
	}

	/**
	 * Return the booking history to the caller.
	 * @return The booking history.
	 */
	public HashMap<String, ArrayList<Ticket>> getBookingHistories() {
		return bookingHistories;
	}

	/**
	 * Return the transactionIDs that are stored inside the system.
	 * @return The transactionIDs that are stored inside the system.
	 */
	public ArrayList<TransactionID> getTransactionID() {
		return transactionIDs;
	}

	/**
	 * Return the holidays that are stored inside the system.
	 * @return The holidays that are inside the system.
	 */
	public Holidays getHolidays() {
		return holidays;
	}

	/**
	 * Add a holiday into the system.
	 * @param holiday The date of the holiday.
	 * @param description The description of the holiday.
	 */
	public void addHolidays(LocalDate holiday, String description) {
		holidays.addHoliday(holiday, description);
	}

	/**
	 * Add the ticket of a booking into the moviegoer's history.
	 * @param user The moviegoer's username
	 * @param ticket The ticket from the booking
	 */
	public void addHistory(String user, Ticket ticket) {
		if (bookingHistories.containsKey(user)) {
			bookingHistories.get(user).add(ticket);
		} else {
			bookingHistories.put(user, new ArrayList<Ticket>());
			bookingHistories.get(user).add(ticket);
		}
	}

	/**
	 * Add the transactionID from a booking to the system.
	 * @param code The transactionID
	 */
	public void addTransactionID(String code) {
		LocalDateTime time = LocalDateTime.now();
		int year = time.getYear();
		int month = time.getMonthValue();
		int day = time.getDayOfMonth();
		int hour = time.getHour();
		int minute = time.getMinute();
		transactionIDs.add(new TransactionID(code, year, month, day, hour, minute));
	}

	/**
	 * Return the booking history of a moviegoer.
	 * @param moviegoer The username of the moviegoer.
	 * @return The booking history of a moviegoer.
	 */
	public ArrayList<Ticket> getHistoryOfMoviegoer(String moviegoer) {
		if (bookingHistories.containsKey(moviegoer)) {
			return bookingHistories.get(moviegoer);
		}
		return new ArrayList<Ticket>();
	}

	/**
	 * Return the movies that the moviegoer can give a review on.
	 * @param moviegoer The username of the moviegoer.
	 * @return The movies the moviegoer can give a review on.
	 */
	public ArrayList<Movie> getMoviesForReview(String moviegoer) {
		ArrayList<Movie> temp = new ArrayList<Movie>();
		ArrayList<Ticket> tickets = getHistoryOfMoviegoer(moviegoer);
		for (Ticket ticket: tickets) {
			Movie movie = ticket.getMovie();
			if (!movie.hasMoviegoerAddedReview(moviegoer)) {
				temp.add(movie);
			}
		}
		return temp;
	}

	/**
	 * Remove the holidays that have already been passed.
	 */
	public void removeOldHolidayDates() {
		LocalDate currentDate = LocalDate.now();
		HashMap<LocalDate, String> holidayDates = holidays.getHoliday();
		Iterator<Map.Entry<LocalDate,String>> iterator = holidayDates.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<LocalDate,String> entry = iterator.next();
			if(entry.getKey().isBefore(currentDate)){
				iterator.remove();
			}
		}
	}
		
}
