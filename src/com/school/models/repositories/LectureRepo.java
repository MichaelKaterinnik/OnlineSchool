package com.school.models.repositories;

import com.school.models.SuperRepo;
import com.school.models.Lecture;


public class LectureRepo extends SuperRepo {
    private int index = 0;
    private int capacity = 10;
    private Lecture[] lecturesRepository = new Lecture[capacity];

    private LectureRepo() {
    }

    private static class LectureRepoHolder    {
        public static final LectureRepo LECTURE_REPO_INSTANCE = new LectureRepo();
    }

    // methods:
    public static LectureRepo getInstance() {
        return LectureRepoHolder.LECTURE_REPO_INSTANCE;
    }

    public static Lecture[] getAll() {
        return LectureRepo.getInstance().lecturesRepository;
    }

    public void add(Lecture newLecture) {
        if (index == capacity) {
            grow();
        }
        lecturesRepository[index] = newLecture;
        index++;
    }

    public Lecture getById(int id)    {
        for (Lecture lecture : lecturesRepository) {
            if (lecture.getId() == id) {
                return lecture;
            }
        }
        return null;
    }

    public void deleteById(int id)   {
        int pic = 0;
        for (int i = 0; i < lecturesRepository.length; i++)    {
            if (lecturesRepository[i] != null && lecturesRepository[i].getId() == id)   {
                lecturesRepository[i] = null;
            }
            pic = i;
        }
        if (pic < lecturesRepository.length - 1) {
            while (pic < lecturesRepository.length - 1) {
                lecturesRepository[pic] = lecturesRepository[pic + 1];
                pic++;
            }
            lecturesRepository[lecturesRepository.length - 1] = null;
        }
        LectureRepo.getInstance().index--;
    }

    private void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Lecture[] newLecturesRepository = new Lecture[capacity];
        System.arraycopy(lecturesRepository, 0, newLecturesRepository, 0, lecturesRepository.length);
        lecturesRepository = newLecturesRepository;
    }

}
