package com.school.models.studytools;

public class Lecture {
    private static int counter = 0;
    private int id;
    public int courseID;
    private String lectureTopic;
    Homework homework;
    AdditionalMaterials addMaterial;


    //constructors:
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

    public void setCourseID(int courseID) { this.courseID = courseID; }
    public int getCourseID() { return courseID; }

    public void setLectureTopic(String lectureTopic) { this.lectureTopic = lectureTopic; }
    public String getLectureTopic() { return lectureTopic; }


}
