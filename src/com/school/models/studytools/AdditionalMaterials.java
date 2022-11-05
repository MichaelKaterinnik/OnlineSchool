package com.school.models.studytools;

public class AdditionalMaterials {
    private static int counter = 0;
    private int id;


    // constructors:
    public AdditionalMaterials()   {
        counter++;
    }


    // getters & setters:
    public int getCounter() { return counter; }

    public void setId(int id)   { this.id = id; }

}
