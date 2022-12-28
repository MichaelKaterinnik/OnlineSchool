package com.school.models.people.services;

import com.school.models.SuperRepo;
import com.school.models.people.Student;

public class StudentRepo extends SuperRepo {
    private static int index = 0;
    private static int capacity = 10;
    private static Student[] studentsRepository = new Student[capacity];


    public static Student[] getStudentsRepository() {
        return studentsRepository;
    }

    public static void add(Student newStudent) {
        if (index == capacity) {
            grow();
        }
        studentsRepository[index] = newStudent;
        index++;
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
        int index = 0;
        for (int i = 0; i < studentsRepository.length; i++)    {
            if (studentsRepository[i] != null && studentsRepository[i].getId() == id)   {
                studentsRepository[i] = null;
            }
            index = i;
        }
        if (index < studentsRepository.length - 1) {
            while (index < studentsRepository.length - 1) {
                studentsRepository[index] = studentsRepository[index + 1];
                index++;
            }
            studentsRepository[studentsRepository.length - 1] = null;
        }
        StudentRepo.index--;
    }

    private static void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Student[] newRepository = new Student[capacity];
        System.arraycopy(studentsRepository, 0, newRepository, 0, studentsRepository.length);
        studentsRepository = newRepository;
    }
}
