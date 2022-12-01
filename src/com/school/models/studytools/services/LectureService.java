package com.school.models.studytools.services;

import com.school.models.studytools.Lecture;

import java.util.Scanner;

public class LectureService {
    public static final String ENTER_LECTURE_NAME = "Введіть тему нової лекції українською мовою";
    public static final String ENTER_COURSE_NUMBER = "Введіть курс (ID курсу), до якого належатиме лекція";
    public static final String ENTER_LECTURE_NAME_EXCEPTION = "Введіть тему нової лекції українською мовою,будь-ласка";
    public static final String ENTER_COURSE_NUMBER_EXCEPTION = "Введіть номер існуючого курсу (ID курсу), до якого належатиме лекція," +
            "будь-ласка";

    public Lecture createLecture()  {
        return new Lecture();
    }
    public Lecture createLectureByTerminal()    {
        Scanner console = new Scanner(System.in);
        LectureService lectureService = new LectureService();
        Lecture newLecture = lectureService.createLecture();
        System.out.println(ENTER_LECTURE_NAME);
        if (console.hasNextLine())  {
            newLecture.setLectureTopic(console.nextLine());
        } else {
            System.out.println(ENTER_LECTURE_NAME_EXCEPTION);
        }
        System.out.println(ENTER_COURSE_NUMBER);
        if (console.hasNextInt())  {
            newLecture.setCourseID(console.nextInt());
        } else {
            System.out.println(ENTER_COURSE_NUMBER_EXCEPTION);
        }
        return newLecture;
    }

}
