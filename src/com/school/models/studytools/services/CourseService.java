package com.school.models.studytools.services;

import com.school.models.studytools.Course;
import com.school.models.studytools.Homework;
import com.school.models.studytools.Lecture;

import java.util.Scanner;

public class CourseService {
    private final static String CATEGORY_CHANGER = "Оберіть категорію: 1 - курс, 2 - вчителі, 3 - студенти, 4 - лекції. " +
            "Введіть потрібне число з 4-х";
    private final static String CATEGORY_COURSE = "Ви знаходитесь у категорії вибору курсу";
    private final static String CATEGORY_TEACHER = "Ви знаходитесь у категорії вибору вчителів";
    private final static String CATEGORY_STUDENT = "Ви знаходитесь у категорії вибору студентів";
    private final static String CATEGORY_LECTURE = "Ви знаходитесь у категорії вибору лекцій. Чи бажаєте Ви додати нову лекцію? Введіть " +
            "число 1, якщо так:";
    private final static String CHANGER_EXCEPTION = "Введіть одне з запитуваних чисел, будь-ласка";
    private final static String DO_YOU_WANT_TO_CONTINUE = "Чи бажаєте Ви продовжувати працювати з програмою? Введіть число 1, якщо так або натисніть будь-яку іншу клавішу, якщо ні";

    public static final String ENTER_COURSE_ID = "Введіть ID створюваного курсу";
    public static final String ENTER_COURSE_NUMBER_EXCEPTION = "Введіть номер ID курсу, будь-ласка";

    public Course createCourse()    {
        return new Course();
    }
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
        boolean isProgramWorking = true;
        while (isProgramWorking) {
            System.out.println(CATEGORY_CHANGER);
            if (console.hasNextInt())  {
                int category = console.nextInt();
                if (category == 1) {
                    System.out.println(CATEGORY_COURSE);
                } else if (category == 2) {
                    System.out.println(CATEGORY_TEACHER);
                } else if (category == 3) {
                    System.out.println(CATEGORY_STUDENT);
                } else if (category == 4) {
                    System.out.println(CATEGORY_LECTURE);
                    if (console.hasNextInt() && console.nextInt() == 1) {
                        LectureService lectureService = new LectureService();
                        lectureService.createLectureByTerminal();
                        System.out.println("Загальна кількість створених лекцій: " + Lecture.getCounter());
                    }
                } else {
                    System.out.println(DO_YOU_WANT_TO_CONTINUE);
                    if (console.hasNext() && console.hasNextInt() && console.nextInt() == 1) {
                        continue;
                    } else {
                        isProgramWorking = false;
                        console.close();
                        System.out.println("роботу метода CategoryChanger закінчено");
                        return;
                    }
                }
            }
            System.out.println(DO_YOU_WANT_TO_CONTINUE);
            if (console.hasNext() && console.hasNextInt() && console.nextInt() == 1) {
                continue;
            } else {
                isProgramWorking = false;
                console.close();
                System.out.println("роботу метода CategoryChanger закінчено");
                return;
            }
        }
        console.close();
        System.out.println("роботу метода CategoryChanger закінчено");
        return;
    }

    public Course createCourseByTerminal()    {
        Scanner console = new Scanner(System.in);
        CourseService courseService = new CourseService();
        Course newCourse = courseService.createCourse();
        System.out.println(ENTER_COURSE_ID);
        boolean st = true;
        while (st) {
            if (console.hasNextInt())  {
                newCourse.setID(console.nextInt());
                System.out.println("Ви присвоїли створеному курсу ID №" + newCourse.getID());
                st = false;
            } else {
                System.out.println(ENTER_COURSE_NUMBER_EXCEPTION);
                continue;
            }
        }
        return newCourse;
    }

}
