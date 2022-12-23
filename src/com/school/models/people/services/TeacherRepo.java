package com.school.models.people.services;

import com.school.models.people.Teacher;

public class TeacherRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Teacher[] teachersRepository = new Teacher[capacity];


    public static void saveTeacher(Teacher newTeacher) {
        if (size == capacity) {
            grow();
        }
        teachersRepository[size] = newTeacher;
        size++;
    }

    private static void grow() {
        capacity = (int) (capacity * 3) / 2 + 1;
        Teacher[] newRepository = new Teacher[capacity];
        for (int i = 0; i < teachersRepository.length; i++) {
            newRepository[i] = teachersRepository[i];
        }
        teachersRepository = newRepository;
    }
}
