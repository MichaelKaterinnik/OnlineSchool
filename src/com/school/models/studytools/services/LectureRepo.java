package com.school.models.studytools.services;

import com.school.models.studytools.Lecture;

public class LectureRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Lecture[] lecturesRepository = new Lecture[capacity];


    public static Lecture[] getLecturesRepository() {
        return lecturesRepository;
    }

    public static void saveLecture(Lecture newLecture) {
        if (size == capacity) {
            grow();
        }
        lecturesRepository[size] = newLecture;
        size++;
    }

    private static void grow() {
        capacity = (int) (capacity * 3) / 2 + 1;
        Lecture[] newLecturesRepository = new Lecture[capacity];
        for (int i = 0; i < lecturesRepository.length; i++) {
            newLecturesRepository[i] = lecturesRepository[i];
        }
        lecturesRepository = newLecturesRepository;
    }

}
