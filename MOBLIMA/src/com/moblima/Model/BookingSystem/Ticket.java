package com.moblima.Model.BookingSystem;

import com.moblima.Model.LoginSystem.Moviegoer;
import com.moblima.Model.MovieSystem.Cinema;
import com.moblima.Model.MovieSystem.Cineplex;
import com.moblima.Model.MovieSystem.Movie;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket implements Serializable{

    private Movie movie;
    private Cinema cinema;
    private LocalDateTime startTiming;
    private Cineplex cineplex;
    private String moviegoerUserName;

    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, LocalDateTime startTiming, String moviegoerUserName) {
        this.movie = movie;
        this.cinema = cinema;
        this.startTiming = startTiming;
        this.cineplex = cineplex;
        this.moviegoerUserName = moviegoerUserName;
    }
    
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
    	return result;
    }

}
