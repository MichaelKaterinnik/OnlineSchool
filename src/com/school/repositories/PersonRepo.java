package com.school.repositories;

import com.school.models.Person;
import com.school.models.Superclass;

public class PersonRepo extends SuperRepo {
    private static Storage<Person> storage = new Storage<>();


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
        return storage.getAll();
    }

    public void addS(Person person) {
        storage.add(person);
    }

    public Person getById(int id) {
        return storage.get(id);
    }

    public void deleteById(int id) {
        storage.remove(id);
    }

}
