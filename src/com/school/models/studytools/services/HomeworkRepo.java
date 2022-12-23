package com.school.models.studytools.services;

import com.school.models.studytools.Homework;

public class HomeworkRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Homework[] homeworkRepository = new Homework[capacity];


    public static void saveHomework(Homework newHomework) {
        if (size == capacity) {
            grow();
        }
        homeworkRepository[size] = newHomework;
        size++;
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
