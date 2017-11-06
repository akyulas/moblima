package com.moblima.Model.MovieSystem;

public enum MovieType {
    _3D("3D"), BlockBuster("BlockBuster");

    private final String name;

    private MovieType(String type) {
        name = type;
    }

    public String toString() {
        return name;
    }
}
