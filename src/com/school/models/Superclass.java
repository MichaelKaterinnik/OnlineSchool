package com.school.models;

public class Superclass {
    private static int counter = 0;
    private int id;

    public Superclass() {
        counter++;
        this.id = counter;
    }

    public static int getCounter() {
        return counter;
    }
    public int getId() {
        return id;
    }

}
