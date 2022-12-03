package com.school.models.studytools.services;

import com.school.models.studytools.Homework;
import com.school.models.studytools.Lecture;

import java.util.Scanner;

public class HomeworkService {
    private static final String ENTER_HOMEWORK_NAME = "Введіть тему домашньго завдання українською мовою";
    private static final String ENTER_LECTURE_NUMBER = "Введіть лекцію (ID лекції), до якої належатиме домашнє завдання";
    private static final String ENTER_HW_NAME_EXCEPTION = "Введіть тему домашньгго завдання українською мовою,будь-ласка";
    private static final String ENTER_LECTURE_NUMBER_EXCEPTION = "Введіть номер існуючої лекції (ID), до якої належатиме домашнє завдання";
    private static final String SAVE = "Зберегти зміни?\nВведіть 1, якщо так, або будь-яку клавішу - якщо ні";


    public Homework createHomework()    {
        return new Homework();
    }

    public Homework createHomeworkByTerminal()    {
        Scanner console = new Scanner(System.in);
        HomeworkService hwService = new HomeworkService();
        Homework newHomework = hwService.createHomework();
        System.out.println(ENTER_HOMEWORK_NAME);
        boolean st1 = true;
        while (st1) {
            if (console.hasNextLine())  {
                newHomework.setHomeworkTask(console.nextLine()); // тут зробити реалізацію через підгрузку тексту завдань з файла
                st1 = false;
            } else {
                System.out.println(ENTER_HW_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_LECTURE_NUMBER);
        boolean st2 = true;
        while (st2) {
            if (console.hasNextInt())  {
                newHomework.setLectureID(console.nextInt());
                System.out.println("Ви присвоїли створене завдання лекції з ID №" + newHomework.getLectureID());
                st2 = false;
            } else {
                System.out.println(ENTER_LECTURE_NUMBER_EXCEPTION);
            }
        }
        return newHomework;
    }
}
