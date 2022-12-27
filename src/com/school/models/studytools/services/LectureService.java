package com.school.models.studytools.services;

import com.school.models.studytools.Lecture;

import java.util.Arrays;
import java.util.Scanner;

public class LectureService {
    private static final String ENTER_LECTURE_NAME = "Введіть тему нової лекції українською мовою";
    private static final String ENTER_COURSE_NUMBER = "Введіть курс (id ІСНУЮЧОГО курсу), до якого належатиме лекція";
    private static final String ENTER_LECTURE_NAME_EXCEPTION = "Введіть тему нової лекції українською мовою,будь-ласка";
    private static final String ENTER_COURSE_NUMBER_EXCEPTION = "Введіть номер існуючого курсу (ID курсу), до якого належатиме лекція," +
            "будь-ласка";

    public Lecture createLecture()  {
        return new Lecture();
    }

    public void createLectureByTerminal()    {
        Scanner console = new Scanner(System.in);
        LectureService lectureService = new LectureService();
        Lecture newLecture = lectureService.createLecture();
        System.out.println(ENTER_LECTURE_NAME);
        while (true) {
            if (console.hasNextLine())  {
                newLecture.setLectureTopic(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_LECTURE_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_COURSE_NUMBER);
        while (true) {
            if (console.hasNextInt())  {
                newLecture.setCourseID(console.nextInt());
                System.out.println("Ви присвоїли створену лекцію курсу з номером (ID)" + newLecture.getCourseID());
                break;
            } else {
                System.out.println(ENTER_COURSE_NUMBER_EXCEPTION);
            }
        }
        LectureRepo.add(newLecture);
    }

    public static void showLectures()  {
        Lecture[] result = Arrays.copyOf(LectureRepo.getAll(), LectureRepo.getAll().length);
        for (Lecture lecture : result) {
            if (lecture != null) {
                System.out.println("ID наявної лекції: " + lecture.getId());
            }
        }
        System.out.println(Arrays.toString(result));
    }

}
