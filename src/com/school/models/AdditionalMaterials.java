package com.school.models;

public class AdditionalMaterials extends Superclass {
    private static int counter = 0;
    private int id;
    private String name;
    private int lectureID;

    // constructors:
    public AdditionalMaterials()   {
        ++counter;
        this.id = counter;
    }

    // getters & setters:
    public static int getCounter() { return counter; }
    public void setId(int id)   { this.id = id; }
    public int getId() {
        return id;
    }
    public void setName(String topic) {
        this.name = topic;
    }
    public String getName() {
        return name;
    }
    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }
    public int getLectureID() {
        return lectureID;
    }
}
