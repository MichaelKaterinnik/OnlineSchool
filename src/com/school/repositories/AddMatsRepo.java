package com.school.repositories;

import com.school.models.AdditionalMaterials;
import com.school.models.Homework;
import com.school.models.Lecture;

public class AddMatsRepo extends SuperRepo {
    private static Storage<AdditionalMaterials> storage = new Storage<>();


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
        return storage.getAll();
    }

    public void addS(AdditionalMaterials additionalMaterials) {
        storage.add(additionalMaterials);
    }

    public AdditionalMaterials getById(int id) {
        return storage.get(id);
    }

    public void deleteById(int id) {
        storage.remove(id);
    }
}
