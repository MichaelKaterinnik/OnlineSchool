package com.school.models.studytools.services;

import com.school.models.SuperRepo;
import com.school.models.studytools.Lecture;


public class LectureRepo extends SuperRepo {
    private static int index = 0;
    private static int capacity = 10;
    private static Lecture[] lecturesRepository = new Lecture[capacity];

    public static Lecture[] getAll() {
        return lecturesRepository;
    }

    public static void add(Lecture newLecture) {
        if (index == capacity) {
            grow();
        }
        lecturesRepository[index] = newLecture;
        index++;
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
        int index = 0;
        for (int i = 0; i < lecturesRepository.length; i++)    {
            if (lecturesRepository[i] != null && lecturesRepository[i].getId() == id)   {
                lecturesRepository[i] = null;
            }
            index = i;
        }
        if (index < lecturesRepository.length - 1) {
            while (index < lecturesRepository.length - 1) {
                lecturesRepository[index] = lecturesRepository[index + 1];
                index++;
            }
            lecturesRepository[lecturesRepository.length - 1] = null;
        }
        LectureRepo.index--;
    }

    private static void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Lecture[] newLecturesRepository = new Lecture[capacity];
        System.arraycopy(lecturesRepository, 0, newLecturesRepository, 0, lecturesRepository.length);
        lecturesRepository = newLecturesRepository;
    }

}
