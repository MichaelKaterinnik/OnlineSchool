package com.school.models;


public class SuperRepo {
    private static int index = 0;
    private static int capacity = 10;
    private static Superclass[] repository = new Superclass[capacity];


    public static Superclass[] getAll()    {
        return repository;
    }

    public static void add(Superclass superclass)  {
        if (index == capacity) {
            grow();
        }
        repository[index] = superclass;
        index++;
    }

    public static Superclass getById(int id)    {
        for (Superclass superclass : repository) {
            if (superclass.getId() == id) {
                return superclass;
            }
        }
        return null;
    }

    public static void deleteById(int id)   {
        int index = 0;
        for (int i = 0; i < repository.length; i++)    {
            if (repository[i] != null && repository[i].getId() == id)   {
                repository[i] = null;
            }
            index = i;
        }
        if (index < repository.length - 1) {
            while (index < repository.length - 1) {
                repository[index] = repository[index + 1];
                index++;
            }
            repository[repository.length - 1] = null;
        }
        SuperRepo.index--;
    }

    private static void grow() {
        capacity = (int) (capacity * 3) / 2 + 1;
        Superclass[] superRepository = new Superclass[capacity];
        for (int i = 0; i < repository.length; i++) {
            superRepository[i] = repository[i];
        }
        repository = superRepository;
    }

}
