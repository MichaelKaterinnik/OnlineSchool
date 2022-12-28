package com.school.models.people.services;

import com.school.models.SuperRepo;
import com.school.models.people.Student;
import com.school.models.people.Teacher;

public class StudentRepo extends SuperRepo {
    private int index = 0;
    private int capacity = 10;
    private Student[] studentsRepository = new Student[capacity];

    private StudentRepo() {
    }

    private static class StudentRepoHolder    {
        public static final StudentRepo STUDENT_REPO_INSTANCE = new StudentRepo();
    }

    // methods:
    public static StudentRepo getInstance() {
        return StudentRepoHolder.STUDENT_REPO_INSTANCE;
    }

    public static Student[] getAll() {
        return StudentRepo.getInstance().studentsRepository;
    }

    public void add(Student newStudent) {
        if (index == capacity) {
            grow();
        }
        studentsRepository[index] = newStudent;
        index++;
    }

    public Student getById(int id)    {
        for (Student student : studentsRepository) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteById(int id)   {
        int pic = 0;
        for (int i = 0; i < studentsRepository.length; i++)    {
            if (studentsRepository[i] != null && studentsRepository[i].getId() == id)   {
                studentsRepository[i] = null;
            }
            pic = i;
        }
        if (pic < studentsRepository.length - 1) {
            while (pic < studentsRepository.length - 1) {
                studentsRepository[pic] = studentsRepository[pic + 1];
                pic++;
            }
            studentsRepository[studentsRepository.length - 1] = null;
        }
        StudentRepo.getInstance().index--;
    }

    private void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Student[] newRepository = new Student[capacity];
        System.arraycopy(studentsRepository, 0, newRepository, 0, studentsRepository.length);
        studentsRepository = newRepository;
    }
}
