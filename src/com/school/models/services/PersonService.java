package com.school.models.services;

import com.school.models.Person;
import com.school.models.Role;
import com.school.models.repositories.PersonRepo;

import java.util.Arrays;
import java.util.Scanner;

public class PersonService {
    private static final String CHOOSE_ROLE = "Ви бажаєте додати викладача або студента?\nОберіть роль:\n1 - викладач\n2 - студент";
    private static final String ROLE_EXCEPTION = "Введіть одне з двох чисел, будь-ласка";
    private static final String ENTER_PERSON_FIRST_NAME = "Введіть ім'я українською мовою";
    private static final String ENTER_PERSON_SECOND_NAME = "Введіть прізвище українською мовою";
    private static final String ENTER_TEACHER_FIRST_NAME = "Введіть ім'я викладача українською мовою";
    private static final String ENTER_TEACHER_SECOND_NAME = "Введіть прізвище викладача українською мовою";
    private static final String ENTER_STUDENT_FIRST_NAME = "Введіть ім'я студента українською мовою";
    private static final String ENTER_STUDENT_SECOND_NAME = "Введіть прізвище студента українською мовою";
    private static final String ENTER_NAME_EXCEPTION = "Введіть ім'я українською мовою,будь-ласка";
    private static final String ENTER_SNAME_EXCEPTION = "Введіть прізвище українською мовою,будь-ласка";


    public Person createPerson(Role role, String firstName, String secondName)  {
        return new Person(role, firstName, secondName);
    }
    public Person createPerson()  {
        return new Person();
    }

    public void createTeacherByTerminal()   {
        Scanner console = new Scanner(System.in);
        PersonService personService = new PersonService();
        Person newPerson = personService.createPerson();
        newPerson.setRole(Role.TEACHER);
        System.out.println(ENTER_TEACHER_FIRST_NAME);
        while (true) {
            if (console.hasNext("[а-я]+"))  {
                newPerson.setPersonFirstName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_TEACHER_SECOND_NAME);
        while (true) {
            if (console.hasNext("[а-я]+"))  {
                newPerson.setPersonSecondName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_SNAME_EXCEPTION);
            }
        }
        System.out.println("Додано викладача " + newPerson.getPersonFirstName() + " " + newPerson.getPersonSecondName());
        PersonRepo.getInstance().add(newPerson);
    }

    public void createStudentByTerminal()   {
        Scanner console = new Scanner(System.in);
        PersonService personService = new PersonService();
        Person newPerson = personService.createPerson();
        newPerson.setRole(Role.STUDENT);
        System.out.println(ENTER_STUDENT_FIRST_NAME);
        while (true) {
            if (console.hasNext("[а-я]+"))  {
                newPerson.setPersonFirstName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_STUDENT_SECOND_NAME);
        while (true) {
            if (console.hasNext("[а-я]+"))  {
                newPerson.setPersonSecondName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_SNAME_EXCEPTION);
            }
        }
        System.out.println("Додано студента " + newPerson.getPersonFirstName() + " " + newPerson.getPersonSecondName());
        PersonRepo.getInstance().add(newPerson);
    }

    public void createPersonByTerminal()    {
        Scanner console = new Scanner(System.in);
        PersonService personService = new PersonService();
        Person newPerson = personService.createPerson();
        System.out.println(CHOOSE_ROLE);
        while (true) {
            if (console.hasNextInt())   {
                if (console.nextInt() == 1) {
                    newPerson.setRole(Role.TEACHER);
                    break;
                } else if (console.nextInt() == 2) {
                    newPerson.setRole(Role.STUDENT);
                    break;
                } else {
                    System.out.println(ROLE_EXCEPTION);
                }
            } else {
                System.out.println(ROLE_EXCEPTION);
            }
        }
        System.out.println(ENTER_PERSON_FIRST_NAME);
        while (true) {
            if (console.hasNext("[а-я]+"))  {
                newPerson.setPersonFirstName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_PERSON_SECOND_NAME);
        while (true) {
            if (console.hasNext("[а-я]+"))  {
                newPerson.setPersonSecondName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_SNAME_EXCEPTION);
            }
        }
        if (newPerson.getRole() == Role.TEACHER)    {
            System.out.printf("Додано викладача " + newPerson.getPersonFirstName() + " " + newPerson.getPersonSecondName());
        } else  {
            System.out.println("Додано студента " + newPerson.getPersonFirstName() + " " + newPerson.getPersonSecondName());
        }
        System.out.println();
        PersonRepo.getInstance().add(newPerson);
    }

    public static void showStudents()  {
        Person[] result = Arrays.copyOf(PersonRepo.getAll(), PersonRepo.getAll().length);
        for (Person person : result)  {
            if (person.getRole() == Role.STUDENT)   {
                System.out.println("ID наявного у базі студента: " + person.getId());
            }
        }
    }

    public static void showTeachers()  {
        Person[] result = Arrays.copyOf(PersonRepo.getAll(), PersonRepo.getAll().length);
        for (Person person : result)  {
            if (person.getRole() == Role.TEACHER)   {
                System.out.println("ID наявного у базі викладача: " + person.getId());
            }
        }
    }

    public static void showAllPeople() {
        Person[] result = Arrays.copyOf(PersonRepo.getAll(), PersonRepo.getAll().length);
        for (Person person : result) {
            System.out.println("ID наявних у базі осіб: " + person.getId());
        }
    }

}
