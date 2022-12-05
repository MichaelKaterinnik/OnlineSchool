package com.school.models.studytools.services;

import com.school.models.studytools.Lecture;

import java.util.Scanner;

public class LectureService {
    private static final String ENTER_LECTURE_NAME = "Введіть тему нової лекції українською мовою";
    private static final String ENTER_COURSE_NUMBER = "Введіть курс (ID курсу), до якого належатиме лекція";
    private static final String ENTER_LECTURE_NAME_EXCEPTION = "Введіть тему нової лекції українською мовою,будь-ласка";
    private static final String ENTER_COURSE_NUMBER_EXCEPTION = "Введіть номер існуючого курсу (ID курсу), до якого належатиме лекція," +
            "будь-ласка";

    public Lecture createLecture()  {
        return new Lecture();
    }

    public Lecture createLectureByTerminal()    {
        Scanner console = new Scanner(System.in);
        LectureService lectureService = new LectureService();
        Lecture newLecture = lectureService.createLecture();
        System.out.println(ENTER_LECTURE_NAME);
        boolean st1 = true;
        while (st1) {
            if (console.hasNextLine())  {
                newLecture.setLectureTopic(console.nextLine());
                st1 = false;
            } else {
                System.out.println(ENTER_LECTURE_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_COURSE_NUMBER);
        boolean st2 = true;
        while (st2) {
            if (console.hasNextInt())  {
                newLecture.setCourseID(console.nextInt());
                System.out.println("Ви присвоїли створену лекцію курсу з номером (ID)" + newLecture.getCourseID());
                st2 = false;
            } else {
                System.out.println(ENTER_COURSE_NUMBER_EXCEPTION);
            }
        }
        return newLecture;
    }

}
