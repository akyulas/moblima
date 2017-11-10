package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cinema implements Serializable{

    private String code;
    private ClassType classType;
    private ArrayList<Timetable> timetables;
    
    public Cinema(String code, ClassType classType) {
    	this.code = code;
    	this.classType = classType;
    	this.timetables = new ArrayList<Timetable>();
    }

    public String getCode() {
        return code;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setId(String code) {
        this.code = code;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public boolean checkIfOccupied(LocalDateTime startTime, LocalDateTime endTime) {
        for (Timetable timetable: timetables) {
            if (timetable.timingClash(startTime, endTime)) {
                return true;
            }
        }
        return false;
    }

    public void addTimetable(Timetable timetable) {
        timetables.add(timetable);
    }
    
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
