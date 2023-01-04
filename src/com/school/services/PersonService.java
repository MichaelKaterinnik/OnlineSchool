package com.school.services;

import com.school.models.Person;
import com.school.models.Role;
import com.school.repositories.LectureRepo;
import com.school.repositories.PersonRepo;

import java.util.Arrays;
import java.util.Scanner;

public class PersonService {
    private static final String CHOOSE_ROLE = """
    Ви бажаєте додати викладача або студента?
    Оберіть роль:
    1 - викладач
    2 - студент""";
    private static final String ENTER_PERSON_FIRST_NAME = "Введіть ім'я українською мовою:";
    private static final String ENTER_PERSON_SECOND_NAME = "Введіть прізвище українською мовою:";
    private static final String ENTER_PHONE = "Введіть контактний номер телефону у форматі +380-ХХ-ХХХ-ХХ-ХХ або натисніть 1, якщо визначите номер пізніше:";
    private static final String ENTER_EMAIL = "Введіть латиницею контактну адресу електронної пошти або натисніть 1, якщо визначите номер пізніше:";
    private static final String ROLE_EXCEPTION = "Введіть одне з двох чисел, будь-ласка";
    private static final String ENTER_NAME_EXCEPTION = "Введіть ім'я українською мовою,будь-ласка";
    private static final String ENTER_SNAME_EXCEPTION = "Введіть прізвище українською мовою,будь-ласка";
    private static final String ENTER_PHONE_EXCEPTION = """
    Потрібно ввести номер за інструкцією, у форматі +380-ХХ-ХХХ-ХХ-ХХ.
    Введіть номер повторно або введіть 1, якщо визначите номер пізніше:""";
    private static final String ENTER_EMAIL_EXCEPTION = """
    Введіть валідну адресу електронної пошти
    Введіть адресу повторно або введіть 1, якщо визначите адресу пошти пізніше:""";


    public Person createPerson(Role role, String firstName, String secondName)  {
        return new Person(role, firstName, secondName);
    }
    public Person createPerson()  {
        return new Person();
    }

    public static Person createTeacherByTerminal()   {
        PersonService personService = new PersonService();
        Person newTeacher = personService.createPerson();
        newTeacher.setRole(Role.TEACHER);
        personService.defineFirstName(newTeacher);
        personService.defineLastName(newTeacher);
        personService.definePhone(newTeacher);
        personService.defineEmail(newTeacher);
        System.out.println("Додано викладача " + newTeacher.getPersonFirstName() + " " + newTeacher.getPersonLastName());
        PersonRepo.getInstance().add(newTeacher);
        return newTeacher;
    }

    public static Person createStudentByTerminal()   {
        PersonService personService = new PersonService();
        Person newStudent = personService.createPerson();
        newStudent.setRole(Role.STUDENT);
        personService.defineFirstName(newStudent);
        personService.defineLastName(newStudent);
        personService.definePhone(newStudent);
        personService.defineEmail(newStudent);
        System.out.println("Додано студента " + newStudent.getPersonFirstName() + " " + newStudent.getPersonLastName());
        PersonRepo.getInstance().add(newStudent);
        return newStudent;
    }

    public static void createPersonByTerminal()    {
        PersonService personService = new PersonService();
        Person newPerson = personService.createPerson();
        personService.defineRole(newPerson);
        personService.defineFirstName(newPerson);
        personService.defineLastName(newPerson);
        personService.definePhone(newPerson);
        personService.defineEmail(newPerson);
        if (newPerson.getRole() == Role.TEACHER)    {
            System.out.printf("Додано викладача " + newPerson.getPersonFirstName() + " " + newPerson.getPersonLastName());
        } else  {
            System.out.println("Додано студента " + newPerson.getPersonFirstName() + " " + newPerson.getPersonLastName());
        }
        System.out.println();
        PersonRepo.getInstance().add(newPerson);
    }

    public static void addTeacherToExistingLecture()    {
        System.out.println("Бажаєте додати викладача до однієї з лекцій?\nНатисніть 1, якщо бажаєте додати вже зареєстровного викладача або натисніть 2, якщо необхідно додати нового викладача");
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt() && console.nextInt() == 1) {
            int lectureID = LectureService.choosingLectureID();
            if (lectureID == 0)   {
                System.out.println("Ви ввели невалідний ID лекції");
            } else {
                System.out.println("Введіть ID викладача, якого необхідно додати");
                int teacherID = choosingTeacherID();
                if (teacherID == 0) {
                    System.out.println("Ви ввели невалідний ID викладача");
                } else {
                    LectureRepo.getInstance().getById(lectureID).setPersonID(teacherID);
                    LectureRepo.getInstance().getById(lectureID).setTeacher(PersonRepo.getInstance().getById(teacherID));
                }
            }
        } else if (console.hasNextInt() && console.nextInt() == 2)  {
            PersonService.addNewTeacherToLecture();
        }
        console.close();
    }

    public static void addNewTeacherToLecture()    {
        Person teacher = createTeacherByTerminal();
        int data = teacher.getId();
        int lectureID = LectureService.choosingLectureID();
        if (lectureID == 0) {
            System.out.println("Введено некоректне значення ID лекції");
        } else {
            LectureRepo.getInstance().getById(lectureID).setPersonID(data);
            LectureRepo.getInstance().getById(lectureID).setTeacher(teacher);
        }
        System.out.println("Лекції " + LectureRepo.getInstance().getById(lectureID).getLectureName() + " присвоєно викладача " + teacher.getPersonFirstName() + " " + teacher.getPersonLastName());
    }

    public static void showStudents()  {
        Person[] result = Arrays.copyOf(PersonRepo.getAll(), PersonRepo.getAll().length);
        for (Person person : result)  {
            if (person.getRole() == Role.STUDENT)   {
                System.out.println("ID наявного у базі студента: " + person.getId());
                System.out.println("Прізвище та ім'я вищезазначеного студента: " + person.getPersonFirstName() + " " + person.getPersonLastName());
            }
        }
    }

    public static void showTeachers()  {
        Person[] result = Arrays.copyOf(PersonRepo.getAll(), PersonRepo.getAll().length);
        for (Person person : result)  {
            if (person.getRole() == Role.TEACHER)   {
                System.out.println("ID наявного у базі викладача: " + person.getId());
                System.out.println("Прізвище та ім'я вищезазначеного викладача: " + person.getPersonFirstName() + " " + person.getPersonLastName());
            }
        }
    }

    public static void showAllPeople() {
        Person[] result = Arrays.copyOf(PersonRepo.getAll(), PersonRepo.getAll().length);
        for (Person person : result) {
            System.out.println("ID наявних у базі осіб: " + person.getId());
            System.out.println("Прізвище та ім'я вищезазначеної особи: " + person.getPersonFirstName() + " " + person.getPersonLastName());
        }
    }

    public static int choosingTeacherID() {
        System.out.println("Введіть id ЗАРЕЄСТРОВАНОГО викладача, якого необхідно додати до обраної Вами лекції:");
        Scanner console = new Scanner(System.in);
        int id = 0;
        for (Person teacher : PersonRepo.getAll()) {
            if (teacher.getRole() == Role.TEACHER && console.nextInt() == teacher.getId()) {
                id = console.nextInt();
                break;
            }
        }
        return id;
    }

    private void defineRole(Person person)  {
        Scanner console = new Scanner(System.in);
        System.out.println(CHOOSE_ROLE);
        while (true) {
            if (console.hasNextInt())   {
                if (console.nextInt() == 1) {
                    person.setRole(Role.TEACHER);
                    break;
                } else if (console.nextInt() == 2) {
                    person.setRole(Role.STUDENT);
                    break;
                } else {
                    System.out.println(ROLE_EXCEPTION);
                }
            } else {
                System.out.println(ROLE_EXCEPTION);
            }
        }
        console.close();
    }

    private void defineFirstName(Person person) {
        Scanner console = new Scanner(System.in);
        System.out.println(ENTER_PERSON_FIRST_NAME);
        while (true) {
            if (console.hasNext("[а-яА-Я]+"))  {
                person.setPersonFirstName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_NAME_EXCEPTION);
            }
        }
        console.close();
    }

    private void defineLastName(Person person) {
        Scanner console = new Scanner(System.in);
        System.out.println(ENTER_PERSON_SECOND_NAME);
        while (true) {
            if (console.hasNext("[а-яА-Я]+"))  {
                person.setPersonLastName(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_NAME_EXCEPTION);
            }
        }
        console.close();
    }

    private void definePhone(Person person) {
        Scanner console = new Scanner(System.in);
        System.out.println(ENTER_PHONE);
        while (true)    {
            if (console.hasNextInt() && console.nextInt() == 1)  {
                break;
            } else if (console.hasNext("^\\+38\\(0\\d{2}\\)\\s\\d{3}\\s\\d{2}\\s\\d{2}$"))    {
                person.setPhone((console.nextLine()));
                break;
            } else {
                System.out.println(ENTER_PHONE_EXCEPTION);
            }
        }
        console.close();
    }

    private void defineEmail(Person person) {
        Scanner console = new Scanner(System.in);
        System.out.println(ENTER_EMAIL);
        while (true)    {
            if (console.hasNextInt() && console.nextInt() == 1)  {
                break;
            } else if (console.hasNext("^([\\S\\d]+)@(\\S+)[.](\\S+.?\\S+)$\n"))    {
                person.setEmail(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_PHONE_EXCEPTION);
            }
        }
        console.close();
    }
}
