package com.school.models.studytools;

import com.school.models.people.Student;
import com.school.models.people.Teacher;

public class Course {
    private static int counter = 0;
    private int id = counter;
    private String courseName;
    Teacher teacher;
    Student student;
    Lecture lecture;


    // constructors:
    public Course(String courseName)    {
        this.courseName = courseName;
        counter++;
    }
    public Course()    {
        counter++;
    }

    //getters & setters:
    public static int getCounter() { return counter; }

    public void setID(int id)   {
        this.id = id;
    }
    public int getID()  { return id; }

    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getCourseName() { return courseName; }
}
