package com.school.models;

public class Course extends Superclass {
    private static int counter = 0;
    private int id;
    private String courseName;
    private Person teacher;
    private Person student;
    private Lecture lecture;

    // constructors:
    public Course(String courseName)    {
        this.courseName = courseName;
        ++counter;
        this.id = counter;
    }
    public Course()    {
        ++counter;
        this.id = counter;
    }

    //getters & setters:
    public static int getCounter() { return counter; }
    public int getID()  { return id; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getCourseName() { return courseName; }
    public Lecture getLecture() {
        return lecture;
    }
    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
    public Person getTeacher() {
        return teacher;
    }
    public void setTeacher(Person teacher) {
        this.teacher = teacher;    }

    public Person getStudent() {
        return student;
    }
    public void setStudent(Person student) {
        this.student = student;
    }
}
