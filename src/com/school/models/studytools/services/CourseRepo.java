package com.school.models.studytools.services;

import com.school.models.studytools.Course;

public class CourseRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Course[] coursesRepository = new Course[capacity];


    public static void saveCourse(Course newCourse) {
        if (size == capacity) {
            grow();
        }
        coursesRepository[size] = newCourse;
        size++;
    }

    private static void grow() {
        capacity = (int) (capacity * 3) / 2 + 1;
        Course[] newCoursesRepository = new Course[capacity];
        for (int i = 0; i < coursesRepository.length; i++) {
            newCoursesRepository[i] = coursesRepository[i];
        }
        coursesRepository = newCoursesRepository;
    }
}
