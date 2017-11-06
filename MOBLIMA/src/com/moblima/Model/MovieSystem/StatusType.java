package com.moblima.Model.MovieSystem;

public enum StatusType {
    COMING_SOON("COMING SOON"), PREVIEW("PREVIEW"), NOW_SHOWING("NOW SHOWING");

    private final String type;

    private StatusType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
