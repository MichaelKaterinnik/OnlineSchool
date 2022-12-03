package com.school.models.studytools;

public class AdditionalMaterials {
    private static int counter = 0;
    private int id;
    private String topic;
    private int lectureID;



    // constructors:
    public AdditionalMaterials()   {
        counter++;
    }


    // getters & setters:
    public int getCounter() { return counter; }

    public void setId(int id)   { this.id = id; }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getTopic() {
        return topic;
    }
    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }
    public int getLectureID() {
        return lectureID;
    }
}
