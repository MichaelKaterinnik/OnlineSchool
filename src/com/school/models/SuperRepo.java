package com.school.models;


public class SuperRepo {
    private int index = 0;
    private int capacity = 10;
    private Superclass[] repository = new Superclass[capacity];

    protected SuperRepo() {
    }

    private static class SuperRepoHolder    {
        public static final SuperRepo SUPER_REPO_INSTANCE = new SuperRepo();
    }

    // methods:
    public static SuperRepo getInstance() {
        return SuperRepoHolder.SUPER_REPO_INSTANCE;
    }

    public static Superclass[] getAll()    {
        return SuperRepo.getInstance().repository;
    }

    public void add(Superclass superclass)  {
        if (index == capacity) {
            grow();
        }
        repository[index] = superclass;
        index++;
    }

    public Superclass getById(int id)    {
        for (Superclass superclass : repository) {
            if (superclass.getId() == id) {
                return superclass;
            }
        }
        return null;
    }

    public void deleteById(int id)   {
        int pic = 0;
        for (int i = 0; i < repository.length; i++)    {
            if (repository[i] != null && repository[i].getId() == id)   {
                repository[i] = null;
            }
            pic = i;
        }
        if (pic < repository.length - 1) {
            while (pic < repository.length - 1) {
                repository[pic] = repository[pic + 1];
                pic++;
            }
            repository[repository.length - 1] = null;
        }
        SuperRepo.getInstance().index--;
    }

    private void grow() {
        capacity = (int) (capacity * 3) / 2 + 1;
        Superclass[] superRepository = new Superclass[capacity];
        System.arraycopy(repository, 0, superRepository, 0, repository.length);
        repository = superRepository;
    }

}
