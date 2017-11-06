package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Timetable implements Serializable{

    private LocalDateTime startTiming;
    private LocalDateTime endTiming;
    boolean isOccupied;

    public Timetable(LocalDateTime startTiming, LocalDateTime endTiming) {
        this.startTiming = startTiming;
        this.endTiming = endTiming;
        this.isOccupied = true;
    }

    public LocalDateTime getStartTiming() {
        return startTiming;
    }

    public LocalDateTime getEndTiming() {
        return endTiming;
    }

    public void setStartTiming(LocalDateTime startTiming) {
        this.startTiming = startTiming;
    }

    public void setEndTiming(LocalDateTime endTiming) {
        this.endTiming = endTiming;
    }

    public boolean timingClash(Timetable timetable) {
        if (timetable.getEndTiming().isBefore(startTiming) || timetable.getEndTiming().isEqual(startTiming) ||
                timetable.getStartTiming().isAfter(endTiming) || timetable.getStartTiming().isEqual(endTiming)) {
            return false;
        }
        return true;
    }

    public boolean timingClash(LocalDateTime startTiming, LocalDateTime endTiming) {
        if (endTiming.isBefore(this.startTiming) || endTiming.isEqual(this.startTiming) ||
                startTiming.isAfter(this.endTiming) || startTiming.isEqual(this.endTiming)) {
            return false;
        }
        return true;
    }
    
    public String toString() {
    	return "startTiming: " + startTiming + "endTiming: " + endTiming;
    }

}
