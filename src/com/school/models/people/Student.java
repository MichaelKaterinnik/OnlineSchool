package com.school.models.people;

import com.school.models.Superclass;

public class Student extends Superclass {
    private static int counter = 0;
    private int id;
    private String studentFirstName;
    private String studentSecondName;


    // constructors:
    public Student(String firstName, String secondName)    {
        this.studentFirstName = firstName;
        this.studentSecondName = secondName;
        ++counter;
        this.id = counter;
    }
    public Student(String secondName)    {
        this.studentSecondName = secondName;
        ++counter;
        this.id = counter;
    }
    public Student()    {
        ++counter;
        this.id = counter;
    }


    //getters & setters:
    public static int getCounter() { return counter; }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setStudentFirstName(String studentFirstName) { this.studentFirstName = studentFirstName; }
    public String getStudentFirstName() { return studentFirstName; }

    public void setStudentSecondName(String studentSecondName) { this.studentSecondName = studentSecondName; }
    public String getStudentSecondName() { return studentSecondName; }



}
