package com.example.whattoeat.model;

/**
 * Created by Promlert on 3/9/2016.
 */
public class Food {

    public final String name;
    public final int picture;

    // constructor
    public Food(String name, int picture) {
        this.name = name;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return name;
    }
}
