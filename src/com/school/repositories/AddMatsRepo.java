package com.school.repositories;

import com.school.models.SuperRepo;
import com.school.models.AdditionalMaterials;

public class AddMatsRepo extends SuperRepo {
    private int index = 0;
    private int capacity = 10;
    private AdditionalMaterials[] addMatsRepository = new AdditionalMaterials[capacity];

    private AddMatsRepo() {
    }

    private static class AddMatsRepoHolder    {
        public static final AddMatsRepo ADDITIONAL_MATERIALS_REPO_INSTANCE = new AddMatsRepo();
    }

    // methods:
    public static AddMatsRepo getInstance() {
        return AddMatsRepoHolder.ADDITIONAL_MATERIALS_REPO_INSTANCE;
    }

    public static AdditionalMaterials[] getAll() {
        return AddMatsRepo.getInstance().addMatsRepository;
    }

    public void add(AdditionalMaterials newMaterial) {
        if (index == capacity) {
            grow();
        }
        addMatsRepository[index] = newMaterial;
        index++;
    }

    public AdditionalMaterials getById(int id)    {
        for (AdditionalMaterials add : addMatsRepository) {
            if (add.getId() == id) {
                return add;
            }
        }
        return null;
    }

    public void deleteById(int id)   {
        int pic = 0;
        for (int i = 0; i < addMatsRepository.length; i++)    {
            if (addMatsRepository[i] != null && addMatsRepository[i].getId() == id)   {
                addMatsRepository[i] = null;
            }
            pic = i;
        }
        if (pic < addMatsRepository.length - 1) {
            while (pic < addMatsRepository.length - 1) {
                addMatsRepository[pic] = addMatsRepository[pic + 1];
                pic++;
            }
            addMatsRepository[addMatsRepository.length - 1] = null;
        }
        AddMatsRepo.getInstance().index--;
    }

    private void grow() {
        capacity = (capacity * 3) / 2 + 1;
        AdditionalMaterials[] newRepository = new AdditionalMaterials[capacity];
        System.arraycopy(addMatsRepository, 0, newRepository, 0, addMatsRepository.length);
        addMatsRepository = newRepository;
    }
}
