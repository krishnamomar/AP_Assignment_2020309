package com.BackPack;

import java.util.HashMap;

public class Quiz implements Assessments{

    HashMap<Student, Integer> scores = new HashMap<>();
    HashMap<Student, String> submissions = new HashMap<>();
    HashMap<Student, Teacher> checkedBy = new HashMap<>();
    boolean crnt_status = true;  //True means the assignment is open
    String question;

    @Override
    public Integer getMaxMarks() {
        return 1;
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
    public void add_check(Teacher tch, Student std) {
        checkedBy.put(std, tch);
    }

    @Override
    public HashMap<Student, Teacher> getChecker() {
        return checkedBy;
    }

    @Override
    public void add_submit(String fl, Student std) {
        submissions.put(std, fl);
    }

    @Override
    public void setMaxMarks(Integer mx) {
        return;
    }

    @Override
    public Integer what_type() {
        return 1;
    }
}
