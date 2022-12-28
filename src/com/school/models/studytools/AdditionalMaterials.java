package com.school.models.studytools;

import com.school.models.Superclass;

public class AdditionalMaterials extends Superclass {
    private static int counter = 0;
    private int id;
    private String topic;
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
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getTopic() {
        return topic;
    }
    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }
    public int getLectureID() {
        return lectureID;
    }
}
