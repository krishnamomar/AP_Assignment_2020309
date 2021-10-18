package com.BackPack;

import java.lang.*;
import java.util.ArrayList;

public interface Material {

    void setName(String inp);
    void AddContent(String inp);
    void setUploader(Teacher tch);
    void setDate(String tm);
    String getDate();
    String getFile();
    ArrayList<String> getContent();

    String getName();
    Teacher uploader();
}
