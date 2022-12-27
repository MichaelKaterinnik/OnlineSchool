package com.school.models.studytools.services;

import com.school.models.SuperRepo;
import com.school.models.studytools.Lecture;

import java.util.Arrays;

public class LectureRepo extends SuperRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Lecture[] lecturesRepository = new Lecture[capacity];

    public static Lecture[] getAll() {
        return lecturesRepository;
    }

    public static void add(Lecture newLecture) {
        if (size == capacity) {
            grow();
        }
        lecturesRepository[size] = newLecture;
        size++;
    }

    public static Lecture getById(int id)    {
        for (Lecture lecture : lecturesRepository) {
            if (lecture.getId() == id) {
                return lecture;
            }
        }
        return null;
    }

    public static void deleteById(int id)   {
        for (int i = 0; i < lecturesRepository.length; i++)    {
            if (lecturesRepository[i] != null && lecturesRepository[i].getId() == id)   {
                lecturesRepository[i] = null;
            }
        }
        int k;
        for (int i = 0; i < lecturesRepository.length; i++) {
            if (lecturesRepository[i] == null) {
                k = i;
                while (k < lecturesRepository.length - 1) {
                    lecturesRepository[k] = lecturesRepository[k + 1];
                    k++;
                }
            }
        }
        size--;
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
