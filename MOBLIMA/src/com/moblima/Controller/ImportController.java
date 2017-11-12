package com.moblima.Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * This is the import controller that imports data from the text files
 */
public class ImportController {

	/**
	 * This is the movie manager that stores the movies and it is used to control
	 * the movies processes.
	 */
	private  MovieManager movieManager;

	/**
	 * This is the cineplex manager that stores the cineplexes and it is used to control
	 * the cineplex processes.
	 */
	private  CineplexManager cineplexManager;

	/**
	 * This is the user manager that stores the users and it is used to control
	 * the user processes.
	 */
	private  UserManager userManager;

	/**
	 * This is the booking manager that stores the relevant stuff to the booking system and it is used to control
	 * the booking processes.
	 */
	private  BookingManager bookingManager;

	/**
	 * This is the string with the path to the textfile for the movie manager
	 */
	private String movieFileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/movieManager.dat";

	/**
	 * This is the string with the path to the textfile for the cineplex manager
	 */
	private String cineplexFileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/cineplexManager.dat";

	/**
	 * This is the string with the path to the textfile for the user manager
	 */
	private String userFileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/userManager.dat";

	/**
	 * This is the string with the path to the textfile for the booking manager
	 */
	private String bookingFileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/bookingManager.dat";

	/**
	 * This is used to import the data from the textfiles.
	 */
	public void importData() {
		movieManager = readSerializedMovieManager(movieFileString);
		cineplexManager = readSerializedCineplexManager(cineplexFileString);
		userManager = readSerializedUserManager(userFileString);
		bookingManager = readSerializedBookingManager(bookingFileString);
	}

	/**
	 * This is used to remove all the old data from the managers.
	 */
	public void removeOldData() {
		movieManager.removeOldMovies();
		cineplexManager.removeOldMovieListings();
		bookingManager.removeOldHolidayDates();
	}

	/**
	 * This is used to export to the textfiles when the application is ending.
	 */
	public void export() {
		writeSerializedMovieManager(movieFileString, movieManager);
		writeSerializedCineplexManager(cineplexFileString, cineplexManager);
		writeSerializedUserManager(userFileString, userManager);
		writeSerializedBookingManager(bookingFileString, bookingManager);
	}

	/**
	 * This is used to return the movie manager.
	 * @return The movie manager.
	 */
	public MovieManager getMovieManager() {
		return movieManager;
	}

	/**
	 * This is used to return the cineplex manager.
	 * @return The cineplex manager.
	 */
	public CineplexManager getCineplexManager() {
		return cineplexManager;
	}

	/**
	 * This is used to return the user manager.
	 * @return The user manager.
	 */
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * This is used to return the booking manager.
	 * @return The booking manager.
	 */
	public BookingManager getBookingManager() {
		return bookingManager;
	}

	/**
	 * This is used to set the movie manager during the population process.
	 * @param movieManager The movie manager that is created during the population process.
	 */
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}

	/**
	 * This is used to set the cineplex manager during the population process.
	 * @param cineplexManager The cineplex manager that is created during the population process.
	 */
	public void setCineplexManager(CineplexManager cineplexManager) {
		this.cineplexManager = cineplexManager;
	}

	/**
	 * This is used to set the user manager during the population process.
	 * @param userManager The user manager that is created during the population process.
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * This is used to set the booking manager during the population process.
	 * @param bookingManager The booking manager that is created during the populaton process.
	 */
	public void setBookingManager(BookingManager bookingManager) {
		this.bookingManager = bookingManager;
	}

	/**
	 * This is used to read the serialized file of the movie manager.
	 * @param filename The path to the movie manager text file.
	 * @return The movie manager that is deserialized
	 */
	private MovieManager readSerializedMovieManager(String filename) {
	        MovieManager pDetails = null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            pDetails = (MovieManager) in.readObject();
	            in.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        // print out the size
	        //System.out.println(" Details Size: " + pDetails.size());
	        //System.out.println();
	        return pDetails;
	}

	/**
	 * This is used to create the serialized file of the movie manager.
	 * @param filename The path to the movie manager text file.
	 * @param movieManager The movie manager that will be exported.
	 */
	 private void writeSerializedMovieManager(String filename, MovieManager movieManager) {
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(movieManager);
	            out.close();
	            //	System.out.println("Object Persisted");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 }

	/**
	 * This is used to read the serialized file of the cineplex manager.
	 * @param filename The path to the cineplex manager text file.
	 * @return The cineplex manager that is deserialized
	 */
	 private CineplexManager readSerializedCineplexManager(String filename) {
	        CineplexManager pDetails = null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            pDetails = (CineplexManager) in.readObject();
	            in.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        // print out the size
	        //System.out.println(" Details Size: " + pDetails.size());
	        //System.out.println();
	        return pDetails;
	}

	/**
	 * This is used to create the serialized file of the movie manager.
	 * @param filename The path to the cineplex manager text file.
	 * @param cineplexManager The cineplex manager that will be exported.
	 */
	 private void writeSerializedCineplexManager(String filename, CineplexManager cineplexManager) {
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(cineplexManager);
	            out.close();
	            //	System.out.println("Object Persisted");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 }

	/**
	 * This is used to read the serialized file of the user manager.
	 * @param filename The path to the user manager text file.
	 * @return The user manager that is deserialized.
	 */
	 private UserManager readSerializedUserManager(String filename) {
	        UserManager pDetails = null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            pDetails = (UserManager) in.readObject();
	            in.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        // print out the size
	        //System.out.println(" Details Size: " + pDetails.size());
	        //System.out.println();
	        return pDetails;
	}

	/**
	 * This is used to create the serialized file of the movie manager.
	 * @param filename The path to the user manager text file.
	 * @param userManager The user manager that will be exported.
	 */
	 private void writeSerializedUserManager(String filename, UserManager userManager) {
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(userManager);
	            out.close();
	            //	System.out.println("Object Persisted");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 }

	/**
	 * This is used to read the serialized file of the booking manager.
	 * @param filename The path to the booking manager text file.
	 * @return The booking manager that is deserialized.
	 */
	 private BookingManager readSerializedBookingManager(String filename) {
	        BookingManager pDetails = null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            pDetails = (BookingManager) in.readObject();
	            in.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        // print out the size
	        //System.out.println(" Details Size: " + pDetails.size());
	        //System.out.println();
	        return pDetails;
	}

	/**
	 * This is used to create the serialized file of the movie manager.
	 * @param filename The path to the booking manager text file.
	 * @param bookingManager The booking manager that will be exported.
	 */
	 private void writeSerializedBookingManager(String filename, BookingManager bookingManager) {
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(bookingManager);
	            out.close();
	            //	System.out.println("Object Persisted");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 }
	 
	 
}
