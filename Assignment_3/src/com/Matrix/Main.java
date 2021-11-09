package com.Matrix;

import java.util.*;
import java.lang.*;
import java.io.*;

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
                    if (grd.get(i).get(j)!=0.0){
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
                    if (grd.get(i).get(j)!=0.0){
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

    public static ArrayList<ArrayList<Double>> Element_Addition(ArrayList<ArrayList<Double>> grd, Integer rw, Integer cl, Integer scalar){
        ArrayList<ArrayList<Double>> ans = new ArrayList<>();
        for (int i=0; i<rw; i++){
            ArrayList<Double> x = new ArrayList<>();
            ans.add(x);
        }

        for (int i=0; i<rw; i++){
            for (int j=0; j<cl; j++){
                ans.get(i).add(scalar+(grd.get(i).get(j)));
            }
        }

        return ans;
    }

    public static boolean Is_Same(ArrayList<ArrayList<Double>> Aarr, ArrayList<ArrayList<Double>> Barr, Integer rw, Integer cl){
        // assumed that rw and cl are same then only this function is called
        for (int i=0; i<rw; i++){
            for (int j=0; j<cl; j++){
                if (Math.abs(Aarr.get(i).get(j) - Barr.get(i).get(j)) > 1e-6){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean Check_Ones(ArrayList<ArrayList<Double>> grd, Integer rw, Integer cl){
        for (int i=0; i<rw; i++){
            for (int j=0; j<cl; j++){
                if (grd.get(i).get(j) != 1.0){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean Check_Null(ArrayList<ArrayList<Double>> grd, Integer rw, Integer cl){
        for (int i=0; i<rw; i++){
            for (int j=0; j<cl; j++){
                if (grd.get(i).get(j) != 0.0){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean Check_Symmetric(ArrayList<ArrayList<Double>> grd, Integer sz){
        // should already be square

        ArrayList<ArrayList<Double>> chk = Transpose(grd, sz, sz);

        return Is_Same(grd, chk, sz, sz);
    }

    public static boolean Check_SkewSymmetric(ArrayList<ArrayList<Double>> grd, Integer sz){
        // should already be square

        ArrayList<ArrayList<Double>> chk1 = Transpose(grd, sz, sz);
        ArrayList<ArrayList<Double>> chk2 = Scalar_Multiplication(grd, sz, sz, -1);

        return Is_Same(chk1, chk2, sz, sz);
    }




    public static void main(String[] args) throws IOException{

        //Database starts here
        ArrayList<matrix> All_Matrices = new ArrayList<>();
        int ascii_name = 97;
        //Database ends here


        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Program Initialized");
        System.out.println("===========================================================");
        System.out.println("");

        while (true){
            System.out.println("Choose the Desired Operation");
            System.out.println("------------------------------------------------------");
            System.out.println("1. Input Matrix");
            System.out.println("2. Create Matrix");
            System.out.println("3. Change Elements of a Matrix");
            System.out.println("4. Display all Matrix-type Labels");
            System.out.println("5. Perform Matrix-Wise Operations");
            System.out.println("6. Perform Element-Wise Operations");
            System.out.println("7. Transpose Matrix");
            System.out.println("8. Inverse Matrix");
            System.out.println("9. Compute Means");
            System.out.println("10. Compute Determinants");
            System.out.println("11. Use Singleton Matrix as Scalars");
            System.out.println("12. Compute A + A' for Matrix A");
            System.out.println("13. Compute Eigen Vectors and Values");
            System.out.println("14. Solve Linear Equation");
            System.out.println("15. Retrive All Matrices");
            System.out.println("16. Exit");

            System.out.print("Input: ");
            Integer Opr_Input = Integer.parseInt(scn.readLine());

            if (Opr_Input==16){
                System.out.println("Thank You!!");
                break;
            }

            else if (Opr_Input>16 || Opr_Input<1){
                System.out.println("Invalid Operation");
                System.out.println("------------------------------------------------------");
                continue;
            }

            else if (Opr_Input==1){
                System.out.print("Enter the size of Matrix (row column): ");
                String[] mat_str = scn.readLine().split(" ");
                Integer rw = Integer.parseInt(mat_str[0]);
                Integer cl = Integer.parseInt(mat_str[1]);

                ArrayList<ArrayList<Double>> crnt = new ArrayList<>();
                System.out.println("Enter the Matrix: ");
                for (int i=0; i<rw; i++){
                    ArrayList<Double> x = new ArrayList<>();
                    String[] ln1 = scn.readLine().split(" ");

                    for (int j=0; j<cl; j++){
                        x.add(Double.parseDouble(ln1[j]));
                    }

                    crnt.add(x);
                }

                char nm_ch = (char)ascii_name;
                String name = Character.toString(nm_ch);
                System.out.println(name + " = ");
                print_matrix(crnt, rw, cl);
                ascii_name++;

                System.out.println("------------------------------------------------------");
                if (rw!=cl){
                    if (Check_Ones(crnt, rw, cl)){
                        matrix mtx = new OnesMat();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }

                    else if (Check_Null(crnt, rw, cl)){
                        matrix mtx = new NullMat();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }

                    else if (cl==1){
                        matrix mtx = new RowMat();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }

                    else if (rw==1){
                        matrix mtx = new ColumnMat();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }

                    else{
                        matrix mtx = new matrix();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }


                }

                else{
                    if (Check_Ones(crnt, rw, cl)){
                        matrix mtx = new OnesMat();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }

                    else if (Check_Null(crnt, rw, cl)){
                        matrix mtx = new NullMat();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }

                    else if (rw==1){
                        matrix mtx = new SingletonMat();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }

                    else if (Check_SkewSymmetric(crnt, rw)){
                        matrix mtx = new SkewSymmetricMat();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }

                    else if (Check_Symmetric(crnt, rw)){
                        if (check_upper(crnt) && check_lower(crnt)){
                            if (rw==2){
                                if (Math.abs(crnt.get(0).get(0) - crnt.get(1).get(1)) <= 1e-6){
                                    if (crnt.get(0).get(0)==1.0){
                                        matrix mtx = new IndentityMat();
                                        mtx.setGrid(crnt);
                                        mtx.setName(name);
                                        All_Matrices.add(mtx);
                                        continue;
                                    }
                                    else{
                                        matrix mtx = new ScalarMat();
                                        mtx.setGrid(crnt);
                                        mtx.setName(name);
                                        All_Matrices.add(mtx);
                                        continue;
                                    }
                                }
                                else{
                                    matrix mtx = new DiagnolMat();
                                    mtx.setGrid(crnt);
                                    mtx.setName(name);
                                    All_Matrices.add(mtx);
                                    continue;
                                }
                            }

                            else if(rw==3){
                                if ((Math.abs(crnt.get(0).get(0) - crnt.get(1).get(1)) <= 1e-6) && (Math.abs(crnt.get(0).get(0) - crnt.get(2).get(2)) <= 1e-6)){
                                    if (crnt.get(0).get(0)==1.0){
                                        matrix mtx = new IndentityMat();
                                        mtx.setGrid(crnt);
                                        mtx.setName(name);
                                        All_Matrices.add(mtx);
                                        continue;
                                    }
                                    else{
                                        matrix mtx = new ScalarMat();
                                        mtx.setGrid(crnt);
                                        mtx.setName(name);
                                        All_Matrices.add(mtx);
                                        continue;
                                    }
                                }
                                else{
                                    matrix mtx = new DiagnolMat();
                                    mtx.setGrid(crnt);
                                    mtx.setName(name);
                                    All_Matrices.add(mtx);
                                    continue;
                                }
                            }
                        }

                        else{
                            matrix mtx = new SymmetricMat();
                            mtx.setGrid(crnt);
                            mtx.setName(name);
                            All_Matrices.add(mtx);
                            continue;
                        }
                    }

                    else if (Determinant(crnt, rw)==0.0){
                        matrix mtx = new SingularMat();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }

                    else{
                        matrix mtx = new SquareMat();
                        mtx.setGrid(crnt);
                        mtx.setName(name);
                        All_Matrices.add(mtx);
                        continue;
                    }


                }



            }

            else if (Opr_Input==2){
                System.out.println("Enter the type of Matrix: ");
            }
        }










        //scn.close(); uncomment after completion



    }


}
