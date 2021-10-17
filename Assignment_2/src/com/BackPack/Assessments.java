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
    HashMap<Student, String> getsubmissions();
    void add_score(Integer scr, Student std);
    void add_submit(String fl, Student std);
}
