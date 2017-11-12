package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This class represents the cinema in the movie system.
 */
public class Cinema implements Serializable{

    /**
     * The code of the cinema.
     */
    private String code;

    /**
     * The class type of the cinema.
     */
    private ClassType classType;

    /**
     * The timetables inside a cinema.
     */
    private ArrayList<Timetable> timetables;

    /**
     * The construction of the cinema class.
     * @param code The code of the cinema.
     * @param classType The class type of the cinema.
     */
    public Cinema(String code, ClassType classType) {
    	this.code = code;
    	this.classType = classType;
    	this.timetables = new ArrayList<Timetable>();
    }

    /**
     * Give the code of the cinema to the caller.
     * @return The code of the cinema.
     */
    public String getCode() {
        return code;
    }

    /**
     * Give the class type of the cinema to the caller.
     * @return The class type of the cinema.
     */
    public ClassType getClassType() {
        return classType;
    }

    /**
     * Check if the time period is occupied inside the cinema.
     * @param startTime The start time of the time period.
     * @param endTime The end time of the time period.
     * @return True if the time period is occupied. False otherwise.
     */
    public boolean checkIfOccupied(LocalDateTime startTime, LocalDateTime endTime) {
        for (Timetable timetable: timetables) {
            if (timetable.timingClash(startTime, endTime)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add a timetable to the cinema.
     * @param timetable The timetable to be added.
     */
    public void addTimetable(Timetable timetable) {
        timetables.add(timetable);
    }

    /**
     * Remove a timetable from the cinema.
     * @param startTime The start time of the time period.
     * @param endTime The end time of the time period.
     */
    public void removeTimetable(LocalDateTime startTime, LocalDateTime endTime) {
    	Timetable tempTimetable = null;
    	for (Timetable timetable: timetables) {
            if (timetable.getStartTiming().isEqual(startTime) && timetable.getEndTiming().isEqual(endTime)) {
            	tempTimetable = timetable;
            	break;
            }
        }
    	timetables.remove(tempTimetable);
    }

}
