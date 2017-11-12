package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This class represents the timetable in the movie system.
 */
public class Timetable implements Serializable{

    /**
     * The starting time period of the timetable
     */
    private LocalDateTime startTiming;
    /**
     * The ending time period of the timetable
     */
    private LocalDateTime endTiming;
    /**
     * The boolean is used to keep track if a time period is being used.
     */
    boolean isOccupied;

    /**
     * Constructor of the timetable class
     * @param startTiming The starting time period of the timetable
     * @param endTiming The ending time period of the timetable
     */
    public Timetable(LocalDateTime startTiming, LocalDateTime endTiming) {
        this.startTiming = startTiming;
        this.endTiming = endTiming;
        this.isOccupied = true;
    }

    /**
     * Give the caller the starting time period of the timetable.
     * @return The starting time period of the timetable.
     */
    public LocalDateTime getStartTiming() {
        return startTiming;
    }

    /**
     * Give the caller the ending time period of the timetable.
     * @return The ending time period of the timetable.
     */
    public LocalDateTime getEndTiming() {
        return endTiming;
    }


    /**
     * This is used to find out if a given starting time period and the ending time period in the parameters
     * clash with the timetable.
     * @param startTiming The starting time period
     * @param endTiming The ending time period
     * @return Returns true if a given starting time period and the ending time period in the parameters
     * clash with the timetable. Otherwise, false will be returned.
     */
    public boolean timingClash(LocalDateTime startTiming, LocalDateTime endTiming) {
        if (endTiming.isBefore(this.startTiming) || endTiming.isEqual(this.startTiming) ||
                startTiming.isAfter(this.endTiming) || startTiming.isEqual(this.endTiming)) {
            return false;
        }
        return true;
    }

    /**
     * The toString of the timetable.
     * @return The toString of the timetable.
     */
    public String toString() {
    	return "startTiming: " + startTiming + "endTiming: " + endTiming;
    }

}
