package com.BackPack;

import java.util.ArrayList;

public class Slides implements Material{

    String Name;
    ArrayList<String> content = new ArrayList<>();
    Teacher upld;

    @Override
    public void setName(String inp) {
        Name = inp;
    }

    @Override
    public void AddContent(String inp) {
        content.add(inp);

    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public Teacher uploader() {
        return upld;
    }

    public ArrayList<String> getContent(){
        return content;
    }

    public Integer getFile(){
        return 0;
    }
}
