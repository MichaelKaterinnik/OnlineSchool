package com.school.models.people.services;

import com.school.models.people.Student;
import com.school.models.people.Teacher;

import java.util.Scanner;

public class StudentService {
    private static final String ENTER_STUDENT_FIRST_NAME = "Введіть ім'я студента українською мовою";
    private static final String ENTER_STUDENT_SECOND_NAME = "Введіть прізвище студента українською мовою";
    private static final String ENTER_ID = "Введіть унікальний номер (ID) студента";
    private static final String ENTER_NAME_EXCEPTION = "Введіть ім'я студента українською мовою,будь-ласка";
    private static final String ENTER_SNAME_EXCEPTION = "Введіть прізвище студента українською мовою,будь-ласка";

    private static final String ENTER_ID_EXCEPTION = "Введіть ID студента, будь-ласка";


    public Student createStudent(String firstName, String secondName)  {
        return new Student(firstName, secondName);
    }
    public Student createStudent()  {
        return new Student();
    }

    public Student createStudentByTerminal()    {
        Scanner console = new Scanner(System.in);
        StudentService studentService = new StudentService();
        Student newStudent = studentService.createStudent();
        System.out.println(ENTER_STUDENT_FIRST_NAME);
        boolean st1 = true;
        while (st1) {
            if (console.hasNextLine())  {
                newStudent.setStudentFirstName(console.nextLine());
                st1 = false;
            } else {
                System.out.println(ENTER_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_STUDENT_SECOND_NAME);
        boolean st2 = true;
        while (st2) {
            if (console.hasNextLine())  {
                newStudent.setStudentSecondName(console.nextLine());
                st2 = false;
            } else {
                System.out.println(ENTER_SNAME_EXCEPTION);
            }
        }
        System.out.printf("Додано студента %s %s", newStudent.getStudentFirstName(), newStudent.getStudentSecondName());
        System.out.println(ENTER_ID);
        boolean st3 = true;
        while (st3) {
            if (console.hasNextInt())  {
                newStudent.setId(console.nextInt());
                System.out.printf("Ви присвоїли студенту %s %s ID під номером %d", newStudent.getStudentFirstName(), newStudent.getStudentSecondName(),
                        newStudent.getId());
                st3 = false;
            } else {
                System.out.println(ENTER_ID_EXCEPTION);
            }
        }
        return newStudent;
    }

}
