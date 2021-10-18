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

        //Addition of Sample Instructors and Students
        Student a = new Student();
        a.Name = "Charmander";
        all_students.add(a);
        Student b = new Student();
        b.Name = "Bulbasaur";
        all_students.add(b);
        Student c = new Student();
        c.Name = "Squirtle";
        all_students.add(c);

        Teacher x = new Teacher();
        x.Name = "Brendan";
        all_teachers.add(x);
        Teacher y = new Teacher();
        y.Name = "Hilbert";
        all_teachers.add(y);
        //Sample added

        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));

        // outer while loop
        while (true){
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as Instructor");
            System.out.println("2. Enter as Student");
            System.out.println("3. Exit");
            System.out.println("-----------------------------------------------------------");

            Integer INP1 = Integer.parseInt(scn.readLine());

            if (INP1==3){    //exit condition
                System.out.println("Thank You for Visiting Backpack");
                break;
            }

            else if (INP1==1){  //instructor
                System.out.println("Instructors: ");
                System.out.println("0 - " + all_teachers.get(0).getName());
                System.out.println("1 - " + all_teachers.get(1).getName());
                System.out.print("Choose ID: ");
                Integer c_t_i = Integer.parseInt(scn.readLine());
                System.out.println("-----------------------------------------------------------");
                Teacher crnt_instr = all_teachers.get(c_t_i);

                //inner while loop
                while (true) {
                    System.out.println("Welcome " + crnt_instr.getName());
                    System.out.println("1. Add Class Material");
                    System.out.println("2. Add Assessments");
                    System.out.println("3. View Lecture Materials");
                    System.out.println("4. View Assessments");
                    System.out.println("5. Grade Assessments");
                    System.out.println("6. Close Assessment");
                    System.out.println("7. View Comments");
                    System.out.println("8. Add Comments");
                    System.out.println("9. Logout");

                    Integer INP2 = Integer.parseInt(scn.readLine());

                    if (INP2==9){
                        break;
                    }

                    else if (INP2==1){
                        System.out.println("1. Add Lecture Slide");
                        System.out.println("2. Add Lecture Video");
                        Integer lcsv = Integer.parseInt(scn.readLine());

                        if (lcsv==1){
                            Material sld = new Slides();
                        }

                    }
                }



            }


            else if (INP1==2){   //Student

            }




        }







        //scn.close(); call at last

    }
}
