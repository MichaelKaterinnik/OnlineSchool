package com.school.models.studytools;

import com.school.models.people.Student;
import com.school.models.people.Teacher;

public class Course {
    static int counter = 0;
    private int id;
    public int courseNumber;
    public String courseName;
    Teacher teacher;
    Student student;
    Lecture lecture;

    public Course(int courseNumber)    {
        this.courseNumber = courseNumber;
        counter++;
    }

    public Course(String courseName)    {
        this.courseName = courseName;
        counter++;
    }

    public Course(String courseName, int courseNumber)    {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        counter++;
    }

    public Course(int courseNumber, String courseName)    {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        counter++;
    }

    public Course()    {
        counter++;
    }

    public void setID(int id)   {
        this.id = id;
    }

    public int getID()  { return id; }

}
