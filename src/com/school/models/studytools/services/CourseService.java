package com.school.models.studytools.services;

import com.school.models.studytools.Course;
import com.school.models.studytools.Homework;
import com.school.models.studytools.Lecture;

import java.util.Scanner;

public class CourseService {
    private static final String ENTER_COURSE_ID = "Введіть ID створюваного курсу";
    private static final String ENTER_COURSE_NUMBER_EXCEPTION = "Введіть номер ID курсу, будь-ласка";


    public Course createCourse()    {
        return new Course();
    }
    public Course createCourse(int id) {
        return new Course(id);
    }
    public Course createCourse(String courseName, int courseNumber) {
        return new Course(courseName, courseNumber);
    }
    public Course createCourse(int courseNumber, String courseName) {
        return new Course(courseName, courseNumber);
    }


        public Course createCourseByTerminal()    {
        Scanner console = new Scanner(System.in);
        CourseService courseService = new CourseService();
        Course newCourse = courseService.createCourse();
        System.out.println(ENTER_COURSE_ID);
        boolean st = true;
        int counter = 0;
        while (st) {
            if (console.hasNextInt())  {
                newCourse.setID(console.nextInt());
                System.out.println("Ви присвоїли створеному курсу ID №" + newCourse.getID());
                st = false;
            } else {
                System.out.println(ENTER_COURSE_NUMBER_EXCEPTION);
                continue;
            }
        }
        return newCourse;
    }

}
