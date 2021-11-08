package com.Matrix;

import java.util.ArrayList;
import java.lang.*;

public class Main {

    public static void print_matrix(ArrayList<ArrayList<Double>> grd, Integer rw, Integer cl){
        for (int i=0; i<rw; i++){
            for (int j=0; j<cl; j++){
                System.out.print(grd.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    public static boolean check_upper(ArrayList<ArrayList<Double>> grd){
        for(int i=0; i<grd.size(); i++){
            for (int j=0; j<grd.get(0).size(); j++){
                if (i>j){
                    if (grd.get(i).get(j)!=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean check_lower(ArrayList<ArrayList<Double>> grd){
        for(int i=0; i<grd.size(); i++){
            for (int j=0; j<grd.get(0).size(); j++){
                if (i<j){
                    if (grd.get(i).get(j)!=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static ArrayList<ArrayList<Double>> transpose(ArrayList<ArrayList<Double>> grd, Integer rw, Integer cl){
        // rw and cl are row and column of original matrix
        ArrayList<ArrayList<Double>> crnt = new ArrayList<>();

        for (int i=0; i<cl; i++){
            ArrayList<Double> x = new ArrayList<>();
            crnt.add(x);
        }

        for (int i=0; i<cl; i++){
            for (int j=0; j<rw; j++){
                crnt.get(i).add(grd.get(j).get(i));
            }
        }

        return crnt;
    }

    public static Double Determinant(ArrayList<ArrayList<Double>> grd, Integer sz){
        if (sz==0){
            return 0.0;
        }

        else if (sz==1){
            return grd.get(0).get(0);
        }

        else if (sz==2){
            Double ans = 0.0;
            ans = ans + (grd.get(0).get(0))*(grd.get(1).get(1));
            ans = ans - (grd.get(1).get(0))*(grd.get(0).get(1));

            return ans;
        }

        Double ans = 0.0;
        ans = ans + (grd.get(0).get(0))*(grd.get(1).get(1))*(grd.get(2).get(2));
        ans = ans + (grd.get(0).get(1))*(grd.get(1).get(2))*(grd.get(2).get(0));
        ans = ans + (grd.get(0).get(2))*(grd.get(1).get(0))*(grd.get(2).get(1));
        ans = ans - (grd.get(0).get(0))*(grd.get(1).get(2))*(grd.get(2).get(1));
        ans = ans - (grd.get(0).get(1))*(grd.get(1).get(0))*(grd.get(2).get(2));
        ans = ans - (grd.get(0).get(2))*(grd.get(1).get(1))*(grd.get(2).get(0));

        return ans;
    }

    public static void main(String[] args) {
	// write your code here


    }


}
