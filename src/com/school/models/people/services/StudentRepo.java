package com.school.models.people.services;

import com.school.models.SuperRepo;
import com.school.models.people.Student;

public class StudentRepo extends SuperRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Student[] studentsRepository = new Student[capacity];


    public static Student[] getStudentsRepository() {
        return studentsRepository;
    }

    public static void add(Student newStudent) {
        if (size == capacity) {
            grow();
        }
        studentsRepository[size] = newStudent;
        size++;
    }

    public static Student getById(int id)    {
        for (Student student : studentsRepository) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public static void deleteById(int id)   {
        for (int i = 0; i < studentsRepository.length; i++)    {
            if (studentsRepository[i] != null && studentsRepository[i].getId() == id)   {
                studentsRepository[i] = null;
            }
        }
        int k = 0;
        for (int i = 0; i < studentsRepository.length; i++) {
            if (studentsRepository[i] == null) {
                k = i;
                while (k < studentsRepository.length - 1) {
                    studentsRepository[k] = studentsRepository[k + 1];
                    k++;
                }
            }
        }
        size--;
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
