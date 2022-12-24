package com.school.models.studytools;

import com.school.models.people.Student;
import com.school.models.people.Teacher;

public class Course {
    private static int counter = 0;
    private int id;
    private String courseName;
    private Teacher teacher;
    private Student student;
    private Lecture lecture;


    // constructors:
    public Course(String courseName)    {
        this.courseName = courseName;
        counter++;
    }
    public Course()    {
        ++counter;
        this.id = counter;
    }

    //getters & setters:
    public static int getCounter() { return counter; }

    public void setID(int id)   {
        this.id = id;
    }
    public int getID()  { return id; }

    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getCourseName() { return courseName; }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
