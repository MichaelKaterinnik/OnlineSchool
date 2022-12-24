package com.school.models.studytools.services;

import com.school.models.studytools.AdditionalMaterials;

import java.util.Arrays;
import java.util.Scanner;

public class AddMaterialsService {
    private static final String ENTER_ADDMATERIALS_NAME = "Введіть тему додаткових матеріалів";
    private static final String ENTER_LECTURE_NUMBER = "Введіть лекцію (ID лекції), до якої належатиме матеріал";
    private static final String ENTER_AM_NAME_EXCEPTION = "Введіть тему матеріалу українською мовою,будь-ласка";
    private static final String ENTER_LECTURE_NUMBER_EXCEPTION = "Введіть номер існуючої лекції (ID), до якої належатиме матеріал";


    public AdditionalMaterials createAdditionalMaterials()  {
        return new AdditionalMaterials();
    }

    public void createHomeworkByTerminal()    {
        Scanner console = new Scanner(System.in);
        AddMaterialsService AddService = new AddMaterialsService();
        AdditionalMaterials newAddMaterials = AddService.createAdditionalMaterials();
        System.out.println(ENTER_ADDMATERIALS_NAME);
        while (true) {
            if (console.hasNextLine())  {
                newAddMaterials.setTopic(console.nextLine()); // тут зробити реалізацію через підгрузку тексту завдань з файла
                break;
            } else {
                System.out.println(ENTER_AM_NAME_EXCEPTION);
            }
        }
        System.out.println(ENTER_LECTURE_NUMBER);
        while (true) {
            if (console.hasNextInt())  {
                newAddMaterials.setLectureID(console.nextInt());
                System.out.println("Ви присвоїли створене завдання лекції з ID №" + newAddMaterials.getLectureID());
                break;
            } else {
                System.out.println(ENTER_LECTURE_NUMBER_EXCEPTION);
            }
        }
        AddMatsRepo.add(newAddMaterials);
    }

    public static void showAddMaterials()  {
        AdditionalMaterials[] result = Arrays.copyOf(AddMatsRepo.getAddMatsRepository(), AddMatsRepo.getAddMatsRepository().length);
        for (AdditionalMaterials additionalMaterials : result) {
            System.out.println("ID наявних додаткових матеріалів: " + additionalMaterials.getId());
        }
    }
}
