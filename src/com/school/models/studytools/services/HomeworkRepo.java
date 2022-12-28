package com.school.models.studytools.services;

import com.school.models.SuperRepo;
import com.school.models.studytools.Homework;

public class HomeworkRepo extends SuperRepo {
    private static int index = 0;
    private static int capacity = 10;
    private static Homework[] homeworkRepository = new Homework[capacity];

    public static Homework[] getHomeworkRepository() {
        return homeworkRepository;
    }

    public static void add(Homework newHomework) {
        if (index == capacity) {
            grow();
        }
        homeworkRepository[index] = newHomework;
        index++;
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
        int index = 0;
        for (int i = 0; i < homeworkRepository.length; i++)    {
            if (homeworkRepository[i] != null && homeworkRepository[i].getId() == id)   {
                homeworkRepository[i] = null;
            }
            index = i;
        }
        if (index < homeworkRepository.length - 1) {
            while (index < homeworkRepository.length - 1) {
                homeworkRepository[index] = homeworkRepository[index + 1];
                index++;
            }
            homeworkRepository[homeworkRepository.length - 1] = null;
        }
        HomeworkRepo.index--;
    }

    private static void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Homework[] newHomeworkRepository = new Homework[capacity];
        System.arraycopy(homeworkRepository, 0, newHomeworkRepository, 0, homeworkRepository.length);
        homeworkRepository = newHomeworkRepository;
    }
}
