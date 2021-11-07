package com.Matrix;

import java.util.ArrayList;

public class Main {

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

    public static void main(String[] args) {
	// write your code here
    }
}
