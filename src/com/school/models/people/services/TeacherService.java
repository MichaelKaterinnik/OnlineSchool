package com.school.models.people.services;

import com.school.models.people.Teacher;

import java.util.Arrays;
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

    public void createTeacherByTerminal()    {
        Scanner console = new Scanner(System.in);
        TeacherService teacherService = new TeacherService();
        Teacher newTeacher = teacherService.createTeacher();
        System.out.println(ENTER_TEACHER_FIRST_NAME);
        while (true) {
            if (console.hasNext("[а-я]+"))  {
                newTeacher.setTeacherFirstName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_TEACHER_SECOND_NAME);
        while (true) {
            if (console.hasNext("[а-я]+"))  {
                newTeacher.setTeacherSecondName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_SNAME_EXCEPTION);
            }
        }
        System.out.println("Додано вчителя " + newTeacher.getTeacherFirstName() + " " + newTeacher.getTeacherSecondName());
        System.out.println();
        System.out.println(ENTER_ID);
        while (true) {
            if (console.hasNextInt())  {
                newTeacher.setId(console.nextInt());
                System.out.printf("Ви присвоїли вчителю %s %s ID під номером %d", newTeacher.getTeacherFirstName(), newTeacher.getTeacherSecondName(), newTeacher.getId());
                break;
            } else {
                System.out.println(ENTER_ID_EXCEPTION);
            }
        }
        TeacherRepo.add(newTeacher);
    }

    public static void showTeachers()  {
        Teacher[] result = Arrays.copyOf(TeacherRepo.getTeachersRepository(), TeacherRepo.getTeachersRepository().length);
        for (Teacher teacher : result) {
            System.out.println("ID наявного у базі вчителя: " + teacher.getId());
        }
    }
}
