package com.school.models.people.services;

import com.school.models.SuperRepo;
import com.school.models.people.Teacher;

public class TeacherRepo extends SuperRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Teacher[] teachersRepository = new Teacher[capacity];


    public static Teacher[] getTeachersRepository() {
        return teachersRepository;
    }

    public static void add(Teacher newTeacher) {
        if (size == capacity) {
            grow();
        }
        teachersRepository[size] = newTeacher;
        size++;
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
        for (int i = 0; i < teachersRepository.length; i++)    {
            if (teachersRepository[i] != null && teachersRepository[i].getId() == id)   {
                teachersRepository[i] = null;
            }
        }
        int k = 0;
        for (int i = 0; i < teachersRepository.length; i++) {
            if (teachersRepository[i] == null) {
                k = i;
                while (k < teachersRepository.length - 1) {
                    teachersRepository[k] = teachersRepository[k + 1];
                    k++;
                }
            }
        }
        size--;
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
