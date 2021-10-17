package com.BackPack;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Main {

    public static String date_generator() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        String strDate = formatter.format(date);

        return strDate;
    }

    public static void main(String[] args) throws IOException{

        //DataBase Starts here
        ArrayList<Comment> all_comments = new ArrayList<>();
        ArrayList<Student> all_students = new ArrayList<>();
        ArrayList<Teacher> all_teachers = new ArrayList<>();
        ArrayList<Material> all_material = new ArrayList<>();
        ArrayList<Assessments> all_assessments = new ArrayList<>();

        //DataBase Ends here

        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));

    }
}
