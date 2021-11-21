package com.Image_Process;

import java.util.ArrayList;
import java.lang.*;
import java.io.*;

public class Main {

    public static ArrayList<ArrayList<Integer>> Compute_Inverse(ArrayList<ArrayList<Integer>> matrix, Integer row, Integer column){
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

    public static void main(String[] args) throws IOException{

        //Database starts
        ArrayList<Object> All_Images = new ArrayList<>();
        //Database ends
        System.out.println("Image Processor Initialized...");
        System.out.println("=============================================");
        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

        }


    }
}
