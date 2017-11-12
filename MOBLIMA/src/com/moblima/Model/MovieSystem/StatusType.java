package com.moblima.Model.MovieSystem;

/**
 * This enum represents the status type of a movie in the movie system.
 */
public enum StatusType {
    /**
     * COMING SOON
     */
    COMING_SOON("COMING SOON"),
    /**
     * PREVIEW
     */
    PREVIEW("PREVIEW"),
    /**
     * NOW SHOWING
     */
    NOW_SHOWING("NOW SHOWING"),
    /**
     * END OF SHOWING
     */
    END_OF_SHOWING("END OF SHOWING");

    /**
     * The name of the enum.
     */
    private final String type;

    /**
     * The constructor of the status type.
     * @param type The name of the enum.
     */
    private StatusType(String type) {
        this.type = type;
    }

    /**
     * The toString of the status type.
     * @return The toString of the status type.
     */
    public String toString() {
        return type;
    }
}
