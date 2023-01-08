package com.school.services;

import com.school.models.Course;
import com.school.models.Lecture;
import com.school.models.Person;
import com.school.repositories.CourseRepo;
import com.school.repositories.LectureRepo;
import com.school.repositories.PersonRepo;

import java.util.Arrays;
import java.util.Scanner;

public class LectureService {
    private static final String ENTER_LECTURE_NAME = "Введіть тему нової лекції українською мовою:";
    private static final String ENTER_DESCRIPTION = "Опишіть зміст лекції:";
    private static final String ENTER_COURSE_NUMBER = "Введіть курс (id ІСНУЮЧОГО курсу), до якого належатиме лекція:";
    private static final String ENTER_LECTURE_NAME_EXCEPTION = "Введіть тему нової лекції українською мовою,будь-ласка:";
    private static final String ENTER_DESCRIPTION_EXCEPTION = "Опишіть зміст лекції українською мовою, будь-ласка:";
    private static final String ADD_TEACHER = "Ви бажаєте додати викладача лекції? Натисніть 1, якщо потрібно додати викладача, який вже є в базі або натисність 2, якщо потрібно зареєструвати нового викладача";

    public Lecture createLecture()  {
        return new Lecture();
    }

    public static void createLectureByTerminal()    {
        Scanner console = new Scanner(System.in);
        LectureService lectureService = new LectureService();
        Lecture newLecture = lectureService.createLecture();
        lectureService.defineLectureName(newLecture);
        lectureService.defineLectureDescription(newLecture);
        int ourID = choosingCourseID();
        if (ourID != 0) {
            newLecture.setCourseID(ourID);
            System.out.println("Ви присвоїли створену лекцію курсу з номером (ID)" + newLecture.getCourseID());
        } else {
            System.out.println("Ви ввели невалідний ID курсу. Вам необхідно буде присвоїти даній лекції ID належного курсу пізніше");
        }
        //
        // ДОДАТИ потім ралізацію відкладеного присвоєння лекції ID курсу
        //
        lectureService.defineTeacher(newLecture);
        LectureRepo.getInstance().addLecture(newLecture);
        console.close();

    }

    public static void showLectures()  {
        Lecture[] result = Arrays.copyOf(LectureRepo.getAll(), LectureRepo.getAll().length);
        for (Lecture lecture : result) {
            if (lecture != null) {
                System.out.println("ID наявної лекції: " + lecture.getId());
                System.out.println("Курс, до якого належить вищезазначена лекція: " + lecture.getCourseID());
                System.out.println("Тема лекції: " + lecture.getLectureName());
                System.out.println("Зміст лекції: " + lecture.getLectureDescription());
                System.out.println("Викладач лекції: " + lecture.getTeacher().getPersonFirstName() + " " + lecture.getTeacher().getPersonLastName());
                System.out.println("ДЗ лекції: " + lecture.getHomework().getHomeworkTask());
                System.out.println("Додатковий матеріал лекції: " + lecture.getAddMaterial().getName());
            }
        }
    }

    public static int choosingLectureID() {
        System.out.println("Введіть лекцію (id ЗАРЕЄСТРОВАНОЇ лекції), у яку необхідно додати викладача:");
        Scanner console = new Scanner(System.in);
        int id = 0;
        for (Lecture lecture : LectureRepo.getAll()) {
            if (console.nextInt() == lecture.getId()) {
                id = console.nextInt();
                break;
            }
        }
        console.close();
        return id;
    }

    private static int choosingCourseID() {
        System.out.println(ENTER_COURSE_NUMBER);
        Scanner console = new Scanner(System.in);
        int id = 0;
        for (Course course : CourseRepo.getAll()) {
            if (console.nextInt() == course.getID()) {
                id = console.nextInt();
                break;
            }
        }
        console.close();
        return id;
    }

    private void defineLectureName(Lecture lecture) {
        Scanner console = new Scanner(System.in);
        System.out.println(ENTER_LECTURE_NAME);
        while (true) {
            if (console.hasNext("[а-яА-Я0-1]+"))  {
                lecture.setLectureName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_LECTURE_NAME_EXCEPTION);
            }
        }
        console.close();
    }

    private void defineLectureDescription(Lecture lecture)  {
        Scanner console = new Scanner(System.in);
        System.out.println(ENTER_DESCRIPTION);
        while (true) {
            if (console.hasNext("[а-яА-Я0-1]+"))  {
                lecture.setLectureDescription(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_DESCRIPTION_EXCEPTION);
            }
        }
        console.close();
    }

    private void defineTeacher(Lecture lecture) {
        Scanner console = new Scanner(System.in);
        System.out.println(ADD_TEACHER);
        if (console.hasNextInt() && (console.nextInt() == 1)) {
            System.out.println("Введіть ID викладача, якого необхідно додати");
            int teacherID = console.nextInt();
            Person ourTeacher = PersonRepo.getInstance().getById(teacherID);
            lecture.setPersonID(teacherID);
            lecture.setTeacher(ourTeacher);
        } else if (console.nextInt() == 2) {
            Person teacher = PersonService.createTeacherByTerminal();
            lecture.setPersonID(teacher.getId());
            lecture.setTeacher(teacher);
            System.out.println("Викладача " + teacher.getPersonFirstName() + " " + teacher.getPersonLastName() + " додано до лекції");
        }
        console.close();
    }

}
