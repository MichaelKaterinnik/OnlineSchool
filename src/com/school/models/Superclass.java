package com.school.models;

public class Superclass {
    private static int counter = 0;
    private int id = counter;

    public Superclass() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
    public static void setCounter(int counter) {
        Superclass.counter = counter;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
