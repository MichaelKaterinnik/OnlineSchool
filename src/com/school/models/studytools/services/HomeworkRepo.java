package com.school.models.studytools.services;

import com.school.models.SuperRepo;
import com.school.models.studytools.Homework;

public class HomeworkRepo extends SuperRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Homework[] homeworkRepository = new Homework[capacity];


    public static Homework[] getHomeworkRepository() {
        return homeworkRepository;
    }

    public static void add(Homework newHomework) {
        if (size == capacity) {
            grow();
        }
        homeworkRepository[size] = newHomework;
        size++;
    }

    public static Homework getById(int id)    {
        for (Homework hw : homeworkRepository) {
            if (hw.getId() == id) {
                return hw;
            }
        }
        return null;
    }

    public static void deleteById(int id)   {
        for (int i = 0; i < homeworkRepository.length; i++)    {
            if (homeworkRepository[i] != null && homeworkRepository[i].getId() == id)   {
                homeworkRepository[i] = null;
            }
        }
        int k;
        for (int i = 0; i < homeworkRepository.length; i++) {
            if (homeworkRepository[i] == null) {
                k = i;
                while (k < homeworkRepository.length - 1) {
                    homeworkRepository[k] = homeworkRepository[k + 1];
                    k++;
                }
            }
        }
        size--;
    }

    private static void grow() {
        capacity = (int) (capacity * 3) / 2 + 1;
        Homework[] newHomeworkRepository = new Homework[capacity];
        for (int i = 0; i < homeworkRepository.length; i++) {
            newHomeworkRepository[i] = homeworkRepository[i];
        }
        homeworkRepository = newHomeworkRepository;
    }
}
