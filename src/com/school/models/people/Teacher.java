package com.school.models.people;

public class Teacher {
    private static int counter = 0;
    private int id;
    private String teacherFirstName;
    private String teacherSecondName;


    // constructors:
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


    // getters & setters:
    public int getCounter() { return counter; }

    public void setId(int id)   { this.id = id; }
    public int getId()  { return id; }

    public void setTeacherFirstName(String firstName)   { this.teacherFirstName = firstName; }
    public String getTeacherFirstName() { return teacherFirstName; }

    public void setTeacherSecondName(String teacherSecondName) { this.teacherSecondName = teacherSecondName; }
    public String getTeacherSecondName()    { return teacherSecondName; }

}
