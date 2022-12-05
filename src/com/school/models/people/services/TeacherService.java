package com.school.models.people.services;

import com.school.models.people.Teacher;
import com.school.models.studytools.Lecture;
import com.school.models.studytools.services.LectureService;

import java.util.Scanner;

public class TeacherService {
    private static final String ENTER_TEACHER_FIRST_NAME = "Введіть Ім'я вчителя українською мовою";
    private static final String ENTER_TEACHER_SECOND_NAME = "Введіть прізвище вчителя українською мовою";
    private static final String ENTER_ID = "Введіть унікальний номер (ID) вчителя";
    private static final String ENTER_NAME_EXCEPTION = "Введіть ім'я українською мовою,будь-ласка";
    private static final String ENTER_SNAME_EXCEPTION = "Введіть прізвище українською мовою,будь-ласка";

    private static final String ENTER_ID_EXCEPTION = "Введіть ID вчителя, будь-ласка";


    public Teacher createTeacher(String firstName, String secondName)  {
        return new Teacher(firstName, secondName);
    }
    public Teacher createTeacher()  {
        return new Teacher();
    }

    public Teacher createTeacherByTerminal()    {
        Scanner console = new Scanner(System.in);
        TeacherService teacherService = new TeacherService();
        Teacher newTeacher = teacherService.createTeacher();
        System.out.println(ENTER_TEACHER_FIRST_NAME);
        boolean st1 = true;
        while (st1) {
            if (console.hasNextLine())  {
                newTeacher.setTeacherFirstName(console.nextLine());
                st1 = false;
            } else {
                System.out.println(ENTER_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_TEACHER_SECOND_NAME);
        boolean st2 = true;
        while (st2) {
            if (console.hasNextLine())  {
                newTeacher.setTeacherSecondName(console.nextLine());
                st2 = false;
            } else {
                System.out.println(ENTER_SNAME_EXCEPTION);
            }
        }
        System.out.println("Додано вчителя" + newTeacher.getTeacherFirstName() + " " + newTeacher.getTeacherSecondName());
        System.out.println(ENTER_ID);
        boolean st3 = true;
        while (st3) {
            if (console.hasNextInt())  {
                newTeacher.setId(console.nextInt());
                System.out.printf("Ви присвоїли вчителю %s %s ID під номером %d", newTeacher.getTeacherFirstName(), newTeacher.getTeacherSecondName(), newTeacher.getId());
                st3 = false;
            } else {
                System.out.println(ENTER_ID_EXCEPTION);
            }
        }
        return newTeacher;
    }

}
