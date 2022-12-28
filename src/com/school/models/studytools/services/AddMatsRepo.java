package com.school.models.studytools.services;

import com.school.models.SuperRepo;
import com.school.models.studytools.AdditionalMaterials;

public class AddMatsRepo extends SuperRepo {
    private static int index = 0;
    private static int capacity = 10;
    private static AdditionalMaterials[] addMatsRepository = new AdditionalMaterials[capacity];


    public static AdditionalMaterials[] getAddMatsRepository() {
        return addMatsRepository;
    }

    public static void add(AdditionalMaterials newMaterial) {
        if (index == capacity) {
            grow();
        }
        addMatsRepository[index] = newMaterial;
        index++;
    }

    public static AdditionalMaterials getById(int id)    {
        for (AdditionalMaterials add : addMatsRepository) {
            if (add.getId() == id) {
                return add;
            }
        }
        return null;
    }

    public static void deleteById(int id)   {
        int index = 0;
        for (int i = 0; i < addMatsRepository.length; i++)    {
            if (addMatsRepository[i] != null && addMatsRepository[i].getId() == id)   {
                addMatsRepository[i] = null;
            }
            index = i;
        }
        if (index < addMatsRepository.length - 1) {
            while (index < addMatsRepository.length - 1) {
                addMatsRepository[index] = addMatsRepository[index + 1];
                index++;
            }
            addMatsRepository[addMatsRepository.length - 1] = null;
        }
        AddMatsRepo.index--;
    }

    private static void grow() {
        capacity = (capacity * 3) / 2 + 1;
        AdditionalMaterials[] newRepository = new AdditionalMaterials[capacity];
        System.arraycopy(addMatsRepository, 0, newRepository, 0, addMatsRepository.length);
        addMatsRepository = newRepository;
    }
}
