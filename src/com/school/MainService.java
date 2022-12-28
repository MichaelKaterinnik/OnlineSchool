package com.school;

import com.school.models.people.Student;
import com.school.models.people.Teacher;
import com.school.models.people.services.StudentService;
import com.school.models.people.services.TeacherService;
import com.school.models.studytools.Course;
import com.school.models.studytools.Lecture;
import com.school.models.studytools.services.CourseService;
import com.school.models.studytools.services.LectureService;

import java.util.Scanner;

public class MainService {
    // поля:
    private final static String CATEGORY_CHANGER = """
    Оберіть категорію:\n1 - курс\n2 - вчителі\n3 - студенти\n4 - лекції\n5 - переглянути створені об'єкти\nВведіть потрібне число з 5-ти або введіть exit щоб вийти з програми""";
    private final static String CATEGORY_COURSE = "Ви знаходитесь у категорії вибору курсу. Чи бажаєте Ви додати новий курс?\nВведіть число 1, якщо так:";
    private final static String CATEGORY_TEACHER = "Ви знаходитесь у категорії вибору вчителів. Чи бажаєте Ви додати нового вчителя?\nВведіть число 1, якщо так:";
    private final static String CATEGORY_STUDENT = "Ви знаходитесь у категорії вибору студентів. Чи бажаєте Ви додати нового студента?\nВведіть число 1, якщо так:";
    private final static String CATEGORY_LECTURE = "Ви знаходитесь у категорії вибору лекцій. Чи бажаєте Ви додати нову лекцію?\nВведіть число 1, якщо так:";
    private final static String CHANGER_EXCEPTION = "Введіть одне з запитуваних чисел, будь-ласка";

    // конструктор:
    private MainService() {

    }

    // методи:
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

    public static void initializer()    {
        System.out.println("Розпочалася робота програми. Необхідно створити один курс та до нього 3 лекції");
        CourseService courseService = new CourseService();
        courseService.createCourseByTerminal();
        System.out.println("Початковий курс створено. Тепер додамо до нього 3 лекції");
        LectureService lectureService = new LectureService();
        lectureService.createLectureByTerminal();
        lectureService.createLectureByTerminal();
        lectureService.createLectureByTerminal();
    }

    public static void categoryChanger() {
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.println(CATEGORY_CHANGER);
            if (console.hasNextInt()) {
                int category = console.nextInt();
                switch (category) {
                    case 1 -> courseCase();
                    case 2 -> teacherCase();
                    case 3 -> studentCase();
                    case 4 -> {
                        lectureCase();
                        if (Lecture.getCounter() == 8) {
                            console.close();
                            System.out.println("Роботу програми закінчено - створено 8 лекцій");
                            return;
                        }
                    }
                    case 5 -> showObjects();
                }
            } else if (console.hasNextLine() && console.nextLine().equalsIgnoreCase("exit")) {
                System.out.println("Роботу програми закінчено");
                console.close();
                return;
            }
        }
    }

    private static void courseCase() {
        System.out.println(CATEGORY_COURSE);
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            CourseService courseService = new CourseService();
            courseService.createCourseByTerminal();
            System.out.println("Загальна кількість створених курсів: " + Course.getCounter());
        }
    }

    private static void teacherCase() {
        System.out.println(CATEGORY_TEACHER);
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            TeacherService teacherService = new TeacherService();
            teacherService.createTeacherByTerminal();
            System.out.println("Загальна кількість доданих вчителів: " + Teacher.getCounter());
        }
    }

    private static void studentCase() {
        System.out.println(CATEGORY_STUDENT);
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            StudentService studentService = new StudentService();
            studentService.createStudentByTerminal();
            System.out.println("Загальна кількість доданих студентів: " + Student.getCounter());
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

    private static void showObjects()   {
        System.out.println("Оберіть категорію, яку бажаєте переглянути:\n" +
                "1 - курси\n" +
                "2 - лекції\n" +
                "3 - вичтелі\n" +
                "4 - студенти");
        Scanner console = new Scanner(System.in);
        int category = console.nextInt();
        switch (category)   {
            case 1 -> CourseService.showCourses();
            case 2 -> LectureService.showLectures();
            case 3 -> TeacherService.showTeachers();
            case 4 -> StudentService.showStudents();
        }
    }

}

