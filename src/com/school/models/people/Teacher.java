package com.school.models.people;

import com.school.models.Superclass;

public class Teacher extends Superclass {
    private static int counter = 0;
    private int id;
    private String teacherFirstName;
    private String teacherSecondName;

    // constructors:
    public Teacher(String firstName, String secondName) {
        this.teacherFirstName = firstName;
        this.teacherSecondName = secondName;
        ++counter;
        this.id = counter;
    }

    public Teacher(String secondName) {
        this.teacherSecondName = secondName;
        ++counter;
        this.id = counter;
    }

    public Teacher()    {
        ++counter;
        this.id = counter;
    }

    // getters & setters:
    public static int getCounter() { return counter; }

    public int getId()  { return id; }

    public void setTeacherFirstName(String firstName)   { this.teacherFirstName = firstName; }
    public String getTeacherFirstName() { return teacherFirstName; }

    public void setTeacherSecondName(String teacherSecondName) { this.teacherSecondName = teacherSecondName; }
    public String getTeacherSecondName()    { return teacherSecondName; }

}
