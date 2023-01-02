package com.school.models;

public class Lecture extends Superclass {
    private static int counter = 0;
    private int id;
    private int CourseID;
    private int PersonID;
    private String lectureTopic;
    private Person teacher;
    private Homework homework;
    private AdditionalMaterials addMaterial;


    //constructors:
    public Lecture(String topic) {
        this.lectureTopic = topic;
        ++counter;
        this.id = counter;
    }
    public Lecture(String topic, AdditionalMaterials addMaterial, Homework homework)   {
        this.homework = homework;
        this.addMaterial = addMaterial;
        this.lectureTopic = topic;
        ++counter;
        this.id = counter;
    }
    public Lecture(String topic, Homework homework, AdditionalMaterials addMaterial)   {
        this.homework = homework;
        this.addMaterial = addMaterial;
        this.lectureTopic = topic;
        ++counter;
        this.id = counter;
    }
    public Lecture(String topic, Homework homework)   {
        this.homework = homework;
        this.lectureTopic = topic;
        ++counter;
        this.id = counter;
    }
    public Lecture()   {
        ++counter;
        this.id = counter;
    }


    // getters & setters:
    public static int getCounter() { return counter; }
    public int getId() { return id; }
    public void setCourseID(int courseID) {
        this.CourseID = courseID;
    }
    public int getCourseID() {
        return CourseID;
    }
    public void setLectureTopic(String lectureTopic) { this.lectureTopic = lectureTopic; }
    public String getLectureTopic() { return lectureTopic; }
    public Homework getHomework() {
        return homework;
    }
    public void setHomework(Homework homework) {
        this.homework = homework;
    }
    public AdditionalMaterials getAddMaterial() {
        return addMaterial;
    }
    public void setAddMaterial(AdditionalMaterials addMaterial) {
        this.addMaterial = addMaterial;
    }
    public int getPersonID() {
        return PersonID;
    }
    public void setPersonID(int personID) {
        PersonID = personID;
    }
    public Person getTeacher() {
        return teacher;
    }
    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }
}
