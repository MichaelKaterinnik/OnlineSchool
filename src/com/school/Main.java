package com.school;

import com.school.models.studytools.Course;
import com.school.models.studytools.Lecture;
import com.school.models.studytools.services.CourseService;
import com.school.models.studytools.services.LectureService;

public class Main {

    public static void main(String[] args) {
	    /* Lecture firstLecture = new Lecture();
        Lecture secondLecture = new Lecture();
        Lecture thirdLecture = new Lecture();
        Lecture fourthLecture = new Lecture();
        Lecture fifthLecture = new Lecture();
        System.out.println(Lecture.counter); */

        CourseService courseService = new CourseService();
        Course course1 = courseService.createCourse(1);

        LectureService lectureService = new LectureService();
        Lecture lecture1 = lectureService.createLecture();
        lecture1.courseID = course1.getCourseNumber();

        Lecture lecture2 = lectureService.createLecture();
        lecture2.courseID = course1.getCourseNumber();
        Lecture lecture3 = lectureService.createLecture();
        lecture3.courseID = course1.getCourseNumber();
        Lecture lecture4 = lectureService.createLecture();
        lecture4.courseID = course1.getCourseNumber();
        Lecture lecture5 = lectureService.createLecture();
        lecture5.courseID = course1.getCourseNumber();
        Lecture lecture6 = lectureService.createLecture();
        lecture6.courseID = course1.getCourseNumber();

        System.out.println("Остання створена лекція належить до курсу № "+ lecture6.courseID);
        System.out.println("Загальна кількість створених лекцій - " + Lecture.getCounter());
    }


}
