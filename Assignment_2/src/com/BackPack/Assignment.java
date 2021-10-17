package com.BackPack;

import java.util.*;
import java.lang.*;

public class Assignment implements Assessments{

    Integer MaxMarks;
    HashMap<Student, Integer> scores = new HashMap<>();
    HashMap<Student, String> submissions = new HashMap<>();
    boolean crnt_status = true;  //True means the assignment is open
    String question;

    @Override
    public Integer getMaxMarks() {
        return MaxMarks;
    }

    @Override
    public HashMap<Student, Integer> getScores() {
        return scores;
    }

    @Override
    public void close() {
        crnt_status = false;
    }

    @Override
    public boolean status() {
        return crnt_status;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String qns) {
        question = qns;
    }

    @Override
    public HashMap<Student, String> getsubmissions() {
        return submissions;
    }

    @Override
    public void add_score(Integer scr, Student std) {
        scores.put(std, scr);
    }

    @Override
    public void add_submit(String fl, Student std) {
        submissions.put(std, fl);
    }


}
