package com.school;

import com.school.models.Person;
import com.school.models.Role;
import com.school.repositories.PersonRepo;
import com.school.services.PersonService;
import com.school.models.Course;
import com.school.models.Lecture;
import com.school.services.CourseService;
import com.school.services.LectureService;

import java.util.Scanner;

public class MainService {
    // поля:
    private final static String CATEGORY_CHANGER = """
    Оберіть категорію:
    1 - курс
    2 - викладачі
    3 - студенти
    4 - лекції
    5 - переглянути створені об'єкти
    Введіть потрібне число з 5-ти або введіть exit щоб вийти з програми""";
    private final static String CATEGORY_COURSE = """
    Ви знаходитесь у категорії вибору курсу. Чи бажаєте Ви додати новий курс?
    Введіть число 1, якщо так:""";
    private final static String CATEGORY_TEACHER = """
    Ви знаходитесь у категорії вибору викладачів. Чи бажаєте Ви додати нового викладача?
    Введіть число 1, якщо так:""";
    private final static String CATEGORY_STUDENT = """
    Ви знаходитесь у категорії вибору студентів. Чи бажаєте Ви додати нового студента?
    Введіть число 1, якщо так:""";
    private final static String CATEGORY_LECTURE = """
    Ви знаходитесь у категорії вибору лекцій. Чи бажаєте Ви додати нову лекцію?
    Введіть число 1, якщо так.
    УВАГА! Нову лекцію можливо створити за наявності хоча б одного зареєстрованого курсу!""";
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
        CourseService.createCourseByTerminal();
        System.out.println("Початковий курс створено. Тепер додамо до нього 3 лекції");
        LectureService.createLectureByTerminal();
        LectureService.createLectureByTerminal();
        LectureService.createLectureByTerminal();
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
                    case 4 -> lectureCase();
                    case 5 -> showObjects();
                    default -> System.out.println(CHANGER_EXCEPTION);
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
            CourseService.createCourseByTerminal();
            System.out.println("Загальна кількість створених курсів: " + Course.getCounter());
        }
        console.close();
    }

    private static void teacherCase() {
        System.out.println(CATEGORY_TEACHER);
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            PersonService.createTeacherByTerminal();
            int counter = 0;
            for (Person person : PersonRepo.getAll())   {
                if (person.getRole() == Role.TEACHER)   {
                    counter++;
                }
            }
            System.out.println("Загальна кількість доданих викладачів: " + counter);
        }
        console.close();
    }

    private static void studentCase() {
        System.out.println(CATEGORY_STUDENT);
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            PersonService.createStudentByTerminal();
            int counter = 0;
            for (Person person : PersonRepo.getAll())   {
                if (person.getRole() == Role.STUDENT)   {
                    counter++;
                }
            }
            System.out.println("Загальна кількість доданих студентів: " + counter);
        }        console.close();

    }

    private static void lectureCase() {
        System.out.println(CATEGORY_LECTURE);
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            LectureService.createLectureByTerminal();
            System.out.println("Загальна кількість створених лекцій: " + Lecture.getCounter());
        }
        console.close();
    }

    private static void showObjects()   {
        System.out.println("Оберіть категорію, яку бажаєте переглянути:\n" +
                "1 - курси\n" +
                "2 - лекції\n" +
                "3 - викладачі\n" +
                "4 - студенти");
        Scanner console = new Scanner(System.in);
        int category = console.nextInt();
        switch (category)   {
            case 1 -> CourseService.showCourses();
            case 2 -> {
                LectureService.showLectures();
                PersonService.addTeacherToExistingLecture();
            }
            case 3 -> PersonService.showTeachers();
            case 4 -> PersonService.showStudents();
            default -> System.out.println();
        }
        console.close();
    }


}

