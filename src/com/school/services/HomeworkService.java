package com.school.services;

import com.school.models.Homework;
import com.school.repositories.HomeworkRepo;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkService {
    private static final String ENTER_HOMEWORK_NAME = "Введіть тему домашньго завдання українською мовою";
    private static final String ENTER_LECTURE_NUMBER = "Введіть лекцію (ID лекції), до якої належатиме домашнє завдання";
    private static final String ENTER_HW_NAME_EXCEPTION = "Введіть тему домашньгго завдання українською мовою,будь-ласка";
    private static final String ENTER_LECTURE_NUMBER_EXCEPTION = "Введіть номер існуючої лекції (ID), до якої належатиме домашнє завдання";

    public Homework createHomework()    {
        return new Homework();
    }

    public void createHomeworkByTerminal()    {
        Scanner console = new Scanner(System.in);
        HomeworkService hwService = new HomeworkService();
        Homework newHomework = hwService.createHomework();
        hwService.defineHomeworkTask(newHomework);
        hwService.defineLecture(newHomework);
        HomeworkRepo.getInstance().add(newHomework);
        console.close();

    }

    public static void showHomeworks() {
        Homework[] result = Arrays.copyOf(HomeworkRepo.getAll(), HomeworkRepo.getAll().length);
        for (Homework homework : result) {
            System.out.println("ID наявного ДЗ: " + homework.getID());
        }
    }

    private void defineHomeworkTask(Homework homework)  {
        Scanner console = new Scanner(System.in);
        System.out.println(ENTER_HOMEWORK_NAME);
        while (true) {
            if (console.hasNextLine())  {
                homework.setHomeworkTask(console.nextLine());
                break;
            } else {
                System.out.println(ENTER_HW_NAME_EXCEPTION);
            }
        }
        console.close();
    }

    private void defineLecture(Homework homework)  {
        Scanner console = new Scanner(System.in);
        System.out.println(ENTER_LECTURE_NUMBER);
        while (true) {
            if (console.hasNextInt())  {
                homework.setLectureID(console.nextInt());
                System.out.println("Ви присвоїли створене завдання лекції з ID №" + homework.getLectureID());
                break;
            } else {
                System.out.println(ENTER_LECTURE_NUMBER_EXCEPTION);
            }
        }
        console.close();
    }
}
