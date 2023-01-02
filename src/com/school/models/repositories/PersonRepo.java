package com.school.models.repositories;

import com.school.models.SuperRepo;
import com.school.models.Person;

public class PersonRepo extends SuperRepo {
    private int index = 0;
    private int capacity = 10;
    private Person[] personsRepository = new Person[capacity];

    private PersonRepo() {
    }

    private static class PersonRepoHolder    {
        public static final PersonRepo PERSON_REPO_INSTANCE = new PersonRepo();
    }

    // methods:
    public static PersonRepo getInstance() {
        return PersonRepoHolder.PERSON_REPO_INSTANCE;
    }

    public static Person[] getAll() {
        return PersonRepo.getInstance().personsRepository;
    }

    public void add(Person newPerson) {
        if (index == capacity) {
            grow();
        }
        personsRepository[index] = newPerson;
        index++;
    }

    public Person getById(int id)    {
        for (Person person : personsRepository) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void deleteById(int id)   {
        int pic = 0;
        for (int i = 0; i < personsRepository.length; i++)    {
            if (personsRepository[i] != null && personsRepository[i].getId() == id)   {
                personsRepository[i] = null;
            }
            pic = i;
        }
        if (pic < personsRepository.length - 1) {
            while (pic < personsRepository.length - 1) {
                personsRepository[pic] = personsRepository[pic + 1];
                pic++;
            }
            personsRepository[personsRepository.length - 1] = null;
        }
        PersonRepo.getInstance().index--;
    }

    private void grow() {
        capacity = (capacity * 3) / 2 + 1;
        Person[] newRepository = new Person[capacity];
        System.arraycopy(personsRepository, 0, newRepository, 0, personsRepository.length);
        personsRepository = newRepository;
    }

}
