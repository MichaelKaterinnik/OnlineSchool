package com.school.models.studytools.services;

import com.school.models.studytools.Course;

import java.util.Arrays;
import java.util.Scanner;

public class CourseService {
    private static final String ENTER_COURSE_ID = "Введіть ID створюваного курсу";
    private static final String ENTER_COURSE_NUMBER_EXCEPTION = "Введіть номер ID курсу, будь-ласка";


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
        System.out.println(ENTER_COURSE_ID);
        while (true) {
            if (console.hasNextInt()) {
                newCourse.setID(console.nextInt());
                System.out.println("Ви присвоїли створеному курсу ID №" + newCourse.getID());
                break;
            } else {
                System.out.println(ENTER_COURSE_NUMBER_EXCEPTION);
                continue;
            }
        }
        CourseRepo.add(newCourse);
    }

    public static void showCourses() {
        Course[] result = Arrays.copyOf(CourseRepo.getCoursesRepository(), CourseRepo.getCoursesRepository().length);
        for (Course course : result) {
            System.out.println("ID наявного курсу: " + course.getID());
        }
    }
}
