package com.school.models.people.services;

import com.school.models.SuperRepo;
import com.school.models.people.Teacher;
import com.school.models.studytools.AdditionalMaterials;
import com.school.models.studytools.services.AddMatsRepo;

public class TeacherRepo extends SuperRepo {
    private int index = 0;
    private int capacity = 10;
    private Teacher[] teachersRepository = new Teacher[capacity];

    private TeacherRepo() {
    }

    private static class TeacherRepoHolder    {
        public static final TeacherRepo TEACHER_REPO_INSTANCE = new TeacherRepo();
    }

    // methods:
    public static TeacherRepo getInstance() {
        return TeacherRepoHolder.TEACHER_REPO_INSTANCE;
    }

    public static Teacher[] getAll() {
        return TeacherRepo.getInstance().teachersRepository;
    }

    public void add(Teacher newTeacher) {
        if (index == capacity) {
            grow();
        }
        teachersRepository[index] = newTeacher;
        index++;
    }

    public Teacher getById(int id)    {
        for (Teacher teacher : teachersRepository) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public void deleteById(int id)   {
        int pic = 0;
        for (int i = 0; i < teachersRepository.length; i++)    {
            if (teachersRepository[i] != null && teachersRepository[i].getId() == id)   {
                teachersRepository[i] = null;
            }
            pic = i;
        }
        if (pic < teachersRepository.length - 1) {
            while (pic < teachersRepository.length - 1) {
                teachersRepository[pic] = teachersRepository[pic + 1];
                pic++;
            }
            teachersRepository[teachersRepository.length - 1] = null;
        }
        TeacherRepo.getInstance().index--;
    }

    private void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Teacher[] newRepository = new Teacher[capacity];
        System.arraycopy(teachersRepository, 0, newRepository, 0, teachersRepository.length);
        teachersRepository = newRepository;
    }
}
