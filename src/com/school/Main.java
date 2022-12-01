package com.school;

import com.school.models.studytools.Course;
import com.school.models.studytools.Lecture;
import com.school.models.studytools.services.CourseService;
import com.school.models.studytools.services.LectureService;


public class Main {

    public static void main(String[] args) {



        CourseService courseService = new CourseService();
        Course course1 = courseService.createCourse(1);

        LectureService lectureService = new LectureService();
        Lecture lecture1 = lectureService.createLecture();
        lecture1.setCourseID(course1.getID());

        Lecture lecture2 = lectureService.createLecture();
        lecture2.setCourseID(course1.getID());
        Lecture lecture3 = lectureService.createLecture();
        lecture3.setCourseID(course1.getID());
        Lecture lecture4 = lectureService.createLecture();
        lecture4.setCourseID(course1.getID());
        Lecture lecture5 = lectureService.createLecture();
        lecture5.setCourseID(course1.getID());
        Lecture lecture6 = lectureService.createLecture();
        lecture6.setCourseID(course1.getID());

        System.out.println("Остання створена лекція належить до курсу № "+ lecture6.getCourseID());
        System.out.println("Загальна кількість створених лекцій - " + Lecture.getCounter());

    }




}
