package com.school.models.services;

import com.school.models.Lecture;
import com.school.models.Person;
import com.school.models.repositories.LectureRepo;
import com.school.models.repositories.PersonRepo;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class LectureService {
    private static final String ENTER_LECTURE_NAME = "Введіть тему нової лекції українською мовою";
    private static final String ENTER_COURSE_NUMBER = "Введіть курс (id ІСНУЮЧОГО курсу), до якого належатиме лекція";
    private static final String ENTER_LECTURE_NAME_EXCEPTION = "Введіть тему нової лекції українською мовою,будь-ласка";
    private static final String ENTER_COURSE_NUMBER_EXCEPTION = "Введіть номер існуючого курсу (ID курсу), до якого належатиме лекція, будь-ласка";
    private static final String ADD_TEACHER = "Ви бажаєте додати викладача лекції? Натисніть 1, якщо потрібно додати викладача, який вже є в базі або натисність 2, якщо потрібно також зареєструвати нового викладача";

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
        System.out.println(ADD_TEACHER);
        if (console.hasNextInt())    {
            int category = console.nextInt();
            switch (category)   {
                case 1: {
                    System.out.println("Введіть ID викладача, якого необхідно додати");
                    int teacherID = console.nextInt();
                    Person ourTeacher = PersonRepo.getInstance().getById(teacherID);
                    newLecture.setPersonID(teacherID);
                    newLecture.setTeacher(ourTeacher);
                }
                case 2: {
                    PersonService ps = new PersonService();
                    Person teacher = ps.createTeacherByTerminal();
                    newLecture.setPersonID(teacher.getId());
                    newLecture.setTeacher(teacher);
                    System.out.println("Викладача " + teacher.getPersonFirstName() + " " + teacher.getPersonSecondName() + " додано до лекції");
                }
            }
        }
        LectureRepo.getInstance().add(newLecture);
    }

    public static void showLectures()  {
        Lecture[] result = Arrays.copyOf(LectureRepo.getAll(), LectureRepo.getAll().length);
        for (Lecture lecture : result) {
            if (lecture != null) {
                System.out.println("ID наявної лекції: " + lecture.getId());
                System.out.println("Курс, до якого належить вищезазначена лекція: " + lecture.getCourseID());
                // System.out.println("Тема лекції: " + lecture.getLectureTopic());
                System.out.println("Викладач лекції: " + lecture.getTeacher().getPersonFirstName() + " " + lecture.getTeacher().getPersonSecondName());
                // System.out.println("ДЗ лекції: " + lecture.getHomework().getHomeworkTask());
                System.out.println("Додатковий матеріал лекції: " + lecture.getAddMaterial().getTopic());
            }
        }
        System.out.println(Arrays.toString(result));
    }

}
