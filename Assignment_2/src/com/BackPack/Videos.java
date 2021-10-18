package com.BackPack;

public class Videos implements Material{
    String Name;
    String file;
    Teacher upld;

    @Override
    public void setName(String inp) {
        this.Name = inp;

    }

    @Override
    public void AddContent(String inp) {
        file = inp;

    }

    @Override
    public void setUploader(Teacher tch) {
        this.upld = tch;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public Teacher uploader() {
        return upld;
    }

    public String getFile(){
        return file;
    }
}
