package com.moblima.Control;

import com.moblima.MovieSystem.*;

import java.util.ArrayList;

import static com.moblima.MovieSystem.MovieRating.NC16;
import static com.moblima.MovieSystem.MovieRating.PG13;
import static com.moblima.MovieSystem.MovieType.BlockBuster;
import static com.moblima.MovieSystem.StatusType.COMING_SOON;
import static com.moblima.MovieSystem.StatusType.NOW_SHOWING;

public class Populate {

    public Populate() {

        /* create new movie population */

        MovieManager movieManager = new MovieManager();
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

        movie = new Movie("Flatliners", COMING_SOON, "Five medical students embark on a daring and dangerous experiment to gain insight into the mystery of what lies beyond the confines of life. The bold adventure begins when they trigger near-death experiences by stopping their hearts for short periods of time. As their trials become more perilous, each must confront the sins from their past while facing the paranormal consequences of journeying to the other side.",
                "Joel Schumacher", BlockBuster, PG13, casts, reviews);

        movies.add(movie);
        
        /* create new cineplex population */

        CineplexManager cineplexManager = new CineplexManager();

    }

}
