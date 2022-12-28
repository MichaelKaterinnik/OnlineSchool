package com.school.models.studytools.services;

import com.school.models.SuperRepo;
import com.school.models.studytools.Course;

public class CourseRepo extends SuperRepo {
    private int index = 0;
    private int capacity = 10;
    private Course[] coursesRepository = new Course[capacity];

    private CourseRepo() {
    }

    private static class CourseRepoHolder    {
        public static final CourseRepo COURSE_REPO_INSTANCE = new CourseRepo();
    }

    // methods:
    public static CourseRepo getInstance() {
        return CourseRepoHolder.COURSE_REPO_INSTANCE;
    }

    public static Course[] getAll() {
        return CourseRepo.getInstance().coursesRepository;
    }

    public void add(Course newCourse) {
        if (index == capacity) {
            grow();
        }
        coursesRepository[index] = newCourse;
        index++;
    }

    public Course getById(int id)    {
        for (Course course : coursesRepository) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public void deleteById(int id)   {
        int pic = 0;
        for (int i = 0; i < coursesRepository.length; i++)    {
            if (coursesRepository[i] != null && coursesRepository[i].getId() == id)   {
                coursesRepository[i] = null;
            }
            pic = i;
        }
        if (pic < coursesRepository.length - 1) {
            while (pic < coursesRepository.length - 1) {
                coursesRepository[pic] = coursesRepository[pic + 1];
                pic++;
            }
            coursesRepository[coursesRepository.length - 1] = null;
        }
        CourseRepo.getInstance().index--;
    }

    private void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Course[] newCoursesRepository = new Course[capacity];
        System.arraycopy(coursesRepository, 0, newCoursesRepository, 0, coursesRepository.length);
        coursesRepository = newCoursesRepository;
    }
}
