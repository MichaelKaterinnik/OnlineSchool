package com.school.models.studytools;

public class Lecture {
    public static int counter = 0;
    private static int id;
    String lectureTopic;
    Homework homework;
    AdditionalMaterials addMaterial;

    public Lecture(String topic) {
        this.lectureTopic = topic;
        counter++;
    }

    public Lecture(String topic, AdditionalMaterials addMaterial, Homework homework)   {
        this.homework = homework;
        this.addMaterial = addMaterial;
        this.lectureTopic = topic;
        counter++;
    }

    public Lecture(String topic, Homework homework, AdditionalMaterials addMaterial)   {
        this.homework = homework;
        this.addMaterial = addMaterial;
        this.lectureTopic = topic;
        counter++;
    }

    public Lecture(String topic, Homework homework)   {
        this.homework = homework;
        this.lectureTopic = topic;
        counter++;
    }

    public Lecture()   {
        counter++;
    }

}
