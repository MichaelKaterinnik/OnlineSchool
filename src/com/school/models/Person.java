package com.school.models;

public class Person extends Superclass {
    private Role role;
    private static int counter = 0;
    private int id;
    private int courseID;
    private String personFirstName;
    private String personSecondName;


    // constructors:
    public Person(Role role, String firstName, String secondName)    {
        this.role = role;
        this.personFirstName = firstName;
        this.personSecondName = secondName;
        ++counter;
        this.id = counter;
    }
    public Person(Role role, String secondName)    {
        this.personSecondName = secondName;
        this.role = role;
        ++counter;
        this.id = counter;
    }
    public Person(String secondName)    {
        this.personSecondName = secondName;
        ++counter;
        this.id = counter;
    }
    public Person()    {
        ++counter;
        this.id = counter;
    }


    //getters & setters:
    public static int getCounter() { return counter; }

    public int getId() { return id; }

    public void setPersonFirstName(String personFirstName) { this.personFirstName = personFirstName; }
    public String getPersonFirstName() { return personFirstName; }

    public void setPersonSecondName(String personSecondName) { this.personSecondName = personSecondName; }
    public String getPersonSecondName() { return personSecondName; }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public int getCourseID() {
        return courseID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
