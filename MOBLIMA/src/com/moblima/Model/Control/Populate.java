package com.moblima.Model.Control;

import com.moblima.Controller.ImportController;
import com.moblima.Model.LoginSystem.Admin;
import com.moblima.Model.LoginSystem.Moviegoer;
import com.moblima.Model.MovieSystem.*;

import java.util.ArrayList;

import static com.moblima.Model.MovieSystem.MovieRating.*;
import static com.moblima.Model.MovieSystem.MovieType.*;
import static com.moblima.Model.MovieSystem.StatusType.*;
import static com.moblima.Model.MovieSystem.ClassType.*;
import java.time.*;

public class Populate {

    private ImportController importController;

    public Populate(ImportController importController) {

        /* create new movie population */
        this.importController = importController;
    	
        MovieManager movieManager = new MovieManager(importController);
        movieManager.wipeOutData();
        movieManager.importData();

        ArrayList<Movie> movies = movieManager.getMovies();

        /* Populate with American Assassin */

        ArrayList<String> casts = new ArrayList<String>();
        casts.add("Dylan O'Brien");
        casts.add("Michael Keaton");
        casts.add("Sanaa Lathan");
        casts.add("Shiva Negar");
        casts.add("Taylor Kitsch");

        ArrayList<Review> reviews = new ArrayList<Review>();
        reviews.add(new Review("apple", 5.0, "This movie is good"));
        reviews.add(new Review("banana", 3.0, "This movie is average"));
        reviews.add(new Review("cucumber", 0.0, "This movie is bad"));

        Movie movie = new Movie("American Assassin", NOW_SHOWING, "When Cold War veteran Stan Hurley takes CIA black ops recruit Mitch Rapp under his wing, they receive an assignment to investigate a wave of random attacks on both military and civilian targets. After discovering a pattern of violence, Hurley and Rapp join forces with a lethal Turkish agent to stop a mysterious operative who wants to start a global war.",
                "Michael Cuesta", BlockBuster, NC16, casts, reviews);

        movies.add(movie);

        /* Populate with Flatliners */

        casts = new ArrayList<String>();
        casts.add("Ellen Page");
        casts.add("Diego Luna");
        casts.add("Nina Dobrev");
        casts.add("James Norton");
        casts.add("Kiersey Clemons");
        casts.add("Kiefer Sutherland");

        reviews = new ArrayList<Review>();
        reviews.add(new Review("apple", 5.0, "This movie is good"));
        reviews.add(new Review("banana", 3.0, "This movie is average"));
        reviews.add(new Review("cucumber", 0.0, "This movie is bad"));

        movie = new Movie("Flatliners", COMING_SOON, "Five medical students embark on a daring and dangerous experiment to gain insight into the mystery of what lies beyond the confines of life. The bold adventure begins when they trigger near-death experiences by stopping their hearts for short periods of time. As their trials become more perilous, each must confront the sins from their past while facing the paranormal consequences of journeying to the other side.",
                "Joel Schumacher", BlockBuster, PG13, casts, reviews);

        movies.add(movie);

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
        reviews.add(new Review("banana", 3.0, "This movie is average"));
        reviews.add(new Review("cucumber", 0.0, "This movie is bad"));

        movie = new Movie("Marvel's Thor: Ragnarok", PREVIEW, "Thor is imprisoned on the other side of the universe without his mighty hammer and finds himself in a race against time to get back to Asgard to stop Ragnarok- the destruction of his homeworld and the end of Asgardian civilization- the hands of an all-powerful new threat, the ruthless Hela. But first he must survive a deadly gladiatorial contest that pits him against his former ally and fellow Avenger- the Incredible Hulk!",
                "Taika Waititi", _3D, PG13, casts, reviews);

        movies.add(movie);
        
        movieManager.exportData();
        
        /* create new cineplex population */
          
        CineplexManager cineplexManager = new CineplexManager(importController);
        cineplexManager.wipeOutData();
        cineplexManager.importData();

        ArrayList<Cineplex> cineplexes = cineplexManager.getCineplexes();
    
        /* Populate cineplex with jurong point */
        
        Cineplex cineplex = new Cineplex("JurongPoint");
        ArrayList<MovieListing> movieListings = cineplex.getMovieListing();

        Cinema cinema = new Cinema("JurongPoint1", NORMAL);
        cineplex.addCinema(cinema);

        LocalDateTime start = LocalDateTime.of(2017, 10, 29, 14, 30);
        LocalDateTime end = LocalDateTime.of(2017, 10, 29, 16, 30);
        Timetable timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 16, 30);
        end = LocalDateTime.of(2017, 10, 29, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));
        
        start = LocalDateTime.of(2017, 10, 29, 18, 30);
        end = LocalDateTime.of(2017, 10, 29, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));
        

        cinema = new Cinema("JurongPoint2", PLANTINUM);
        cineplex.addCinema(cinema);

        start = LocalDateTime.of(2017, 10, 29, 14, 30);
        end = LocalDateTime.of(2017, 10, 29, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 16, 30);
        end = LocalDateTime.of(2017, 10, 29, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 18, 30);
        end = LocalDateTime.of(2017, 10, 29, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cinema = new Cinema("JurongPoint3", ELITE);
        cineplex.addCinema(cinema);

        start = LocalDateTime.of(2017, 10, 29, 14, 30);
        end = LocalDateTime.of(2017, 10, 29, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));
                
        start = LocalDateTime.of(2017, 10, 29, 16, 30);
        end = LocalDateTime.of(2017, 10, 29, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));
        
        start = LocalDateTime.of(2017, 10, 29, 18, 30);
        end = LocalDateTime.of(2017, 10, 29, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cineplexes.add(cineplex);
        
        //////////////////////////////////////////////////////////////////////

        cineplex = new Cineplex("VivoCity");
        movieListings = cineplex.getMovieListing();

        cinema = new Cinema("VivoCity1", NORMAL);
        cineplex.addCinema(cinema);

        start = LocalDateTime.of(2017, 10, 29, 14, 30);
        end = LocalDateTime.of(2017, 10, 29, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 16, 30);
        end = LocalDateTime.of(2017, 10, 29, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 18, 30);
        end = LocalDateTime.of(2017, 10, 29, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cinema = new Cinema("VivoCity2", PLANTINUM);
        cineplex.addCinema(cinema);

        start = LocalDateTime.of(2017, 10, 29, 14, 30);
        end = LocalDateTime.of(2017, 10, 29, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 16, 30);
        end = LocalDateTime.of(2017, 10, 29, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 18, 30);
        end = LocalDateTime.of(2017, 10, 29, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cinema = new Cinema("VivoCity3", ELITE);
        cineplex.addCinema(cinema);

        start = LocalDateTime.of(2017, 10, 29, 14, 30);
        end = LocalDateTime.of(2017, 10, 29, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 16, 30);
        end = LocalDateTime.of(2017, 10, 29, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 18, 30);
        end = LocalDateTime.of(2017, 10, 29, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cineplexes.add(cineplex);

        ///////////////////////////////////////////////////////////////////////////////

        cineplex = new Cineplex("JEM");
        movieListings = cineplex.getMovieListing();

        cinema = new Cinema("JEM1", NORMAL);
        cineplex.addCinema(cinema);

        start = LocalDateTime.of(2017, 10, 29, 14, 30);
        end = LocalDateTime.of(2017, 10, 29, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 16, 30);
        end = LocalDateTime.of(2017, 10, 29, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 18, 30);
        end = LocalDateTime.of(2017, 10, 29, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cinema = new Cinema("JEM2", PLANTINUM);
        cineplex.addCinema(cinema);

        start = LocalDateTime.of(2017, 10, 29, 14, 30);
        end = LocalDateTime.of(2017, 10, 29, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 16, 30);
        end = LocalDateTime.of(2017, 10, 29, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 18, 30);
        end = LocalDateTime.of(2017, 10, 29, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cinema = new Cinema("JEM3", ELITE);
        cineplex.addCinema(cinema);

        start = LocalDateTime.of(2017, 10, 29, 14, 30);
        end = LocalDateTime.of(2017, 10, 29, 16, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("American Assassin", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 16, 30);
        end = LocalDateTime.of(2017, 10, 29, 18, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Flatliners", BlockBuster);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        start = LocalDateTime.of(2017, 10, 29, 18, 30);
        end = LocalDateTime.of(2017, 10, 29, 20, 30);
        timetable = new Timetable(start, end);
        cinema.addTimetable(timetable);
        movie = movieManager.searchForSpecificMovie("Marvel's Thor: Ragnarok", _3D);
        movieListings.add(new MovieListing(cineplex, movie, cinema, start, end));

        cineplexes.add(cineplex);
        
        cineplexManager.exportData();
        
        /* create new User Population */
        
        UserManager userManager = new UserManager(importController);
        
        ArrayList<Admin> admins = userManager.getAdmins();
        Admin admin = new Admin("Admin1", "123", 1);
        admins.add(admin);
        admin = new Admin("Admin2", "456", 2);
        admins.add(admin);
        admin = new Admin("Admin3", "789", 3);
        admins.add(admin);
        
        ArrayList<Moviegoer> moviegoers = userManager.getMoviegoers();
        Moviegoer moviegoer = new Moviegoer("apple", "123", 7, "Jonathan", 123456, "apple@ntu.edu.sg");
        moviegoers.add(moviegoer);
        moviegoer = new Moviegoer("banana", "456", 21, "Elliot", 123456, "banana@ntu.edu.sg");
        moviegoers.add(moviegoer);
        moviegoer = new Moviegoer("cucumber", "789", 7, "Einstein", 123456, "cucumber@ntu.edu.sg");
        moviegoers.add(moviegoer);
        
        userManager.exportData();
    }
}
