package com.school.models.studytools.services;

import com.school.models.studytools.Course;
import com.school.models.studytools.Lecture;

import java.util.Scanner;

public class CourseService {
    private final static String CATEGORY_CHANGER = "Оберіть категорію: 1 - курс, 2 - вчителі, 3 - студенти, 4 - лекції. " +
            "Введіть потрібне число з 4-х:";
    private final static String CATEGORY_COURSE = "Ви знаходитесь у категорії вибору курсу";
    private final static String CATEGORY_TEACHER = "Ви знаходитесь у категорії вибору вчителів";
    private final static String CATEGORY_STUDENT = "Ви знаходитесь у категорії вибору студентів";
    private final static String CATEGORY_LECTURE = "Ви знаходитесь у категорії вибору лекцій";
    private final static String CHANGER_EXCEPTION = "Введіть одне з чотирьох запитуваних чисел, будь-ласка";


    public Course createCourse(int id) {
        return new Course(id);
    }
    public Course createCourse(String courseName, int courseNumber) {
        return new Course(courseName, courseNumber);
    }
    public Course createCourse(int courseNumber, String courseName) {
        return new Course(courseName, courseNumber);
    }


    public static String getCourseChangerString() {
        return CATEGORY_CHANGER;
    }
    public static String getCategoryCourseString() {
        return CATEGORY_COURSE;
    }
    public static String getCategoryTeacherString() {
        return CATEGORY_TEACHER;
    }
    public static String getCategoryStudentString() {
        return CATEGORY_STUDENT;
    }
    public static String getCategoryLectureString() {
        return CATEGORY_LECTURE;
    }
    public static String getChangerExceptionString() {
        return CHANGER_EXCEPTION;
    }

    public static void CategoryChanger() {
        Scanner console = new Scanner(System.in);
        System.out.println(CATEGORY_CHANGER);
        int category = console.nextInt();
        switch (category) {
            case 1: {
                System.out.println(CATEGORY_COURSE);
                break;
            }
            case 2: {
                System.out.println(CATEGORY_TEACHER);
                break;
            }
            case 3: {
                System.out.println(CATEGORY_STUDENT);
                break;
            }
            case 4: {
                System.out.println(CATEGORY_LECTURE);
                LectureService lectureService = new LectureService();
                lectureService.createLectureByTerminal();
                break;
            }
            default:    { System.out.println(CHANGER_EXCEPTION); }
        }
        console.close();
    }

}
