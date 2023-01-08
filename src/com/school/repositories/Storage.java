package com.school.repositories;

import com.school.models.Superclass;

import java.util.Arrays;

public class Storage <E extends Superclass> {
    private Integer repIndex = 0;
    private Integer capacity = 10;
    private E[] repository;

    public E[] getAll()    {
        return repository;
    }

    public int size()   {
        return repository.length;
    }

    public boolean isEmpty()    {
        for (E element : repository)    {
            if (element != null)    {
                return false;
            }
        }
        return true;
    }

    public E get(int id)    {
        for (E element : repository) {
            if (element.getId() == id) {
                return element;
            }
        }
        System.out.println("У сховищі немає елементу з таким індексом!");
        return null;
    }

    public void add(E element)  {
        if (repIndex == capacity) {
            grow();
        }
        repository[repIndex] = element;
        repIndex++;
    }

    public void add(E element, int index)   {
        if (repIndex == capacity) {
            grow();
        }
        if (capacity < index)   {
            while (capacity < index)    {
                grow();
            }
            repIndex = repository.length - 10;
        }
        for (int i = 0; i < repository.length; i++) {
            if (i == index) {
                repository[i] = element;
            }
        }
        repIndex++;
    }

    public void remove(int index)   {
        int pic = 0;
        for (int i = 0; i < repository.length; i++)    {
            if (repository[i] != null && repository[i].getId() == index)   {
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
        repIndex--;
    }

    private void grow() {
        capacity = (capacity * 3) / 2 + 1;
        E[] newStorage = null;
        newStorage = Arrays.copyOf(repository, capacity);
        repository = newStorage;
    }


}


