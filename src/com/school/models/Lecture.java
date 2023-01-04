package com.school.models;

public class Lecture extends Superclass {
    private static int counter = 0;
    private int id;
    private int CourseID;
    private int PersonID;
    private String lectureName;
    private String lectureDescription;
    private Person teacher;
    private Homework homework;
    private AdditionalMaterials addMaterial;


    //constructors:
    public Lecture(String lectureName) {
        this.lectureName = lectureName;
        ++counter;
        this.id = counter;
    }
    public Lecture(String lectureName, String description) {
        this.lectureName = lectureName;
        this.lectureDescription = description;
        ++counter;
        this.id = counter;
    }
    public Lecture(String lectureName, AdditionalMaterials addMaterial, Homework homework)   {
        this.homework = homework;
        this.addMaterial = addMaterial;
        this.lectureName = lectureName;
        ++counter;
        this.id = counter;
    }
    public Lecture(String lectureName, String lectureDescription, AdditionalMaterials addMaterial, Homework homework)   {
        this.lectureDescription = lectureDescription;
        this.homework = homework;
        this.addMaterial = addMaterial;
        this.lectureName = lectureName;
        ++counter;
        this.id = counter;
    }

    public Lecture(String lectureName, Homework homework, AdditionalMaterials addMaterial)   {
        this.homework = homework;
        this.addMaterial = addMaterial;
        this.lectureName = lectureName;
        ++counter;
        this.id = counter;
    }
    public Lecture(String lectureName, String lectureDescription, Homework homework, AdditionalMaterials addMaterial)   {
        this.homework = homework;
        this.lectureDescription = lectureDescription;
        this.addMaterial = addMaterial;
        this.lectureName = lectureName;
        ++counter;
        this.id = counter;
    }

    public Lecture(String lectureName, Homework homework)   {
        this.homework = homework;
        this.lectureName = lectureName;
        ++counter;
        this.id = counter;
    }
    public Lecture(String lectureName, String description, Homework homework)   {
        this.homework = homework;
        this.lectureDescription = description;
        this.lectureName = lectureName;
        ++counter;
        this.id = counter;
    }
    public Lecture()   {
        ++counter;
        this.id = counter;
    }


    // getters & setters:
    public static int getCounter() { return counter; }
    public int getId() { return id; }
    public void setCourseID(int courseID) {
        this.CourseID = courseID;
    }
    public int getCourseID() {
        return CourseID;
    }
    public void setLectureName(String lectureTopic) { this.lectureName = lectureTopic; }
    public String getLectureName() { return lectureName; }
    public String getLectureDescription() {
        return lectureDescription;
    }
    public void setLectureDescription(String lectureDescription) {
        this.lectureDescription = lectureDescription;
    }
    public Homework getHomework() {
        return homework;
    }
    public void setHomework(Homework homework) {
        this.homework = homework;
    }
    public AdditionalMaterials getAddMaterial() {
        return addMaterial;
    }
    public void setAddMaterial(AdditionalMaterials addMaterial) {
        this.addMaterial = addMaterial;
    }
    public int getPersonID() {
        return PersonID;
    }
    public void setPersonID(int personID) {
        PersonID = personID;
    }
    public Person getTeacher() {
        return teacher;
    }
    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

}
