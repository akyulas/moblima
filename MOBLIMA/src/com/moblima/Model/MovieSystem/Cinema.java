package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cinema implements Serializable{

    private String code;
    private ArrayList<Seat> seats;
    private ClassType classType;
    private ArrayList<Timetable> timetables;

    public Cinema(String code, ClassType classType) {
        this.code = code;
        seats = new ArrayList<Seat>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                seats.add(new Seat(i, j));
            }
        }
        this.classType = classType;
        timetables = new ArrayList<Timetable>();
    }

    public String getCode() {
        return code;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setId(String code) {
        this.code = code;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
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

}
