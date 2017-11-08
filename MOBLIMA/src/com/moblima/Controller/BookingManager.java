package com.moblima.Controller;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import com.moblima.Model.BookingSystem.Holidays;
import com.moblima.Model.BookingSystem.Ticket;
import com.moblima.Model.BookingSystem.TicketPriceConfiguration;
import com.moblima.Model.BookingSystem.TransactionID;
import com.moblima.Model.MovieSystem.Movie;

public class BookingManager implements Serializable{
	
	private TicketPriceConfiguration ticketPriceConfiguration;
	private HashMap<String, ArrayList<Ticket>> bookingHistories;
	private ArrayList<TransactionID> transactionIDs;
	private Holidays holidays;
	
	public BookingManager() {
		ticketPriceConfiguration = new TicketPriceConfiguration();
		bookingHistories = new HashMap<String, ArrayList<Ticket>>();
		transactionIDs = new ArrayList<TransactionID>();
		holidays = new Holidays();
	}
	
	public TicketPriceConfiguration getTicketPriceConfiguration() {
		return ticketPriceConfiguration;
	}
	
	public HashMap<String, ArrayList<Ticket>> getBookingHistories() {
		return bookingHistories;
	}
	
	public ArrayList<TransactionID> getTransactionID() {
		return transactionIDs;
	}
	
	public Holidays getHolidays() {
		return holidays;
	}
	
	public void addHistory(String user, Ticket ticket) {
		if (bookingHistories.containsKey(user)) {
			bookingHistories.get(user).add(ticket);
		} else {
			bookingHistories.put(user, new ArrayList<Ticket>());
			bookingHistories.get(user).add(ticket);
		}
	}
	
	public void addTransactionID(String code) {
		LocalDateTime time = LocalDateTime.now();
		int year = time.getYear();
		int month = time.getMonthValue();
		int day = time.getDayOfMonth();
		int hour = time.getHour();
		int minute = time.getMinute();
		transactionIDs.add(new TransactionID(code, year, month, day, hour, minute));
	}
	
	public ArrayList<Ticket> getHistoryOfMoviegoer(String moviegoer) {
		if (bookingHistories.containsKey(moviegoer)) {
			return bookingHistories.get(moviegoer);
		}
		return new ArrayList<Ticket>();
	}
	
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
		
}
