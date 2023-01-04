package com.school.services;

import com.school.models.AdditionalMaterials;
import com.school.repositories.AddMatsRepo;

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
        AddMaterialsService addService = new AddMaterialsService();
        AdditionalMaterials newAddMaterials = addService.createAdditionalMaterials();
        addService.defineAddMaterialsName(newAddMaterials);
        addService.defineAddMaterialsLecture(newAddMaterials);
        AddMatsRepo.getInstance().add(newAddMaterials);
        console.close();

    }

    public static void showAddMaterials()  {
        AdditionalMaterials[] result = Arrays.copyOf(AddMatsRepo.getAll(), AddMatsRepo.getAll().length);
        for (AdditionalMaterials additionalMaterials : result) {
            System.out.println("ID наявних додаткових матеріалів: " + additionalMaterials.getId());
        }
    }

    private void defineAddMaterialsName(AdditionalMaterials materials)  {
        Scanner console = new Scanner(System.in);
        System.out.println(ENTER_ADDMATERIALS_NAME);
        while (true) {
            if (console.hasNextLine())  {
                materials.setName(console.nextLine()); // тут зробити реалізацію через підгрузку тексту завдань з файла
                break;
            } else {
                System.out.println(ENTER_AM_NAME_EXCEPTION);
            }
        }
        console.close();
    }

    private void defineAddMaterialsLecture(AdditionalMaterials materials)  {
        Scanner console = new Scanner(System.in);
        System.out.println(ENTER_LECTURE_NUMBER);
        while (true) {
            if (console.hasNextInt())  {
                materials.setLectureID(console.nextInt());
                System.out.println("Ви присвоїли створене завдання лекції з ID №" + materials.getLectureID());
                break;
            } else {
                System.out.println(ENTER_LECTURE_NUMBER_EXCEPTION);
            }
        }
        console.close();
    }
}
