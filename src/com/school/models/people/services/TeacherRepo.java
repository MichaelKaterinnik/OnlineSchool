package com.school.models.people.services;

import com.school.models.SuperRepo;
import com.school.models.people.Teacher;

public class TeacherRepo extends SuperRepo {
    private static int index = 0;
    private static int capacity = 10;
    private static Teacher[] teachersRepository = new Teacher[capacity];


    public static Teacher[] getTeachersRepository() {
        return teachersRepository;
    }

    public static void add(Teacher newTeacher) {
        if (index == capacity) {
            grow();
        }
        teachersRepository[index] = newTeacher;
        index++;
    }

    public static Teacher getById(int id)    {
        for (Teacher teacher : teachersRepository) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public static void deleteById(int id)   {
        int index = 0;
        for (int i = 0; i < teachersRepository.length; i++)    {
            if (teachersRepository[i] != null && teachersRepository[i].getId() == id)   {
                teachersRepository[i] = null;
            }
            index = i;
        }
        if (index < teachersRepository.length - 1) {
            while (index < teachersRepository.length - 1) {
                teachersRepository[index] = teachersRepository[index + 1];
                index++;
            }
            teachersRepository[teachersRepository.length - 1] = null;
        }
        TeacherRepo.index--;
    }

    private static void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Teacher[] newRepository = new Teacher[capacity];
        System.arraycopy(teachersRepository, 0, newRepository, 0, teachersRepository.length);
        teachersRepository = newRepository;
    }
}
