package com.BackPack;

import java.util.ArrayList;

public class Slides implements Material{

    String Name;
    ArrayList<String> content = new ArrayList<>();
    Teacher upld;
    String date_of_upld;

    @Override
    public void setName(String inp) {
        this.Name = inp;
    }

    @Override
    public void AddContent(String inp) {
        content.add(inp);

    }

    @Override
    public void setUploader(Teacher tch) {
        this.upld = tch;
    }

    @Override
    public void setDate(String tm) {
        this.date_of_upld = tm;
    }

    @Override
    public String getDate() {
        return date_of_upld;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public Teacher uploader() {
        return upld;
    }

    @Override
    public ArrayList<String> getContent(){
        return content;
    }

    @Override
    public String getFile(){
        return null;
    }
}
