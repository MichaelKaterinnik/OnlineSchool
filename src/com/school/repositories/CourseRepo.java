package com.school.repositories;

import com.school.models.Course;
import com.school.models.Lecture;
import com.school.models.Person;

public class CourseRepo extends SuperRepo {
    private static Storage<Course> storage = new Storage<>();


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
        return storage.getAll();
    }

    public void addS(Course course) {
        storage.add(course);
    }

    public Course getById(int id) {
        return storage.get(id);
    }

    public void deleteById(int id) {
        storage.remove(id);
    }
}
