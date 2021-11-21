package com.Image_Process;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static Integer Give_Random(){
        List<Integer> givenList = new ArrayList<>();
        for (int i=0; i<=255; i++){
            givenList.add(i);
        }
        Random rand = new Random();
        Integer randomElement = givenList.get(rand.nextInt(givenList.size()));
        return randomElement;
    }

    public static ArrayList<ArrayList<Integer>> Compute_Inverse_BW(ArrayList<ArrayList<Integer>> matrix, Integer row, Integer column){
        ArrayList<ArrayList<Integer>> inverted = new ArrayList<>();
        for (int i=0; i<row; i++){
            ArrayList<Integer> x = new ArrayList<>();
            for (int j=0; j<column; j++){
                x.add(255 - matrix.get(i).get(j));
            }
            inverted.add(x);
        }

        return inverted;
    }

    public static ArrayList<ArrayList<ArrayList<Integer>>> Compute_Inverse_CL(ArrayList<ArrayList<ArrayList<Integer>>> matrix, Integer row, Integer column){
        ArrayList<ArrayList<ArrayList<Integer>>> inverted = new ArrayList<>();
        for (int i=0; i<row; i++){
            ArrayList<ArrayList<Integer>> x = new ArrayList<>();
            for (int j=0; j<column; j++){
                ArrayList<Integer> y = new ArrayList<>();
                for (int k=0; k<3; k++){
                    y.add(255 - matrix.get(i).get(j).get(k));
                }
                x.add(y);
            }
            inverted.add(x);
        }

        return inverted;
    }

    public static void Image_Printer_CL(ArrayList<ArrayList<ArrayList<Integer>>> matrix, Integer row, Integer column, String name){
        System.out.println("Coloured Image " + name + " (R G B):");
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                System.out.print("(" + matrix.get(i).get(j).get(0) + " " + matrix.get(i).get(j).get(1) + " " + matrix.get(i).get(j).get(2) + ") ");
            }
            System.out.println("");
        }
    }

    public static void Image_Printer_BW(ArrayList<ArrayList<Integer>> matrix, Integer row, Integer column, String name){
        System.out.println("Grayscale Image " + name + " :");
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException{

        //Database starts
        ArrayList<Object> All_Images = new ArrayList<>();
        //Database ends
        System.out.println("Image Processor Initialized...");
        System.out.println("=============================================");
        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Select Require Function: ");
            System.out.println("1. Input new Image");
            System.out.println("2. Create new Image");
            System.out.println("3. Update Existing Image");
            System.out.println("4. Display Existing Image");
            System.out.println("5. Compute Negative of an Image");
            System.out.println("6. Exit");
            System.out.print("Required Function: ");
            Integer INP1 = Integer.parseInt(scn.readLine());
            System.out.println("---------------------------------------------");
            System.out.println("");

            if (INP1>6 || INP1<1){
                System.out.println("Invalid Input");
                continue;
            }

            else if (INP1==6){
                System.out.println("Thank You!!");
                break;
            }

            else if (INP1==1){
                System.out.println("Enter Image Type: ");
                System.out.println("1. Coloured");
                System.out.println("2. Grayscale");
                Integer inp2 = Integer.parseInt(scn.readLine());

            }

        }



        //scn.close();


    }
}
