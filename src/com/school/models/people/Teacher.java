package com.school.models.people;

public class Teacher {
    public static int counter = 0;
    private static int id;
    String teacherFirstName;
    String teacherSecondName;

    public Teacher(String firstName, String secondName)    {
        this.teacherFirstName = firstName;
        this.teacherSecondName = secondName;
        counter++;
    }

    public Teacher(String secondName)    {
        this.teacherSecondName = secondName;
        counter++;
    }

    public Teacher()    {
        counter++;
    }

}
