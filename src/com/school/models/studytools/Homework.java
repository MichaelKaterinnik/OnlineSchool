package com.school.models.studytools;

import com.school.models.Superclass;

public class Homework extends Superclass {
    private static int counter = 0;
    private int id;
    private int homeworkMark;
    private String homeworkTask;
    private int lectureID;


    // constructors:
    public Homework()  {
        ++counter;
        this.id = counter;
    }


    // getters & setters:
    public static  int getCounter() { return counter; }
    public void setID(int id)   { this.id = id; }
    public int getID()  { return id; }
    public void setHomeworkMark(int homeworkMark) { this.homeworkMark = homeworkMark; }
    public int setHomeworkMark()    { return homeworkMark; }
    public void setHomeworkTask(String homeworkTask) {
        this.homeworkTask = homeworkTask;
    }
    public String getHomeworkTask() {
        return homeworkTask;
    }

    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }
    public int getLectureID() {
        return lectureID;
    }
}
