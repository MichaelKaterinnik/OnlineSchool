package com.school.services;

import com.school.models.Course;
import com.school.repositories.CourseRepo;

import java.util.Arrays;
import java.util.Scanner;

public class CourseService {


    public Course createCourse()    {
        return new Course();
    }

    public Course createCourse(String courseName) {
        return new Course(courseName);
    }

    public static void createCourseByTerminal() {
        Scanner console = new Scanner(System.in);
        CourseService courseService = new CourseService();
        Course newCourse = courseService.createCourse();
        System.out.println("Введіть назву курсу:");
        while (true) {
            if (console.hasNext("[а-яА-Я0-1]+")) {
                newCourse.setCourseName(console.nextLine());
                break;
            } else {
                System.out.println("Введіть назву курсу українською мовою:");
            }
        }
        CourseRepo.getInstance().add(newCourse);

        console.close();
    }

    public static void showCourses() {
        Course[] result = Arrays.copyOf(CourseRepo.getAll(), CourseRepo.getAll().length);
        for (Course course : result) {
            System.out.println("ID наявного курсу: " + course.getID());
        }
    }
}
