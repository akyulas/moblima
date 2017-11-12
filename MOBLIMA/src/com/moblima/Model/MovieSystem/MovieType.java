package com.moblima.Model.MovieSystem;

/**
 * This enum represents the movie type of a movie in the movie system.
 */
public enum MovieType {
    /**
     * 3D
     */
    _3D("3D"),
    /**
     * BlockBuster
     */
    BlockBuster("BlockBuster");

    /**
     * The name of the enum.
     */
    private final String name;

    /**
     * The constructor of the movie type.
     * @param type The name of the enum.
     */
    private MovieType(String type) {
        name = type;
    }

    /**
     * The toString of the movie type.
     * @return The toString of the movie type.
     */
    public String toString() {
        return name;
    }
}
