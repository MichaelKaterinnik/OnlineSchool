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
        while (true) {
            if (console.hasNextLine())  {
                newStudent.setStudentFirstName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_STUDENT_SECOND_NAME);
        while (true) {
            if (console.hasNextLine())  {
                newStudent.setStudentSecondName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_SNAME_EXCEPTION);
            }
        }
        System.out.printf("Додано студента %s %s", newStudent.getStudentFirstName(), newStudent.getStudentSecondName());
        System.out.println();
        System.out.println(ENTER_ID);
        while (true) {
            if (console.hasNextInt())  {
                newStudent.setId(console.nextInt());
                System.out.printf("Ви присвоїли студенту %s %s ID під номером %d", newStudent.getStudentFirstName(), newStudent.getStudentSecondName(),
                        newStudent.getId());
                break;
            } else {
                System.out.println(ENTER_ID_EXCEPTION);
            }
        }
        System.out.println();
        return newStudent;
    }

}
