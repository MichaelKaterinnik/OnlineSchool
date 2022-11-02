package com.school;

import com.school.models.studytools.Course;
import com.school.models.studytools.Lecture;

public class Main {

    public static void main(String[] args) {
	    /* Lecture firstLecture = new Lecture();
        Lecture secondLecture = new Lecture();
        Lecture thirdLecture = new Lecture();
        Lecture fourthLecture = new Lecture();
        Lecture fifthLecture = new Lecture();
        System.out.println(Lecture.counter); */

        course1Init();
    }

    static void course1Init()    {
        Course course1 = new Course();
        Lecture lecture1 = new Lecture();
        course1.courseNumber = 1;
        course1.setID(course1.courseNumber);
        lecture1.courseID = course1.getID();
        Lecture lecture2 = new Lecture();
        Lecture lecture3 = new Lecture();
        Lecture lecture4 = new Lecture();
        Lecture lecture5 = new Lecture();
        Lecture lecture6 = new Lecture();
        lecture2.courseID = course1.getID();
        lecture3.courseID = course1.getID();
        lecture4.courseID = course1.getID();
        lecture5.courseID = course1.getID();
        lecture6.courseID = course1.getID();
        System.out.println(lecture6.courseID);
        System.out.println(Lecture.counter);
    }
}
