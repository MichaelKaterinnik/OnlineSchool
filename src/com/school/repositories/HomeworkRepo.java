package com.school.repositories;

import com.school.models.Homework;
import com.school.models.Lecture;

public class HomeworkRepo extends SuperRepo {
    private static Storage<Homework> storage = new Storage<>();


    private HomeworkRepo() {
    }

    private static class HomeworkRepoHolder    {
        public static final HomeworkRepo HOMEWORK_REPO_INSTANCE = new HomeworkRepo();
    }

    // methods:
    public static HomeworkRepo getInstance() {
        return HomeworkRepoHolder.HOMEWORK_REPO_INSTANCE;
    }

    public static Homework[] getAll() {
        return storage.getAll();
    }

    public void addS(Homework hw) {
        storage.add(hw);
    }

    public Homework getById(int id) {
        return storage.get(id);
    }

    public void deleteById(int id) {
        storage.remove(id);
    }
}
