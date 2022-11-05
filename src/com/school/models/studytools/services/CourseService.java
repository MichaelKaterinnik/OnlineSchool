package com.school.models.studytools.services;

import com.school.models.studytools.Course;

public class CourseService {

    public Course createCourse(int courseNumber)    {
        return new Course(courseNumber);
    }

    public Course createCourse(String courseName, int courseNumber)    {
        return new Course(courseName, courseNumber);
    }

    public Course createCourse(int courseNumber, String courseName)    {
        return new Course(courseName, courseNumber);
    }

}
