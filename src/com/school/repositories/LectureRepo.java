package com.school.repositories;

import com.school.models.Lecture;
import com.school.models.Person;


public class LectureRepo extends SuperRepo {
    private static Storage<Lecture> storage = new Storage<>();


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
        return storage.getAll();
    }

    public void addS(Lecture lecture) {
        storage.add(lecture);
    }

    public Lecture getById(int id) {
        return storage.get(id);
    }

    public void deleteById(int id) {
        storage.remove(id);
    }

}
