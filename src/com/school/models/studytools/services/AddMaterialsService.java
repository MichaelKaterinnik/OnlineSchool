package com.school.models.studytools.services;

import com.school.models.studytools.AdditionalMaterials;
import com.school.models.studytools.Homework;

import java.util.Scanner;

public class AddMaterialsService {
    private static final String ENTER_ADDMATERIALS_NAME = "Введіть тему додаткових матеріалів";
    private static final String ENTER_LECTURE_NUMBER = "Введіть лекцію (ID лекції), до якої належатиме матеріал";
    private static final String ENTER_AM_NAME_EXCEPTION = "Введіть тему матеріалу українською мовою,будь-ласка";
    private static final String ENTER_LECTURE_NUMBER_EXCEPTION = "Введіть номер існуючої лекції (ID), до якої належатиме матеріал";
    private static final String SAVE = "Зберегти зміни?\nВведіть 1, якщо так, або будь-яку клавішу - якщо ні";



    public AdditionalMaterials createAdditionalMaterials()  {
        return new AdditionalMaterials();
    }

    public AdditionalMaterials createHomeworkByTerminal()    {
        Scanner console = new Scanner(System.in);
        AddMaterialsService AddService = new AddMaterialsService();
        AdditionalMaterials newAddMaterials = AddService.createAdditionalMaterials();
        System.out.println(ENTER_ADDMATERIALS_NAME);
        boolean st1 = true;
        while (st1) {
            if (console.hasNextLine())  {
                newAddMaterials.setTopic(console.nextLine()); // тут зробити реалізацію через підгрузку тексту завдань з файла
                st1 = false;
            } else {
                System.out.println(ENTER_AM_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_LECTURE_NUMBER);
        boolean st2 = true;
        while (st2) {
            if (console.hasNextInt())  {
                newAddMaterials.setLectureID(console.nextInt());
                System.out.println("Ви присвоїли створене завдання лекції з ID №" + newAddMaterials.getLectureID());
                st2 = false;
            } else {
                System.out.println(ENTER_LECTURE_NUMBER_EXCEPTION);
            }
        }
        return newAddMaterials;
    }

}
