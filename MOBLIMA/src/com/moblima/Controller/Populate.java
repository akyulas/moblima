package com.moblima.Controller;

import static com.moblima.Model.MovieSystem.ClassType.ELITE;
import static com.moblima.Model.MovieSystem.ClassType.NORMAL;
import static com.moblima.Model.MovieSystem.ClassType.PLANTINUM;
import static com.moblima.Model.MovieSystem.MovieRating.NC16;
import static com.moblima.Model.MovieSystem.MovieRating.PG13;
import static com.moblima.Model.MovieSystem.MovieType.BlockBuster;
import static com.moblima.Model.MovieSystem.MovieType._3D;
import static com.moblima.Model.MovieSystem.StatusType.NOW_SHOWING;
import static com.moblima.Model.MovieSystem.StatusType.PREVIEW;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import com.moblima.Model.BookingSystem.Holidays;
import com.moblima.Model.BookingSystem.Ticket;
import com.moblima.Model.BookingSystem.TicketPriceConfiguration;
import com.moblima.Model.BookingSystem.TransactionID;
import com.moblima.Model.LoginSystem.Admin;
import com.moblima.Model.LoginSystem.Moviegoer;
import com.moblima.Model.MovieSystem.Cinema;
import com.moblima.Model.MovieSystem.Cineplex;
import com.moblima.Model.MovieSystem.Movie;
import com.moblima.Model.MovieSystem.MovieListing;
import com.moblima.Model.MovieSystem.Review;
import com.moblima.Model.MovieSystem.Timetable;

/**
 * This is the class used to populate the initial data.
 *
 */
public class Populate {
	
	/**
	 * Construction of the populate class.
	 * @param importController This is the import controller that imports data from the text files.
	 */
	public Populate(ImportController importController) {

        /* create new movie population */
    	    	
    	MovieManager movieManager = new MovieManager();

        ArrayList<Movie> movies = movieManager.getMovies();

        ArrayList<Movie> allMovies = movieManager.getAllMovies();

        /* Populate with American Assassin */

        ArrayList<String> casts = new ArrayList<String>();
        casts.add("Dylan O'Brien");
        casts.add("Michael Keaton");
        casts.add("Sanaa Lathan");
        casts.add("Shiva Negar");
        casts.add("Taylor Kitsch");

        ArrayList<Review> reviews = new ArrayList<Review>();
        reviews.add(new Review("apple", 0.0, "This movie is bad"));
        reviews.add(new Review("banana", 0.0, "This movie is bad"));
        reviews.add(new Review("cucumber", 0.0, "This movie is bad"));

        Movie movie = new Movie("American Assassin", NOW_SHOWING, "When Cold War veteran Stan Hurley takes CIA black ops recruit Mitch Rapp under his wing, they receive an assignment to investigate a wave of random attacks on both military and civilian targets. After discovering a pattern of violence, Hurley and Rapp join forces with a lethal Turkish agent to stop a mysterious operative who wants to start a global war.",
                "Michael Cuesta", BlockBuster, NC16, casts, reviews, LocalDate.of(2017, 12, 1));

        movies.add(movie);
        allMovies.add(movie);
        
        for (int i = 0; i < 500; i++) {
        	movie.increaseTicketSales();
        }

        /* Populate with Flatliners */

        casts = new ArrayList<String>();
        casts.add("Ellen Page");
        casts.add("Diego Luna");
        casts.add("Nina Dobrev");
        casts.add("James Norton");
        casts.add("Kiersey Clemons");
        casts.add("Kiefer Sutherland");

        reviews = new ArrayList<Review>();
        reviews.add(new Review("apple", 3.0, "This movie is average"));
        reviews.add(new Review("banana", 3.0, "This movie is average"));
        reviews.add(new Review("cucumber", 3.0, "This movie is average"));

        movie = new Movie("Flatliners", PREVIEW, "Five medical students embark on a daring and dangerous experiment to gain insight into the mystery of what lies beyond the confines of life. The bold adventure begins when they trigger near-death experiences by stopping their hearts for short periods of time. As their trials become more perilous, each must confront the sins from their past while facing the paranormal consequences of journeying to the other side.",
                "Joel Schumacher", BlockBuster, PG13, casts, reviews, LocalDate.of(2017, 12, 1));

        movies.add(movie);
        allMovies.add(movie);
        
        for (int i = 0; i < 1000; i++) {
        	movie.increaseTicketSales();
        }

        /* Populate with Thor*/

        casts = new ArrayList<String>();
        casts.add("Chris Hemsworth");
        casts.add("Tom Hiddleston");
        casts.add("Cate Blanchett");
        casts.add("Idris Elba");
        casts.add("Jeff Goldblum");
        casts.add("Tessa Thompson");
        casts.add("Karl Urban");
        casts.add("Mark Ruffalo");
        casts.add("Anthony Hopkins");

        reviews = new ArrayList<Review>();
        reviews.add(new Review("apple", 5.0, "This movie is good"));
        reviews.add(new Review("banana", 5.0, "This movie is good"));
        reviews.add(new Review("cucumber", 5.0, "This movie is good"));

        movie = new Movie("Marvel's Thor: Ragnarok", PREVIEW, "Thor is imprisoned on the other side of the universe without his mighty hammer and finds himself in a race against time to get back to Asgard to stop Ragnarok- the destruction of his homeworld and the end of Asgardian civilization- the hands of an all-powerful new threat, the ruthless Hela. But first he must survive a deadly gladiatorial contest that pits him against his former ally and fellow Avenger- the Incredible Hulk!",
                "Taika Waititi", _3D, PG13, casts, reviews, LocalDate.of(2017, 12, 1));
        
        movies.add(movie);
        allMovies.add(movie);
        
        for (int i = 0; i < 2000; i++) {
        	movie.increaseTicketSales();
        }

        /* create new cineplex population */
          
        CineplexManager cineplexManager = new CineplexManager();

        ArrayList<Cineplex> cineplexes = cineplexManager.getCineplexes();
    
        /* Populate cineplex with jurong point */
        
        Cineplex cineplex = new Cineplex("JurongPoint", "JurongPoint1", NORMAL, "JurongPoint2", PLANTINUM, "JurongPoint3", ELITE);
        ArrayList<MovieListing> movieListings = cineplex.getMovieListing();

        Cinema cinema = cineplex.getCinema("JurongPoint1");

        LocalDateTime start = LocalDateTime.of(2017, 11, 17, 14, 30);
        LocalDateTime end = LocalDateTime.of(2017, 11, 17, 16, 30);
        Timetable timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 17, 16, 30);
        end = LocalDateTime.of(2017, 11, 17, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));
        
        start = LocalDateTime.of(2017, 11, 17, 18, 30);
        end = LocalDateTime.of(2017, 11, 17, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));


        cinema = cineplex.getCinema("JurongPoint2");

        start = LocalDateTime.of(2017, 11, 17, 14, 30);
        end = LocalDateTime.of(2017, 11, 17, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 17, 16, 30);
        end = LocalDateTime.of(2017, 11, 17, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 17, 18, 30);
        end = LocalDateTime.of(2017, 11, 17, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cinema = cineplex.getCinema("JurongPoint3");

        start = LocalDateTime.of(2017, 11, 17, 14, 30);
        end = LocalDateTime.of(2017, 11, 17, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));
                
        start = LocalDateTime.of(2017, 11, 17, 16, 30);
        end = LocalDateTime.of(2017, 11, 17, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));
        
        start = LocalDateTime.of(2017, 11, 17, 18, 30);
        end = LocalDateTime.of(2017, 11, 17, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cineplexes.add(cineplex);

        //////////////////////////////////////////////////////////////////////

        cineplex = new Cineplex("VivoCity", "VivoCity1", NORMAL, "VivoCity2", PLANTINUM, "VivoCity3", ELITE);
        movieListings = cineplex.getMovieListing();

        cinema = cineplex.getCinema("VivoCity1");

        start = LocalDateTime.of(2017, 11, 17, 14, 30);
        end = LocalDateTime.of(2017, 11, 17, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 17, 16, 30);
        end = LocalDateTime.of(2017, 11, 17, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 17, 18, 30);
        end = LocalDateTime.of(2017, 11, 17, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cinema = cineplex.getCinema("VivoCity2");

        start = LocalDateTime.of(2017, 11, 17, 14, 30);
        end = LocalDateTime.of(2017, 11, 17, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 17, 16, 30);
        end = LocalDateTime.of(2017, 11, 17, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 17, 18, 30);
        end = LocalDateTime.of(2017, 11, 17, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cinema = cineplex.getCinema("VivoCity3");

        start = LocalDateTime.of(2017, 11, 17, 14, 30);
        end = LocalDateTime.of(2017, 11, 17, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 17, 16, 30);
        end = LocalDateTime.of(2017, 11, 17, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 17, 18, 30);
        end = LocalDateTime.of(2017, 11, 17, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));


        cineplexes.add(cineplex);

        ///////////////////////////////////////////////////////////////////////////////

        cineplex = new Cineplex("JEM", "JEM1", NORMAL, "JEM2", PLANTINUM, "JEM3", ELITE);
        movieListings = cineplex.getMovieListing();

        cinema = cineplex.getCinema("JEM1");

        start = LocalDateTime.of(2017, 11, 15, 14, 30);
        end = LocalDateTime.of(2017, 11, 15, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 15, 16, 30);
        end = LocalDateTime.of(2017, 11, 15, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 15, 18, 30);
        end = LocalDateTime.of(2017, 11, 15, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cinema = cineplex.getCinema("JEM2");

        start = LocalDateTime.of(2017, 11, 15, 14, 30);
        end = LocalDateTime.of(2017, 11, 15, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 15, 16, 30);
        end = LocalDateTime.of(2017, 11, 15, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 15, 18, 30);
        end = LocalDateTime.of(2017, 11, 15, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cinema = cineplex.getCinema("JEM3");

        start = LocalDateTime.of(2017, 11, 15, 14, 30);
        end = LocalDateTime.of(2017, 11, 15, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 15, 16, 30);
        end = LocalDateTime.of(2017, 11, 15, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 11, 15, 18, 30);
        end = LocalDateTime.of(2017, 11, 15, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cineplexes.add(cineplex);
        
        /* create new User Population */
        
        UserManager userManager = new UserManager();
        
        ArrayList<Admin> admins = userManager.getAdmins();
        Admin admin = new Admin("Admin1", "123");
        admins.add(admin);
        admin = new Admin("Admin2", "456");
        admins.add(admin);
        admin = new Admin("Admin3", "789");
        admins.add(admin);
        
        ArrayList<Moviegoer> moviegoers = userManager.getMoviegoers();
        Moviegoer moviegoer = new Moviegoer("apple", "123","Jonathan", 123456, "apple@ntu.edu.sg");
        moviegoers.add(moviegoer);
        moviegoer = new Moviegoer("banana", "456","Elliot", 123456, "banana@ntu.edu.sg");
        moviegoers.add(moviegoer);
        moviegoer = new Moviegoer("cucumber", "789", "Einstein", 123456, "cucumber@ntu.edu.sg");
        moviegoers.add(moviegoer);
        
        
        BookingManager bookingManager = new BookingManager();
        
        TicketPriceConfiguration ticketPriceConfiguration = bookingManager.getTicketPriceConfiguration();
        ticketPriceConfiguration.set3DPrice(2.00);
        ticketPriceConfiguration.setBlockBusterPrice(1.00);
        ticketPriceConfiguration.setNormalCinemaPrice(1.00);
        ticketPriceConfiguration.setPlantinumPrice(5.00);
        ticketPriceConfiguration.setElitePrice(10.00);
        ticketPriceConfiguration.setChildrenPrice(1.00);
        ticketPriceConfiguration.setAdultPrice(2.00);
        ticketPriceConfiguration.setSeniorCitizenPrice(1.00);
        ticketPriceConfiguration.setWeekdayPrice(0.00);
        ticketPriceConfiguration.setWeekendPrice(2.00);
        ticketPriceConfiguration.setHolidayPrice(3.00);
        ticketPriceConfiguration.setGSTRate(0.07);
        
        HashMap<String, ArrayList<Ticket>> bookingHistory = bookingManager.getBookingHistories();
        HashMap<TransactionID, Ticket> transactionIDStorage = bookingManager.getTransactionIDStorage();
        
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        cineplex = cineplexManager.searchForCineplex("JurongPoint");
        cinema = cineplexManager.searchForCinema("JurongPoint1");
        start = LocalDateTime.of(2017, 11, 15, 17, 30);
        LocalDateTime bookingTiming = LocalDateTime.of(2017, 11, 12, 14, 30);
        Ticket ticket = new Ticket(movie, cineplex, cinema, start, bookingTiming, "apple", "Jonathan", 123456, "apple@ntu.edu.sg", 2);
        bookingManager.addHistory("apple", ticket);
        transactionIDStorage.put(new TransactionID("JurongPoint1", 2017, 11, 15, 17, 30), ticket);
        
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        cineplex = cineplexManager.searchForCineplex("JurongPoint");
        cinema = cineplexManager.searchForCinema("JurongPoint2");
        start = LocalDateTime.of(2017, 11, 15, 17, 30);
        ticket = new Ticket(movie, cineplex, cinema, start, bookingTiming, "banana", "Elliot", 123456, "banana@ntu.edu.sg", 3);
        bookingManager.addHistory("banana", ticket);
        transactionIDStorage.put(new TransactionID("JurongPoint2", 2017, 11, 15, 17, 30), ticket);
        
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        cineplex = cineplexManager.searchForCineplex("JurongPoint");
        cinema = cineplexManager.searchForCinema("JurongPoint3");
        start = LocalDateTime.of(2017, 11, 15, 17, 30);
        ticket = new Ticket(movie, cineplex, cinema, start, bookingTiming, "cucumber", "Einstein", 123456, "cucumber@ntu.edu.sg", 4);
        bookingManager.addHistory("cucumber", ticket);
        transactionIDStorage.put(new TransactionID("JurongPoint3", 2017, 11, 15, 17, 30), ticket);
        
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        cineplex = cineplexManager.searchForCineplex("JurongPoint");
        cinema = cineplexManager.searchForCinema("JurongPoint1");
        start = LocalDateTime.of(2017, 11, 15, 17, 30);
        bookingTiming = LocalDateTime.of(2017, 11, 12, 14, 30);
        ticket = new Ticket(movie, cineplex, cinema, start, bookingTiming, "banana", "Elliot", 123456, "banana@ntu.edu.sg", 3);
        bookingManager.addHistory("banana", ticket);
        transactionIDStorage.put(new TransactionID("JurongPoint1", 2017, 11, 15, 17, 30), ticket);
        
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        cineplex = cineplexManager.searchForCineplex("JurongPoint");
        cinema = cineplexManager.searchForCinema("JurongPoint2");
        start = LocalDateTime.of(2017, 11, 15, 17, 30);
        ticket = new Ticket(movie, cineplex, cinema, start, bookingTiming, "cucumber", "Einstein", 123456, "cucumber@ntu.edu.sg", 4);
        bookingManager.addHistory("cucumber", ticket);
        transactionIDStorage.put(new TransactionID("JurongPoint2", 2017, 11, 15, 17, 30), ticket);
        
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        cineplex = cineplexManager.searchForCineplex("JurongPoint");
        cinema = cineplexManager.searchForCinema("JurongPoint3");
        start = LocalDateTime.of(2017, 11, 15, 17, 30);
        ticket = new Ticket(movie, cineplex, cinema, start, bookingTiming, "apple", "Jonathan", 123456, "apple@ntu.edu.sg", 2);
        bookingManager.addHistory("apple", ticket);
        transactionIDStorage.put(new TransactionID("JurongPoint3", 2017, 11, 15, 17, 30), ticket);
        
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        cineplex = cineplexManager.searchForCineplex("JurongPoint");
        cinema = cineplexManager.searchForCinema("JurongPoint1");
        start = LocalDateTime.of(2017, 11, 15, 17, 30);
        bookingTiming = LocalDateTime.of(2017, 11, 12, 14, 30);
        ticket = new Ticket(movie, cineplex, cinema, start, bookingTiming, "cucumber", "Einstein", 123456, "cucumber@ntu.edu.sg", 4);
        bookingManager.addHistory("cucumber", ticket);
        transactionIDStorage.put(new TransactionID("JurongPoint1", 2017, 11, 15, 17, 30), ticket);
        
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        cineplex = cineplexManager.searchForCineplex("JurongPoint");
        cinema = cineplexManager.searchForCinema("JurongPoint2");
        start = LocalDateTime.of(2017, 11, 15, 17, 30);
        ticket = new Ticket(movie, cineplex, cinema, start, bookingTiming, "apple", "Jonathan", 123456, "apple@ntu.edu.sg", 2);
        bookingManager.addHistory("apple", ticket);
        transactionIDStorage.put(new TransactionID("JurongPoint2", 2017, 11, 15, 17, 30), ticket);
        
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        cineplex = cineplexManager.searchForCineplex("JurongPoint");
        cinema = cineplexManager.searchForCinema("JurongPoint3");
        start = LocalDateTime.of(2017, 11, 15, 17, 30);
        ticket = new Ticket(movie, cineplex, cinema, start, bookingTiming, "banana", "Elliot", 123456, "banana@ntu.edu.sg", 3);
        bookingManager.addHistory("banana", ticket);
        transactionIDStorage.put(new TransactionID("JurongPoint3", 2017, 11, 15, 17, 30), ticket);
        
        
        Holidays holidays = bookingManager.getHolidays();
        holidays.addHoliday(LocalDate.of(2017, 11, 8), "Public Holiday 1");
        holidays.addHoliday(LocalDate.of(2017, 11, 9), "Public Holiday 2");
        holidays.addHoliday(LocalDate.of(2017, 11, 10), "Public Holiday 3");
        
        importController.setAllTheManagers(new AllTheManagers(bookingManager, cineplexManager, userManager, movieManager));
        
        importController.export();
	}
}
