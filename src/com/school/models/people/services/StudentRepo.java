package com.school.models.people.services;

import com.school.models.people.Student;
import com.school.models.people.Teacher;

public class StudentRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Student[] studentsRepository = new Student[capacity];


    public static Student[] getStudentsRepository() {
        return studentsRepository;
    }

    public static void saveStudent(Student newStudent) {
        if (size == capacity) {
            grow();
        }
        studentsRepository[size] = newStudent;
        size++;
    }

    private static void grow() {
        capacity = (int) (capacity * 3) / 2 + 1;
        Student[] newRepository = new Student[capacity];
        for (int i = 0; i < studentsRepository.length; i++) {
            newRepository[i] = studentsRepository[i];
        }
        studentsRepository = newRepository;
    }
}
