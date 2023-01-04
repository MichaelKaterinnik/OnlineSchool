package com.school.models;

public class Person extends Superclass {
    private Role role;
    private static int counter = 0;
    private int id;
    private int courseID;
    private String personFirstName;
    private String personLastName;
    private String phone;
    private String email;


    // constructors:
    public Person(Role role, String firstName, String lastName)    {
        this.role = role;
        this.personFirstName = firstName;
        this.personLastName = lastName;
        ++counter;
        this.id = counter;
    }
    public Person(Role role, String lastName)    {
        this.personLastName = lastName;
        this.role = role;
        ++counter;
        this.id = counter;
    }
    public Person(String firstName, String lastName)    {
        this.personFirstName = firstName;
        this.personLastName = lastName;
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

    public void setPersonLastName(String personLastName) { this.personLastName = personLastName; }
    public String getPersonLastName() { return personLastName; }

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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
