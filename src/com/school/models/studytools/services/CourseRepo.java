package com.school.models.studytools.services;

import com.school.models.SuperRepo;
import com.school.models.studytools.Course;

public class CourseRepo extends SuperRepo {
    private static int index = 0;
    private static int capacity = 10;
    private static Course[] coursesRepository = new Course[capacity];

    public static Course[] getCoursesRepository() {
        return coursesRepository;
    }

    public static void add(Course newCourse) {
        if (index == capacity) {
            grow();
        }
        coursesRepository[index] = newCourse;
        index++;
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
        int index = 0;
        for (int i = 0; i < coursesRepository.length; i++)    {
            if (coursesRepository[i] != null && coursesRepository[i].getId() == id)   {
                coursesRepository[i] = null;
            }
            index = i;
        }
        if (index < coursesRepository.length - 1) {
            while (index < coursesRepository.length - 1) {
                coursesRepository[index] = coursesRepository[index + 1];
                index++;
            }
            coursesRepository[coursesRepository.length - 1] = null;
        }
        CourseRepo.index--;
    }

    private static void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Course[] newCoursesRepository = new Course[capacity];
        System.arraycopy(coursesRepository, 0, newCoursesRepository, 0, coursesRepository.length);
        coursesRepository = newCoursesRepository;
    }
}
