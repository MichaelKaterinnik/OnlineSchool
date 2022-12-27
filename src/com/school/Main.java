package com.school;


import com.school.models.studytools.Lecture;
import com.school.models.studytools.services.LectureRepo;

public class Main {

    public static void main(String[] args) {
        MainService.initializer();
        System.out.println("кол. лекций - " + Lecture.getCounter());    // для тестування
        System.out.println(LectureRepo.getById(2));                     // для тестування
        LectureRepo.deleteById(2);                                      // для тестування
        MainService.categoryChanger();
    }




}
