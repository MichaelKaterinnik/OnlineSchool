package com.school.models.studytools;

public class Homework {
    private static int counter = 0;
    private int id;
    private int homeworkMark;


    // constructors:
    public Homework()  {
        counter++;
    }


    // getters & setters:
    public int getCounter() { return counter; }

    public void setID(int id)   { this.id = id; }

    public int getID()  { return id; }

    public void setHomeworkMark(int id) { this.homeworkMark = homeworkMark; }

    public int setHomeworkMark()    { return homeworkMark; }

}
