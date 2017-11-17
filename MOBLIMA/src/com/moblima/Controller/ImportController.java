package com.moblima.Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.moblima.Model.MovieSystem.Cineplex;
import com.moblima.Model.MovieSystem.Movie;
import com.moblima.Model.MovieSystem.MovieListing;
/**
 * This is the import controller that imports data from the text files.
 */
public class ImportController {
	
	private AllTheManagers allTheManagers;

	private String allTheManagerFileString = "allTheManager.dat";
	/**
	 * This is used to import the data from the textfiles.
	 */
	public void importData() {
		allTheManagers = readSerializedObject(allTheManagerFileString);
	}

	/**
	 * This is used to export all the managers class.
	 */
	public void export() {
		writeSerializedObject(allTheManagerFileString, allTheManagers);
	}
	
	/**
	 * Return all the managers to the caller.
	 * @return All the Managers class
	 */
	public AllTheManagers getAllTheManagers() {
		return allTheManagers;
	}

	/**
	 * Set all the managers class to the one that is inside the parameter.
	 * @param allTheManagers All the managers class that will be used to set.
	 */
	public void setAllTheManagers(AllTheManagers allTheManagers) {
		this.allTheManagers = allTheManagers;
	}

	/**
	 * This is used to read the serialized file of the movie manager.
	 * @param filename The path to the movie manager text file.
	 * @return The all the managers class that is deserialized
	 */
	private AllTheManagers readSerializedObject(String filename) {
	        AllTheManagers pDetails = null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            pDetails = (AllTheManagers) in.readObject();
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
	 * @param allTheManager The all the manager class that will be exported.
	 */
	 private void writeSerializedObject(String filename, AllTheManagers allTheManager) {
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(allTheManager);
	            out.close();
	            //	System.out.println("Object Persisted");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 }

}
