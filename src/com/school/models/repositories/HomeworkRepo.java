package com.school.models.repositories;

import com.school.models.SuperRepo;
import com.school.models.Homework;

public class HomeworkRepo extends SuperRepo {
    private int index = 0;
    private int capacity = 10;
    private Homework[] homeworkRepository = new Homework[capacity];

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
        return HomeworkRepo.getInstance().homeworkRepository;
    }

    public void add(Homework newHomework) {
        if (index == capacity) {
            grow();
        }
        homeworkRepository[index] = newHomework;
        index++;
    }

    public Homework getById(int id)    {
        for (Homework hw : homeworkRepository) {
            if (hw.getId() == id) {
                return hw;
            }
        }
        return null;
    }

    public void deleteById(int id)   {
        int pic = 0;
        for (int i = 0; i < homeworkRepository.length; i++)    {
            if (homeworkRepository[i] != null && homeworkRepository[i].getId() == id)   {
                homeworkRepository[i] = null;
            }
            pic = i;
        }
        if (pic < homeworkRepository.length - 1) {
            while (pic < homeworkRepository.length - 1) {
                homeworkRepository[pic] = homeworkRepository[pic + 1];
                pic++;
            }
            homeworkRepository[homeworkRepository.length - 1] = null;
        }
        HomeworkRepo.getInstance().index--;
    }

    private void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Homework[] newHomeworkRepository = new Homework[capacity];
        System.arraycopy(homeworkRepository, 0, newHomeworkRepository, 0, homeworkRepository.length);
        homeworkRepository = newHomeworkRepository;
    }
}
