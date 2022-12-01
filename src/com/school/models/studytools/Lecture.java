package com.school.models.studytools;

public class Lecture {
    private static int counter = 0;
    private int id;
    private int CourseID;
    private String lectureTopic;
    Homework homework;
    AdditionalMaterials addMaterial;


    //constructors:
    public Lecture(int id) {
        this.id = id;
        counter++;
    }
    public Lecture(int id, String topic) {
        this.id = id;
        counter++;
    }
    public Lecture(String topic, int id) {
        this.id = id;
        this.lectureTopic = topic;
        counter++;
    }
    public Lecture(String topic) {
        this.lectureTopic = topic;
        counter++;
    }
    public Lecture(String topic, AdditionalMaterials addMaterial, Homework homework)   {
        this.homework = homework;
        this.addMaterial = addMaterial;
        this.lectureTopic = topic;
        counter++;
    }
    public Lecture(String topic, Homework homework, AdditionalMaterials addMaterial)   {
        this.homework = homework;
        this.addMaterial = addMaterial;
        this.lectureTopic = topic;
        counter++;
    }
    public Lecture(String topic, Homework homework)   {
        this.homework = homework;
        this.lectureTopic = topic;
        counter++;
    }
    public Lecture()   {
        counter++;
    }


    // getters & setters:
    public static int getCounter() { return counter; }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }
    public int getCourseID() {
        return CourseID;
    }

    public void setLectureTopic(String lectureTopic) { this.lectureTopic = lectureTopic; }
    public String getLectureTopic() { return lectureTopic; }


}
