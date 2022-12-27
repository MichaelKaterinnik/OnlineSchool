package com.school.models.studytools.services;

import com.school.models.SuperRepo;
import com.school.models.studytools.AdditionalMaterials;

public class AddMatsRepo extends SuperRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static AdditionalMaterials[] addMatsRepository = new AdditionalMaterials[capacity];


    public static AdditionalMaterials[] getAddMatsRepository() {
        return addMatsRepository;
    }

    public static void add(AdditionalMaterials newMaterial) {
        if (size == capacity) {
            grow();
        }
        addMatsRepository[size] = newMaterial;
        size++;
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
        for (int i = 0; i < addMatsRepository.length; i++)    {
            if (addMatsRepository[i] != null && addMatsRepository[i].getId() == id)   {
                addMatsRepository[i] = null;
            }
        }
        int k = 0;
        for (int i = 0; i < addMatsRepository.length; i++) {
            if (addMatsRepository[i] == null) {
                k = i;
                while (k < addMatsRepository.length - 1) {
                    addMatsRepository[k] = addMatsRepository[k + 1];
                    k++;
                }
            }
        }
        size--;
    }

    private static void grow() {
        capacity = (int) (capacity * 3) / 2 + 1;
        AdditionalMaterials[] newRepository = new AdditionalMaterials[capacity];
        for (int i = 0; i < addMatsRepository.length; i++) {
            newRepository[i] = addMatsRepository[i];
        }
        addMatsRepository = newRepository;
    }
}
