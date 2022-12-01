package com.school.models.people.services;

import com.school.models.people.Student;

public class StudentService {

    public Student createStudent(String firstName, String secondName)  {
        return new Student(firstName, secondName);
    }
    public Student createStudent()  {
        return new Student();
    }


}
