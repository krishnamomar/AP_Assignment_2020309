package com.BackPack;

import java.lang.*;

public interface Material {

    void setName(String inp);
    void AddContent(String inp);
    void setUploader(Teacher tch);

    String getName();
    Teacher uploader();
}
