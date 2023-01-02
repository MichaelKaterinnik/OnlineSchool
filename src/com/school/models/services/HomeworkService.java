package com.school.models.services;

import com.school.models.Homework;
import com.school.models.repositories.HomeworkRepo;

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
        System.out.println(ENTER_HOMEWORK_NAME);
        while (true) {
            if (console.hasNextLine())  {
                newHomework.setHomeworkTask(console.nextLine()); // тут зробити реалізацію через підгрузку тексту завдань з файла
                break;
            } else {
                System.out.println(ENTER_HW_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_LECTURE_NUMBER);
        while (true) {
            if (console.hasNextInt())  {
                newHomework.setLectureID(console.nextInt());
                System.out.println("Ви присвоїли створене завдання лекції з ID №" + newHomework.getLectureID());
                break;
            } else {
                System.out.println(ENTER_LECTURE_NUMBER_EXCEPTION);
            }
        }
        HomeworkRepo.getInstance().add(newHomework);
    }

    public static void showHomeworks() {
        Homework[] result = Arrays.copyOf(HomeworkRepo.getAll(), HomeworkRepo.getAll().length);
        for (Homework homework : result) {
            System.out.println("ID наявного ДЗ: " + homework.getID());
        }
    }
}
