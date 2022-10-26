package com.school.models;

import com.school.models.people.Student;
import com.school.models.people.Teacher;
import com.school.models.studytools.Lecture;

public class Course {
    static int counter = 0;
    private static int id;
    int courseNumber;
    Teacher teacher;
    Student student;
    Lecture lecture;

    Course(int courseNumber)    {
        this.courseNumber = courseNumber;
        counter++;
    }

    Course()    {
        counter++;
    }

}
