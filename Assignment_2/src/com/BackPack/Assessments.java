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
    void setMaxMarks(Integer mx);
    Integer what_type();  //return 0 for Assignments and 1 for Quiz
}
