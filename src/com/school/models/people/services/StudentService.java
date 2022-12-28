package com.school.models.people.services;

import com.school.models.people.Student;

import java.util.Arrays;
import java.util.Scanner;

public class StudentService {
    private static final String ENTER_STUDENT_FIRST_NAME = "Введіть ім'я студента українською мовою";
    private static final String ENTER_STUDENT_SECOND_NAME = "Введіть прізвище студента українською мовою";
    private static final String ENTER_NAME_EXCEPTION = "Введіть ім'я студента українською мовою,будь-ласка";
    private static final String ENTER_SNAME_EXCEPTION = "Введіть прізвище студента українською мовою,будь-ласка";


    public Student createStudent(String firstName, String secondName)  {
        return new Student(firstName, secondName);
    }
    public Student createStudent()  {
        return new Student();
    }

    public void createStudentByTerminal()    {
        Scanner console = new Scanner(System.in);
        StudentService studentService = new StudentService();
        Student newStudent = studentService.createStudent();
        System.out.println(ENTER_STUDENT_FIRST_NAME);
        while (true) {
            if (console.hasNext("[а-я]+"))  {
                newStudent.setStudentFirstName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_STUDENT_SECOND_NAME);
        while (true) {
            if (console.hasNext("[а-я]+"))  {
                newStudent.setStudentSecondName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_SNAME_EXCEPTION);
            }
        }
        System.out.printf("Додано студента " + newStudent.getStudentFirstName() + " " + newStudent.getStudentSecondName());
        System.out.println();
       StudentRepo.getInstance().add(newStudent);
    }

    public static void showStudents()  {
        Student[] result = Arrays.copyOf(StudentRepo.getAll(), StudentRepo.getAll().length);
        for (Student student : result)  {
            System.out.println("ID наявного у базі студента: " + student.getId());
        }
    }
}
