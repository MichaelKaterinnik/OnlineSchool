package com.school;

import com.school.models.people.services.StudentService;
import com.school.models.people.services.TeacherService;
import com.school.models.studytools.Lecture;
import com.school.models.studytools.services.CourseService;
import com.school.models.studytools.services.LectureService;

import java.util.Scanner;

public class MainService {
    private final static String CATEGORY_CHANGER = "Оберіть категорію:\n1 - курс\n2 - вчителі\n3 - студенти\n4 - лекції\n" +
            "Введіть потрібне число з 4-х або введіть exit щоб вийти з програми";
    private final static String CATEGORY_COURSE = "Ви знаходитесь у категорії вибору курсу. Чи бажаєте Ви додати новий курс?\nВведіть число 1, якщо так:";
    private final static String CATEGORY_TEACHER = "Ви знаходитесь у категорії вибору вчителів. Чи бажаєте Ви додати нового вчителя?\nВведіть число 1, якщо так:";
    private final static String CATEGORY_STUDENT = "Ви знаходитесь у категорії вибору студентів. Чи бажаєте Ви додати нового студента?\nВведіть число 1, якщо так:";
    private final static String CATEGORY_LECTURE = "Ви знаходитесь у категорії вибору лекцій. Чи бажаєте Ви додати нову лекцію?\nВведіть " +
            "число 1, якщо так:";
    private final static String CHANGER_EXCEPTION = "Введіть одне з запитуваних чисел, будь-ласка";


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

    public static void categoryChanger() {
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.println(CATEGORY_CHANGER);
            if (console.hasNextInt()) {
                int category = console.nextInt();
                switch (category) {
                    case 1 -> {
                        courseCase();
                    }
                    case 2 -> {
                        teacherCase();
                    }
                    case 3 -> {
                        studentCase();
                    }
                    case 4 -> {
                        lectureCase();
                        if (Lecture.getCounter() == 8) {
                            console.close();
                            System.out.println("Роботу програми закінчено - створено 8 лекцій");
                            return;
                        }
                    }
                    default -> {
                        continue;
                    }
                }
            } else if (console.hasNextLine() && console.nextLine().equalsIgnoreCase("exit")) {
                System.out.println("роботу метода CategoryChanger закінчено");
                console.close();
                return;
            } else {
                System.out.println();
                continue;
            }
        }
    }

    private static void courseCase() {
        System.out.println(CATEGORY_COURSE);
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            CourseService courseService = new CourseService();
            courseService.createCourseByTerminal();
        }
    }

    private static void teacherCase() {
        System.out.println(CATEGORY_TEACHER);
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            TeacherService teacherService = new TeacherService();
            teacherService.createTeacherByTerminal();
        }
    }

    private static void studentCase() {
        System.out.println(CATEGORY_STUDENT);
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            StudentService studentService = new StudentService();
            studentService.createStudentByTerminal();
        }
    }

    private static void lectureCase() {
        System.out.println(CATEGORY_LECTURE);
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            LectureService lectureService = new LectureService();
            lectureService.createLectureByTerminal();
            System.out.println("Загальна кількість створених лекцій: " + Lecture.getCounter());
        }
    }

    private MainService() {

    }
}

