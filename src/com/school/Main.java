package com.school;

import com.school.models.studytools.Course;
import com.school.models.studytools.Lecture;
import com.school.models.studytools.services.CourseService;
import com.school.models.studytools.services.LectureService;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // ДЗ до лекції № 7:
        CourseService.CategoryChanger(); // метод знаходиться в класі CourseServise

        // ДЗ до лекції № 6:
        CourseService courseService = new CourseService();
        Course course1 = courseService.createCourse(1);

        LectureService lectureService2 = new LectureService();
        Lecture lecture1 = lectureService2.createLecture();
        lecture1.setCourseID(course1.getID());

        Lecture lecture2 = lectureService2.createLecture();
        lecture2.setCourseID(course1.getID());
        Lecture lecture3 = lectureService2.createLecture();
        lecture3.setCourseID(course1.getID());
        Lecture lecture4 = lectureService2.createLecture();
        lecture4.setCourseID(course1.getID());
        Lecture lecture5 = lectureService2.createLecture();
        lecture5.setCourseID(course1.getID());
        Lecture lecture6 = lectureService2.createLecture();
        lecture6.setCourseID(course1.getID());

        System.out.println("Остання створена лекція належить до курсу № "+ lecture6.getCourseID());
        System.out.println("Загальна кількість створених лекцій - " + Lecture.getCounter());

    }




}
