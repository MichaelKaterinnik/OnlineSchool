package com.school.repositories;


import com.school.models.Superclass;

public class SuperRepo {
    private static Storage<Superclass> storage = new Storage<>();


    protected SuperRepo() {
    }


    private static class SuperRepoHolder {
        public static final SuperRepo SUPER_REPO_INSTANCE = new SuperRepo();
    }

    // methods:
    public static SuperRepo getInstance() {
        return SuperRepoHolder.SUPER_REPO_INSTANCE;
    }

    public static Superclass[] getAll() {
        return storage.getAll();
    }

    public void addS(Superclass superclass) {
        storage.add(superclass);
    }

    public Superclass getById(int id) {
        return storage.get(id);
    }

    public void deleteById(int id) {
        storage.remove(id);
    }

}
