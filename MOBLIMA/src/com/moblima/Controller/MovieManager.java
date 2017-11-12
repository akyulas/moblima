package com.moblima.Controller;

import com.moblima.Model.MovieSystem.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * This is the movie manager that stores the movies and it is used to control
 * the movies processes.
 */
public class MovieManager implements Serializable{

	/**
	 * The movies inside the movie pool that can be used for showing purposes.
	 */
    private ArrayList<Movie> movies;

	/**
	 * The movies inside the history that is used as a record of movies that has been listed
	 * in the past.
	 */
	private ArrayList<Movie> allMovies;

	/**
	 * Construction of the movie manager.
	 */
    public MovieManager() {
        movies = new ArrayList<Movie>();
        allMovies = new ArrayList<Movie>();
    }

	/**
	 * Set the movies inside the system with the given movies.
	 * @param movies The given movies to be used inside the system.
	 */
	public void setMovie(ArrayList<Movie> movies) {
    	this.movies = movies;
    }

	/**
	 * Get the movies inside the system.
	 * @return The movies inside the system.
	 */
	public ArrayList<Movie> getMovies() {
        return movies;
    }

	/**
	 * Get the movie history inside the system.
	 * @return The movie history inside the system.
	 */
	public ArrayList<Movie> getAllMovies() {
    	return allMovies;
	}

	/**
	 * Search for a specific movie with the given name and movie type.
	 * @param name The name of the movie.
	 * @param type The movie type of the movie.
	 * @return The movie with the specific name and the movie type.
	 */
    public Movie searchForSpecificMovie(String name, MovieType type) {
    	for (Movie movie: movies) {
    		if (movie.getName().equals(name) && movie.getMovieType().equals(type)) {
    			return movie;
    		}
    	}
    	return null;
    }

	/**
	 * Search for movies with similar given movie name.
	 * @param movieSearchString The movie name given by the user.
	 * @return The movies with name similar to the one given by the user.
	 */
	public ArrayList<Movie> getMatchingMovies(String movieSearchString) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        String tempString = movieSearchString.toLowerCase();
        for (Movie movie: movies) {
            if (movie.getName().toLowerCase().contains(tempString))
                tempList.add(movie);
        }
        return tempList;
    }

	/**
	 *Search for movies inside the movie history with similar given movie name.
	 * @param movieSearchString The movie name given by the user.
	 * @return The movies inside the movie history with name similar to the one given by the user.
	 */
	public ArrayList<Movie> getMatchingMoviesFromHistory(String movieSearchString) {
		ArrayList<Movie> tempList = new ArrayList<Movie>();
		String tempString = movieSearchString.toLowerCase();
		for (Movie movie: allMovies) {
			if (movie.getName().toLowerCase().contains(tempString))
				tempList.add(movie);
		}
		return tempList;
	}

	/**
	 * This is used to sort the movies in descending order of ticket sales.
	 * @return The top 5 movies sorted by ticket sales.
	 */
	public ArrayList<Movie> sortByTicketSales() {
    	ArrayList<Movie> tempList = new ArrayList<Movie>();
    	Comparator<Movie> ticketOrder = new Comparator<Movie>() {
        	public int compare(Movie m1, Movie m2) {
        		int cmp = m2.getNumberOfTicketsSold() - m1.getNumberOfTicketsSold();
        		if (cmp == 0) {
        			cmp = Double.compare(m2.getRating(), m1.getRating());
        		}
        		return cmp;
        	}
        };
    	Collections.sort(movies, ticketOrder);
    	ticketOrder = null;
    	if (movies.size() < 5) {
    		return movies;
    	}
    	for (int i = 0; i < 5; i++) {
    		tempList.add(movies.get(i));
    	}
    	return tempList;
    }

	/**
	 * This is used to sort the movies in descending order of ratings.
	 * @return The top 5 movies sorted by ratings.
	 */
    public ArrayList<Movie> sortByRatings() {
    	ArrayList<Movie> tempList = new ArrayList<Movie>();
    	Comparator<Movie> ratingOrder = new Comparator<Movie>() {
        	public int compare(Movie m1, Movie m2) {
        		int cmp = Double.compare(m2.getRating(), m1.getRating());
        		if (cmp == 0) {
        			cmp = m2.getNumberOfTicketsSold() - m1.getNumberOfTicketsSold();
        		}
        		return cmp;
        	}
        };
    	Collections.sort(movies, ratingOrder);
    	ratingOrder = null;
    	if (movies.size() < 5) {
    		return movies;
    	}
    	for (int i = 0; i < 5; i++) {
    		tempList.add(movies.get(i));
    	}
    	return tempList;
    }

	/**
	 * This is used to add movie into the movie pool and the history.
	 * @param movie Movie to be added.
	 */
	public void addMovies(Movie movie) {
    	allMovies.add(movie);
    	movies.add(movie);
	}

	/**
	 * This is used to remove movie from the movie pool.
	 * @param movie Movie to be removed from the movie pool.
	 */
	public void delistMovies(Movie movie) {
		movies.remove(movie);
		movie.removeByChangingStatus();
	}

	/**
	 * This is used to remove movie from the movie pool and history.
	 * @param movie Movie to be removed from the movie pool and history.
	 */
	public void removeMovies(Movie movie) {
    	if (movies.contains(movie))
    		movies.remove(movie);
    	allMovies.remove(movie);
	}

	/**
	 * This is used to remove movies that are inside the movie pool that have passed the end of showing date of have
	 * the status of end of showing.
	 */
	public void removeOldMovies() {
		LocalDate currentDate = LocalDate.now();
		Iterator<Movie> iterator = movies.iterator();
		while (iterator.hasNext()) {
			Movie movie = iterator.next();
			if (movie.getEndOfShowingDate().isBefore(currentDate) || movie.getStatus().equals(StatusType.END_OF_SHOWING)) {
				movie.setStatus(StatusType.END_OF_SHOWING);
				iterator.remove();
			}
		}
	}


}
