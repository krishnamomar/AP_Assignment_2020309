package com.BackPack;

import java.lang.*;
import java.util.*;

public interface Assessments {
    Integer getMaxMarks();
    HashMap<Student, Integer> getScores();
    void close();
    boolean status();
    String getQuestion();
    void setQuestion(String qns);
}
