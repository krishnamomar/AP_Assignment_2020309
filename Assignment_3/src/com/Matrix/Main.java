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

    public static ArrayList<ArrayList<Double>> Transpose(ArrayList<ArrayList<Double>> grd, Integer rw, Integer cl){
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

    public static ArrayList<ArrayList<Double>> Inverse_Matrix(ArrayList<ArrayList<Double>> grd, Integer sz){
        //only matrices with determinant != 0 can be inversed

        if (sz==1){
            ArrayList<ArrayList<Double>> ans = new ArrayList<>();
            ArrayList<Double> x = new ArrayList<>();
            Double v = Determinant(grd, sz);
            v = 1/v;
            x.add(v);
            ans.add(x);

            return ans;
        }

        else if (sz==2){
            Double v = Determinant(grd, sz);
            ArrayList<ArrayList<Double>> ans = new ArrayList<>();
            for (int i=0; i<2; i++){
                ArrayList<Double> x = new ArrayList<>();
                ans.add(x);
            }
            ans.get(0).add((grd.get(1).get(1))/v);
            ans.get(0).add(-1*((grd.get(0).get(1))/v));
            ans.get(1).add(-1*((grd.get(1).get(0))/v));
            ans.get(1).add((grd.get(0).get(0))/v);

            return ans;

        }

        Double v = Determinant(grd, sz);
        ArrayList<ArrayList<Double>> ans = new ArrayList<>();

        for (int ii=0; ii<3; ii++){
            ArrayList<Double> x = new ArrayList<>();
            ans.add(x);
        }

        Double a = grd.get(0).get(0);
        Double b = grd.get(0).get(1);
        Double c = grd.get(0).get(2);
        Double d = grd.get(1).get(0);
        Double e = grd.get(1).get(1);
        Double f = grd.get(1).get(2);
        Double g = grd.get(2).get(0);
        Double h = grd.get(2).get(1);
        Double i = grd.get(2).get(2);

        ans.get(0).add(((e*i)-(f*g))/v);
        ans.get(0).add(((c*h)-(b*i))/v);
        ans.get(0).add(((b*f)-(c*e))/v);
        ans.get(1).add(((f*g)-(d*i))/v);
        ans.get(1).add(((a*i)-(c*g))/v);
        ans.get(1).add(((c*d)-(a*f))/v);
        ans.get(2).add(((d*h)-(e*g))/v);
        ans.get(2).add(((b*g)-(a*h))/v);
        ans.get(2).add(((a*e)-(b*d))/v);

        return ans;

    }

    public static ArrayList<ArrayList<Double>> Addition(ArrayList<ArrayList<Double>> Aarr, ArrayList<ArrayList<Double>> Barr, Integer rw, Integer cl){
        ArrayList<ArrayList<Double>> ans = new ArrayList<>();
        for (int i=0; i<rw; i++){
            ArrayList<Double> x = new ArrayList<>();
            ans.add(x);
        }

        for (int i=0; i<rw; i++){
            for (int j=0; j<cl; j++){
                ans.get(i).add(Aarr.get(i).get(j) + Barr.get(i).get(j));
            }
        }

        return ans;
    }

    public static ArrayList<ArrayList<Double>> Scalar_Multiplication(ArrayList<ArrayList<Double>> grd, Integer rw, Integer cl, Integer scalar){
        ArrayList<ArrayList<Double>> ans = new ArrayList<>();
        for (int i=0; i<rw; i++){
            ArrayList<Double> x = new ArrayList<>();
            ans.add(x);
        }

        for (int i=0; i<rw; i++){
            for (int j=0; j<cl; j++){
                ans.get(i).add(scalar*(grd.get(i).get(j)));
            }
        }

        return ans;
    }

    public static ArrayList<ArrayList<Double>> Vector_Multiplication(ArrayList<ArrayList<Double>> Aarr, ArrayList<ArrayList<Double>> Barr, Integer Arw, Integer Acl, Integer Brw, Integer Bcl){
        // we'll do A x B, so Acl==Brw

        double ans_t[][] = new double[Arw][Bcl];

        for (int i=0; i<Arw; i++) {
            for (int j=0; j<Bcl; j++) {
                for (int k=0; k<Brw; k++)
                    ans_t[i][j] += (Aarr.get(i).get(k))*(Barr.get(k).get(j));
            }
        }

        ArrayList<ArrayList<Double>> ans = new ArrayList<>();

        for (int i=0; i<Arw; i++){
            ArrayList<Double> x = new ArrayList<>();
            for (int j=0; j<Bcl; j++){
                x.add(ans_t[i][j]);
            }
            ans.add(x);
        }

        return ans;
    }

    public static void main(String[] args) {
	// write your code here

        ArrayList<ArrayList<Double>> cntr = new ArrayList<>();
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        ArrayList<Double> z = new ArrayList<>();
        x.add(1.0);
        x.add(2.0);
        x.add(2.0);
        y.add(0.0);
        y.add(5.0);
        y.add(7.0);
        z.add(1.0);
        z.add(1.0);
        z.add(1.0);
        cntr.add(x);
        cntr.add(y);
        cntr.add(z);


        print_matrix(cntr, 3, 3);
        System.out.println(Determinant(cntr, 3));
        ArrayList<ArrayList<Double>> cntr_inv = Vector_Multiplication(cntr, cntr, 3, 3, 3, 3);
        print_matrix(cntr_inv, 3, 3);



    }


}
