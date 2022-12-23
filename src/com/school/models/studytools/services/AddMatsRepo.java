package com.school.models.studytools.services;

import com.school.models.studytools.AdditionalMaterials;

public class AddMatsRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static AdditionalMaterials[] addMatsRepository = new AdditionalMaterials[capacity];


    public static AdditionalMaterials[] getAddMatsRepository() {
        return addMatsRepository;
    }

    public static void saveAdditionalMaterial(AdditionalMaterials newMaterial) {
        if (size == capacity) {
            grow();
        }
        addMatsRepository[size] = newMaterial;
        size++;
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
