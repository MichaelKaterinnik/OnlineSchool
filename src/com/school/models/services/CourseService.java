package com.school.models.services;

import com.school.models.Course;
import com.school.models.repositories.CourseRepo;

import java.util.Arrays;
import java.util.Scanner;

public class CourseService {


    public Course createCourse()    {
        return new Course();
    }

    public Course createCourse(String courseName) {
        return new Course(courseName);
    }

    public void createCourseByTerminal() {
        Scanner console = new Scanner(System.in);
        CourseService courseService = new CourseService();
        Course newCourse = courseService.createCourse();
        CourseRepo.getInstance().add(newCourse);
    }

    public static void showCourses() {
        Course[] result = Arrays.copyOf(CourseRepo.getAll(), CourseRepo.getAll().length);
        for (Course course : result) {
            System.out.println("ID наявного курсу: " + course.getID());
        }
    }
}
