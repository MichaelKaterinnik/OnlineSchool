package com.school.models.people;

public class Student {
    public static int counter = 0;
    private static int id;
    String studentFirstName;
    String studentSecondName;

    public Student(String firstName, String secondName)    {
        this.studentFirstName = firstName;
        this.studentSecondName = secondName;
        counter++;
    }

    public Student(String secondName)    {
        this.studentSecondName = secondName;
        counter++;
    }

    public Student()    {
        counter++;
    }

}
