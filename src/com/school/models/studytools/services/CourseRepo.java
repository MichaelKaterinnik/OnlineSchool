package com.school.models.studytools.services;

import com.school.models.SuperRepo;
import com.school.models.studytools.Course;

public class CourseRepo extends SuperRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Course[] coursesRepository = new Course[capacity];


    public static Course[] getCoursesRepository() {
        return coursesRepository;
    }

    public static void add(Course newCourse) {
        if (size == capacity) {
            grow();
        }
        coursesRepository[size] = newCourse;
        size++;
    }

    public static Course getById(int id)    {
        for (Course course : coursesRepository) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public static void deleteById(int id)   {
        for (int i = 0; i < coursesRepository.length; i++)    {
            if (coursesRepository[i] != null && coursesRepository[i].getId() == id)   {
                coursesRepository[i] = null;
            }
        }
        int k = 0;
        for (int i = 0; i < coursesRepository.length; i++) {
            if (coursesRepository[i] == null) {
                k = i;
                while (k < coursesRepository.length - 1) {
                    coursesRepository[k] = coursesRepository[k + 1];
                    k++;
                }
            }
        }
        size--;
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
