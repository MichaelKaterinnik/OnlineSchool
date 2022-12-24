package com.school.models;


public class SuperRepo {
    private static int size = 0;
    private static int capacity = 10;
    private static Superclass[] repository = new Superclass[capacity];


    public static Superclass[] getAll()    {
        return repository;
    }

    public static void add(Superclass superclass)  {
        if (size == capacity) {
            grow();
        }
        repository[size] = superclass;
        size++;
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
        for (int i = 0; i < repository.length; i++)    {
            if (repository[i] != null && repository[i].getId() == id)   {
                repository[i] = null;
            }
        }
        int k = 0;
        for (int i = 0; i < repository.length; i++) {
            if (repository[i] == null) {
                k = i;
                while (k < repository.length - 1) {
                    repository[k] = repository[k + 1];
                    k++;
                }
            }
        }
        size--;
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
