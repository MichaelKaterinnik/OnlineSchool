package com.school.models.people.services;

import com.school.models.people.Teacher;

public class TeacherService {

    public Teacher createTeacher(String firstName, String secondName)  {
        return new Teacher(firstName, secondName);
    }
    public Teacher createTeacher()  {
        return new Teacher();
    }

}
