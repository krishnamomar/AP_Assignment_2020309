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

    public static Double Give_Random() {
        List<Double> givenList = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0, -9.0, -8.0, -7.0, -6.0, -5.0, -4.0, -3.0, -2.0, -1.0, 1.0, 2.0, 3.0, 1.0, 4.0);
        Random rand = new Random();
        Double randomElement = givenList.get(rand.nextInt(givenList.size()));
        return randomElement;
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

        ans.get(0).add(((e*i)-(f*h))/v);
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

    public static ArrayList<ArrayList<Double>> Element_Multiplication(ArrayList<ArrayList<Double>> Aarr, ArrayList<ArrayList<Double>> Barr, Integer rw, Integer cl){
        ArrayList<ArrayList<Double>> ans = new ArrayList<>();
        for (int i=0; i<rw; i++){
            ArrayList<Double> x = new ArrayList<>();
            ans.add(x);
        }

        for (int i=0; i<rw; i++){
            for (int j=0; j<cl; j++){
                ans.get(i).add((Aarr.get(i).get(j))*(Barr.get(i).get(j)));
            }
        }

        return ans;
    }

    public static ArrayList<ArrayList<Double>> Element_Division(ArrayList<ArrayList<Double>> Aarr, ArrayList<ArrayList<Double>> Barr, Integer rw, Integer cl){
        ArrayList<ArrayList<Double>> ans = new ArrayList<>();
        for (int i=0; i<rw; i++){
            ArrayList<Double> x = new ArrayList<>();
            ans.add(x);
        }

        for (int i=0; i<rw; i++){
            for (int j=0; j<cl; j++){
                if (Barr.get(i).get(j)!=0.0) {
                    ans.get(i).add((Aarr.get(i).get(j))/(Barr.get(i).get(j)));
                }
                else{
                    ans.get(i).add(Double.MAX_VALUE);
                }
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

    public static ArrayList<Integer> Check_Labels(ArrayList<ArrayList<Double>> grd, Integer bsc, Integer rw, Integer cl){
        ArrayList<Integer> label_types = new ArrayList<>();


        if (bsc==1){
            label_types.add(1);
            if (check_upper(grd)){
                label_types.add(14);

            }
            if (check_lower(grd)){
                label_types.add(15);
            }

        }

        else if (bsc==2){
            label_types.add(2);
            label_types.add(1);
        }

        else if (bsc==3){
            label_types.add(2);
            label_types.add(1);
        }

        else if (bsc==4){
            label_types.add(4);
            if (rw==cl){
                label_types.add(6);
                if (rw==1){
                    label_types.add(8);
                }
                else{
                    label_types.add(7);
                    label_types.add(9);
                }
            }
            else{
                label_types.add(1);
                if (cl==1){
                    label_types.add(2);
                }
                if (rw==1){
                    label_types.add(3);
                }

            }
        }

        else if (bsc==5){
            label_types.add(5);
            if (rw==cl){
                label_types.add(6);
                if (rw==1){
                    label_types.add(7);
                    label_types.add(8);
                }
                else{
                    label_types.add(7);
                    label_types.add(14);
                    label_types.add(15);
                    label_types.add(9);
                }
            }
            else{
                label_types.add(1);
                if (cl==1){
                    label_types.add(2);
                }
                if (rw==1){
                    label_types.add(3);
                }
            }
        }

        else if (bsc==6){
            label_types.add(6);
            if (check_lower(grd)){
                label_types.add(15);
            }
            if (check_upper(grd)){
                label_types.add(14);
            }
        }

        else if (bsc==7){
            label_types.add(7);
            label_types.add(6);
            if (check_lower(grd)){
                label_types.add(15);
            }
            if (check_upper(grd)){
                label_types.add(14);
            }
        }

        else if (bsc==8){
            label_types.add(8);
            label_types.add(6);
        }

        else if (bsc==9){
            label_types.add(9);
            label_types.add(6);

            if (Determinant(grd, rw)==0.0){
                label_types.add(7);
            }
            if (check_lower(grd)){
                label_types.add(15);
            }
            if (check_upper(grd)){
                label_types.add(14);
            }
        }

        else if (bsc==10){
            label_types.add(10);
            label_types.add(9);
            label_types.add(6);

            if (Determinant(grd, rw)==0.0){
                label_types.add(7);
            }

            label_types.add(15);

            label_types.add(14);

        }

        else if (bsc==11){
            label_types.add(10);
            label_types.add(9);
            label_types.add(6);
            label_types.add(11);

            if (Determinant(grd, rw)==0.0){
                label_types.add(7);
            }

            label_types.add(15);

            label_types.add(14);

        }

        else if (bsc==12){
            label_types.add(10);
            label_types.add(9);
            label_types.add(6);
            label_types.add(11);
            label_types.add(12);

            if (Determinant(grd, rw)==0.0){
                label_types.add(7);
            }

            label_types.add(15);

            label_types.add(14);

        }

        else{
            label_types.add(13);
            label_types.add(6);
            if (Determinant(grd, rw)==0.0){
                label_types.add(7);
            }
            if (check_lower(grd)){
                label_types.add(15);
            }
            if (check_upper(grd)){
                label_types.add(14);
            }
        }




        return label_types;
    }

    public static boolean Check_Array_all(ArrayList<Integer> init, ArrayList<Integer> fnl){
        for (int i=0; i<init.size(); i++){
            Integer xx = init.get(i);
            if (!fnl.contains(xx)){
                return false;
            }
        }

        return true;
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
                System.out.println("All Matrix Types: ");
                System.out.println("1. Rectangular Matrix");
                System.out.println("2. Row Matrix");
                System.out.println("3. Column Matrix");
                System.out.println("4. Square Matrix");
                System.out.println("5. Symmetric Matrix");
                System.out.println("6. Skew-Symmetric Matrix");
                System.out.println("7. Upper Triangular Matrix");
                System.out.println("8. Lower Triangular Matrix");
                System.out.println("9. Singular Matrix");
                System.out.println("10. Diagonal Matrix");
                System.out.println("11. Scalar Matrix");
                System.out.println("12. Identity Matrix");
                System.out.println("13. Singleton Matrix");
                System.out.println("14. Ones Matrix");
                System.out.println("15. Null MAtrix");
                System.out.print("Enter ID: ");
                Integer Mt_id = Integer.parseInt(scn.readLine());

                ArrayList<ArrayList<Double>> crnt = new ArrayList<>();
                Integer rw;
                Integer cl;
                String name;

                if (Mt_id>15 || Mt_id<1){
                    System.out.println("Wrong ID Entered!");
                    continue;
                }

                else if (Mt_id==1){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=2;
                    cl=3;
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            x.add(Give_Random());
                        }
                        crnt.add(x);
                    }
                }

                else if (Mt_id==2){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=1;
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            x.add(Give_Random());
                        }
                        crnt.add(x);
                    }
                }

                else if (Mt_id==3){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=1;
                    cl=3;
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            x.add(Give_Random());
                        }
                        crnt.add(x);
                    }
                }

                else if (Mt_id==4){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=3;
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            x.add(Give_Random());
                        }
                        crnt.add(x);
                    }
                }

                else if (Mt_id==5){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=3;
                    Double Ma = Give_Random();
                    Double Mb = Give_Random();
                    Double Mc = Give_Random();
                    Double Md = Give_Random();
                    Double Me = Give_Random();
                    Double Mf = Give_Random();
                    ArrayList<Double> x = new ArrayList<>();
                    ArrayList<Double> y = new ArrayList<>();
                    ArrayList<Double> z = new ArrayList<>();
                    x.add(Ma);
                    x.add(Md);
                    x.add(Me);
                    y.add(Md);
                    y.add(Mb);
                    y.add(Mf);
                    z.add(Me);
                    z.add(Mf);
                    z.add(Mc);

                    crnt.add(x);
                    crnt.add(y);
                    crnt.add(z);
                }

                else if (Mt_id==6){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=3;
                    Double Ma = Give_Random();
                    Double Mb = Give_Random();
                    Double Mc = Give_Random();

                    ArrayList<Double> x = new ArrayList<>();
                    ArrayList<Double> y = new ArrayList<>();
                    ArrayList<Double> z = new ArrayList<>();
                    x.add(0.0);
                    x.add(Ma);
                    x.add(Mb);
                    y.add(-1*(Ma));
                    y.add(0.0);
                    y.add(Mc);
                    z.add(-1*(Mb));
                    z.add(-1*(Mc));
                    z.add(0.0);

                    crnt.add(x);
                    crnt.add(y);
                    crnt.add(z);
                }

                else if (Mt_id==7){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=3;
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            if (i>j){
                                x.add(0.0);
                            }
                            else {
                                x.add(Give_Random());
                            }
                        }
                        crnt.add(x);
                    }
                }

                else if (Mt_id==8){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=3;
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            if (i<j){
                                x.add(0.0);
                            }
                            else {
                                x.add(Give_Random());
                            }
                        }
                        crnt.add(x);
                    }
                }

                else if (Mt_id==9 || Mt_id==15){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=3;
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            x.add(0.0);
                        }
                        crnt.add(x);
                    }
                }

                else if (Mt_id==10){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=3;
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            if (i==j){
                                x.add(Give_Random());
                            }
                            else{
                                x.add(0.0);
                            }
                        }
                        crnt.add(x);
                    }
                }

                else if (Mt_id==11){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=3;
                    Double Mv = Give_Random();
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            if (i==j){
                                x.add(Mv);
                            }
                            else{
                                x.add(0.0);
                            }
                        }
                        crnt.add(x);
                    }
                }

                else if (Mt_id==12){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=3;
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            if (i==j){
                                x.add(1.0);
                            }
                            else{
                                x.add(0.0);
                            }
                        }
                        crnt.add(x);
                    }
                }

                else if (Mt_id==13){
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=1;
                    cl=1;
                    ArrayList<Double> x = new ArrayList<>();
                    x.add(Give_Random());
                    crnt.add(x);
                }

                else {
                    char nm_ch = (char)ascii_name;
                    name = Character.toString(nm_ch);
                    ascii_name++;
                    rw=3;
                    cl=3;
                    for (int i=0; i<rw; i++){
                        ArrayList<Double> x = new ArrayList<>();
                        for (int j=0; j<cl; j++){
                            x.add(1.0);
                        }
                        crnt.add(x);
                    }
                }

                System.out.println(name + " = ");
                print_matrix(crnt, rw, cl);

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

            else if (Opr_Input==4){
                System.out.println("Chose a Matrix: ");
                for (int i=0; i<All_Matrices.size(); i++){
                    System.out.print(All_Matrices.get(i).getName() + " ");
                }
                System.out.println("");
                String x = scn.readLine();
                matrix crnt = null;

                for (int i=0; i<All_Matrices.size(); i++){
                    if (x.equals(All_Matrices.get(i).getName())){
                        crnt = All_Matrices.get(i);
                        break;
                    }
                }

                if (crnt == null){
                    System.out.println("No such matrix with given Name!!");
                    continue;
                }

                ArrayList<ArrayList<Double>> grd = crnt.getGrid();
                Integer bsc = crnt.getMatType();
                Integer rw = crnt.getRow();
                Integer cl = crnt.getColumn();

                ArrayList<Integer> label_types = Check_Labels(grd, bsc, rw, cl);

                for (int i=0; i< label_types.size(); i++){
                    Integer xxi = label_types.get(i);
                    if (xxi==1){
                        System.out.println("Rectangular Matrx");
                    }
                    else if (xxi==2){
                        System.out.println("Row Matrix");
                    }
                    else if (xxi==3){
                        System.out.println("Column Matrix");
                    }
                    else if (xxi==4){
                        System.out.println("Ones Matrix");
                    }
                    else if (xxi==5){
                        System.out.println("Null Matrix");
                    }
                    else if (xxi==6){
                        System.out.println("Square Matrix");
                    }
                    else if (xxi==7){
                        System.out.println("Singular Matrix");
                    }
                    else if (xxi==8){
                        System.out.println("Singleton Matrix");
                    }
                    else if (xxi==9){
                        System.out.println("Symmetric Matrix");
                    }
                    else if (xxi==10){
                        System.out.println("Diagonal Matrix");
                    }
                    else if (xxi==11){
                        System.out.println("Scalar Matrix");
                    }
                    else if (xxi==12){
                        System.out.println("Identity Matrix");
                    }
                    else if (xxi==13){
                        System.out.println("Skew-Symmetric Matrix");
                    }
                    else if (xxi==14){
                        System.out.println("Upper-Triangular Matrix");
                    }
                    else {
                        System.out.println("Lower-Triangular Matrix");
                    }
                }

            }

            else if (Opr_Input==3){
                System.out.println("Chose a Matrix: ");
                for (int i=0; i<All_Matrices.size(); i++){
                    System.out.print(All_Matrices.get(i).getName() + " ");
                }
                System.out.println("");
                String x = scn.readLine();
                matrix crnt = null;

                for (int i=0; i<All_Matrices.size(); i++){
                    if (x.equals(All_Matrices.get(i).getName())){
                        crnt = All_Matrices.get(i);
                        break;
                    }
                }

                if (crnt == null){
                    System.out.println("No such matrix with given Name!!");
                    continue;
                }
                ArrayList<ArrayList<Double>> grd_init = crnt.getGrid();
                Integer bsc_init = crnt.getMatType();
                Integer rw = crnt.getRow();
                Integer cl = crnt.getColumn();

                ArrayList<Integer> label_types_initial = Check_Labels(grd_init, bsc_init, rw, cl);

                System.out.println("Enter New Matrix: ");

                ArrayList<ArrayList<Double>> grd_new = new ArrayList<>();

                for (int i=0; i<rw; i++){
                    ArrayList<Double> xrr = new ArrayList<>();
                    String[] ln1 = scn.readLine().split(" ");

                    for (int j=0; j<cl; j++){
                        xrr.add(Double.parseDouble(ln1[j]));
                    }

                    grd_new.add(xrr);
                }

                ArrayList<Integer> label_types_new = new ArrayList<>();
                if (rw!=cl){
                    if (Check_Ones(grd_new, rw, cl)){
                        matrix mtx = new OnesMat();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }

                    else if (Check_Null(grd_new, rw, cl)){
                        matrix mtx = new NullMat();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }

                    else if (cl==1){
                        matrix mtx = new RowMat();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }

                    else if (rw==1){
                        matrix mtx = new ColumnMat();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }

                    else{
                        matrix mtx = new matrix();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }


                }

                else{
                    if (Check_Ones(grd_new, rw, cl)){
                        matrix mtx = new OnesMat();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }

                    else if (Check_Null(grd_new, rw, cl)){
                        matrix mtx = new NullMat();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }

                    else if (rw==1){
                        matrix mtx = new SingletonMat();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }

                    else if (Check_SkewSymmetric(grd_new, rw)){
                        matrix mtx = new SkewSymmetricMat();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }

                    else if (Check_Symmetric(grd_new, rw)){
                        if (check_upper(grd_new) && check_lower(grd_new)){
                            if (rw==2){
                                if (Math.abs(grd_new.get(0).get(0) - grd_new.get(1).get(1)) <= 1e-6){
                                    if (grd_new.get(0).get(0)==1.0){
                                        matrix mtx = new IndentityMat();
                                        mtx.setGrid(grd_new);
                                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                                        //All_Matrices.add(mtx);
                                        //continue;
                                    }
                                    else{
                                        matrix mtx = new ScalarMat();
                                        mtx.setGrid(grd_new);
                                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                                        //All_Matrices.add(mtx);
                                        //continue;
                                    }
                                }
                                else{
                                    matrix mtx = new DiagnolMat();
                                    mtx.setGrid(grd_new);
                                    label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                                    //All_Matrices.add(mtx);
                                    //continue;
                                }
                            }

                            else if(rw==3){
                                if ((Math.abs(grd_new.get(0).get(0) - grd_new.get(1).get(1)) <= 1e-6) && (Math.abs(grd_new.get(0).get(0) - grd_new.get(2).get(2)) <= 1e-6)){
                                    if (grd_new.get(0).get(0)==1.0){
                                        matrix mtx = new IndentityMat();
                                        mtx.setGrid(grd_new);
                                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                                        //All_Matrices.add(mtx);
                                        //continue;
                                    }
                                    else{
                                        matrix mtx = new ScalarMat();
                                        mtx.setGrid(grd_new);
                                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                                        //All_Matrices.add(mtx);
                                        //continue;
                                    }
                                }
                                else{
                                    matrix mtx = new DiagnolMat();
                                    mtx.setGrid(grd_new);
                                    label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                                    //All_Matrices.add(mtx);
                                    //continue;
                                }
                            }
                        }

                        else{
                            matrix mtx = new SymmetricMat();
                            mtx.setGrid(grd_new);
                            label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                            //All_Matrices.add(mtx);
                            //continue;
                        }
                    }

                    else if (Determinant(grd_new, rw)==0.0){
                        matrix mtx = new SingularMat();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }

                    else{
                        matrix mtx = new SquareMat();
                        mtx.setGrid(grd_new);
                        label_types_new = Check_Labels(grd_new, mtx.getMatType(), rw, cl);
                        //All_Matrices.add(mtx);
                        //continue;
                    }


                }

                if (!Check_Array_all(label_types_initial, label_types_new)){
                    System.out.println("Cannot change matrix label");
                    continue;
                }

                crnt.setGrid(grd_new);

                System.out.println(crnt.getName() + " = ");
                print_matrix(crnt.getGrid(), rw, cl);



            }

            else if (Opr_Input==5){
                System.out.println("Select Operation: ");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");

                System.out.print("Option: ");

                Integer opt_in = Integer.parseInt(scn.readLine());

                if (opt_in>4 || opt_in<1){
                    System.out.println("Invalid Operation");
                    continue;
                }

                else if (opt_in==1){
                    System.out.println("Chose Matrices: ");
                    for (int i=0; i<All_Matrices.size(); i++){
                        System.out.print(All_Matrices.get(i).getName() + " ");
                    }
                    System.out.println("");
                    String[] x = scn.readLine().split(" ");
                    matrix Acrnt = null;
                    matrix Bcrnt = null;

                    for (int i=0; i<All_Matrices.size(); i++){
                        if (x[0].equals(All_Matrices.get(i).getName())){
                            Acrnt = All_Matrices.get(i);
                            break;
                        }
                    }

                    if (Acrnt == null){
                        System.out.println("No such matrix with given Name!!");
                        continue;
                    }

                    for (int i=0; i<All_Matrices.size(); i++){
                        if (x[1].equals(All_Matrices.get(i).getName())){
                            Bcrnt = All_Matrices.get(i);
                            break;
                        }
                    }

                    if (Bcrnt == null){
                        System.out.println("No such matrix with given Name!!");
                        continue;
                    }

                    if ((Acrnt.getRow() != Bcrnt.getRow()) || (Acrnt.getColumn() != Bcrnt.getColumn())){
                        System.out.println("Operation cannot be Computed");
                        continue;
                    }
                    ArrayList<ArrayList<Double>> ans = Addition(Acrnt.getGrid(), Bcrnt.getGrid(), Acrnt.getRow(), Acrnt.getColumn());
                    System.out.println("ans = ");
                    print_matrix(ans, Acrnt.getRow(), Acrnt.getColumn());
                }

                else if (opt_in==2){
                    System.out.println("Chose Matrices: ");
                    for (int i=0; i<All_Matrices.size(); i++){
                        System.out.print(All_Matrices.get(i).getName() + " ");
                    }
                    System.out.println("");
                    String[] x = scn.readLine().split(" ");
                    matrix Acrnt = null;
                    matrix Bcrnt = null;

                    for (int i=0; i<All_Matrices.size(); i++){
                        if (x[0].equals(All_Matrices.get(i).getName())){
                            Acrnt = All_Matrices.get(i);
                            break;
                        }
                    }

                    if (Acrnt == null){
                        System.out.println("No such matrix with given Name!!");
                        continue;
                    }

                    for (int i=0; i<All_Matrices.size(); i++){
                        if (x[1].equals(All_Matrices.get(i).getName())){
                            Bcrnt = All_Matrices.get(i);
                            break;
                        }
                    }

                    if (Bcrnt == null){
                        System.out.println("No such matrix with given Name!!");
                        continue;
                    }

                    if ((Acrnt.getRow() != Bcrnt.getRow()) || (Acrnt.getColumn() != Bcrnt.getColumn())){
                        System.out.println("Operation cannot be Computed");
                        continue;
                    }
                    ArrayList<ArrayList<Double>> Bchng = Scalar_Multiplication(Bcrnt.getGrid(), Bcrnt.getRow(), Bcrnt.getColumn(), -1);
                    ArrayList<ArrayList<Double>> ans = Addition(Acrnt.getGrid(), Bchng, Acrnt.getRow(), Acrnt.getColumn());
                    System.out.println("ans = ");
                    print_matrix(ans, Acrnt.getRow(), Acrnt.getColumn());
                }

                else if (opt_in==3){
                    System.out.println("Chose Matrices: ");
                    for (int i=0; i<All_Matrices.size(); i++){
                        System.out.print(All_Matrices.get(i).getName() + " ");
                    }
                    System.out.println("");
                    String[] x = scn.readLine().split(" ");
                    matrix Acrnt = null;
                    matrix Bcrnt = null;

                    for (int i=0; i<All_Matrices.size(); i++){
                        if (x[0].equals(All_Matrices.get(i).getName())){
                            Acrnt = All_Matrices.get(i);
                            break;
                        }
                    }

                    if (Acrnt == null){
                        System.out.println("No such matrix with given Name!!");
                        continue;
                    }

                    for (int i=0; i<All_Matrices.size(); i++){
                        if (x[1].equals(All_Matrices.get(i).getName())){
                            Bcrnt = All_Matrices.get(i);
                            break;
                        }
                    }

                    if (Bcrnt == null){
                        System.out.println("No such matrix with given Name!!");
                        continue;
                    }

                    if (Acrnt.getColumn() != Bcrnt.getRow()){
                        System.out.println("Operation cannot be Computed");
                        continue;
                    }
                    ArrayList<ArrayList<Double>> ans = Vector_Multiplication(Acrnt.getGrid(), Bcrnt.getGrid(), Acrnt.getRow(), Acrnt.getColumn(), Bcrnt.getRow(), Bcrnt.getColumn());
                    System.out.println("ans = ");
                    print_matrix(ans, Acrnt.getRow(), Bcrnt.getColumn());
                }

                else {
                    System.out.println("Chose Matrices: ");
                    for (int i=0; i<All_Matrices.size(); i++){
                        System.out.print(All_Matrices.get(i).getName() + " ");
                    }
                    System.out.println("");
                    String[] x = scn.readLine().split(" ");
                    matrix Acrnt = null;
                    matrix Bcrnt = null;

                    for (int i=0; i<All_Matrices.size(); i++){
                        if (x[0].equals(All_Matrices.get(i).getName())){
                            Acrnt = All_Matrices.get(i);
                            break;
                        }
                    }

                    if (Acrnt == null){
                        System.out.println("No such matrix with given Name!!");
                        continue;
                    }

                    for (int i=0; i<All_Matrices.size(); i++){
                        if (x[1].equals(All_Matrices.get(i).getName())){
                            Bcrnt = All_Matrices.get(i);
                            break;
                        }
                    }

                    if (Bcrnt == null){
                        System.out.println("No such matrix with given Name!!");
                        continue;
                    }

                    if (Bcrnt.getRow()!=Bcrnt.getColumn()){
                        System.out.println("Operation cannot be Computed");
                        continue;
                    }

                    if (Determinant(Bcrnt.getGrid(), Bcrnt.getRow())==0.0){
                        System.out.println("Operation cannot be Computed");
                        continue;
                    }

                    if (Acrnt.getColumn() != Bcrnt.getRow()){
                        System.out.println("Operation cannot be Computed");
                        continue;
                    }
                    ArrayList<ArrayList<Double>> Bchng = Inverse_Matrix(Bcrnt.getGrid(), Bcrnt.getRow());
                    ArrayList<ArrayList<Double>> ans = Vector_Multiplication(Acrnt.getGrid(), Bchng, Acrnt.getRow(), Acrnt.getColumn(), Bcrnt.getRow(), Bcrnt.getColumn());
                    System.out.println("ans = ");
                    print_matrix(ans, Acrnt.getRow(), Bcrnt.getColumn());
                }
            }

            else if (Opr_Input==7){
                System.out.println("Chose a Matrix: ");
                for (int i=0; i<All_Matrices.size(); i++){
                    System.out.print(All_Matrices.get(i).getName() + " ");
                }
                System.out.println("");
                String x = scn.readLine();
                matrix crnt = null;

                for (int i=0; i<All_Matrices.size(); i++){
                    if (x.equals(All_Matrices.get(i).getName())){
                        crnt = All_Matrices.get(i);
                        break;
                    }
                }

                if (crnt == null){
                    System.out.println("No such matrix with given Name!!");
                    continue;
                }

                ArrayList<ArrayList<Double>> ans = Transpose(crnt.getGrid(), crnt.getRow(), crnt.getColumn());
                System.out.println("ans = ");
                print_matrix(ans, crnt.getColumn(), crnt.getRow());
            }

            else if (Opr_Input==8){
                System.out.println("Chose a Matrix: ");
                for (int i=0; i<All_Matrices.size(); i++){
                    System.out.print(All_Matrices.get(i).getName() + " ");
                }
                System.out.println("");
                String x = scn.readLine();
                matrix crnt = null;

                for (int i=0; i<All_Matrices.size(); i++){
                    if (x.equals(All_Matrices.get(i).getName())){
                        crnt = All_Matrices.get(i);
                        break;
                    }
                }

                if (crnt == null){
                    System.out.println("No such matrix with given Name!!");
                    continue;
                }

                if (crnt.getColumn()!=crnt.getRow()){
                    System.out.println("Cannot compute Inverse!!");
                    continue;
                }

                if (Determinant(crnt.getGrid(), crnt.getRow())==0.0){
                    System.out.println("Inverse doesn't exists!!");
                    continue;
                }

                ArrayList<ArrayList<Double>> ans = Inverse_Matrix(crnt.getGrid(), crnt.getRow());
                System.out.println("ans = ");
                print_matrix(ans, crnt.getColumn(), crnt.getRow());
            }

            else if (Opr_Input==10){
                System.out.println("Chose a Matrix: ");
                for (int i=0; i<All_Matrices.size(); i++){
                    System.out.print(All_Matrices.get(i).getName() + " ");
                }
                System.out.println("");
                String x = scn.readLine();
                matrix crnt = null;

                for (int i=0; i<All_Matrices.size(); i++){
                    if (x.equals(All_Matrices.get(i).getName())){
                        crnt = All_Matrices.get(i);
                        break;
                    }
                }

                if (crnt == null){
                    System.out.println("No such matrix with given Name!!");
                    continue;
                }

                if (crnt.getColumn()!=crnt.getRow()){
                    System.out.println("Cannot compute Determinant!!");
                    continue;
                }

                System.out.println("ans = " + Determinant(crnt.getGrid(), crnt.getRow()));
            }

            else if (Opr_Input==12){
                System.out.println("Chose a Matrix: ");
                for (int i=0; i<All_Matrices.size(); i++){
                    System.out.print(All_Matrices.get(i).getName() + " ");
                }
                System.out.println("");
                String x = scn.readLine();
                matrix crnt = null;

                for (int i=0; i<All_Matrices.size(); i++){
                    if (x.equals(All_Matrices.get(i).getName())){
                        crnt = All_Matrices.get(i);
                        break;
                    }
                }

                if (crnt == null){
                    System.out.println("No such matrix with given Name!!");
                    continue;
                }

                if (crnt.getColumn()!=crnt.getRow()){
                    System.out.println("Cannot compute A + A' !!");
                    continue;
                }

                ArrayList<ArrayList<Double>> crnt_trp = Transpose(crnt.getGrid(), crnt.getRow(), crnt.getColumn());

                ArrayList<ArrayList<Double>> ans = Addition(crnt.getGrid(), crnt_trp, crnt.getRow(), crnt.getColumn());

                System.out.println("ans = ");
                print_matrix(ans, crnt.getColumn(), crnt.getRow());
            }

            else if (Opr_Input==15){
                System.out.println("All Matrix Types: ");
                System.out.println("1. Rectangular Matrix");
                System.out.println("2. Row Matrix");
                System.out.println("3. Column Matrix");
                System.out.println("4. Square Matrix");
                System.out.println("5. Symmetric Matrix");
                System.out.println("6. Skew-Symmetric Matrix");
                System.out.println("7. Upper Triangular Matrix");
                System.out.println("8. Lower Triangular Matrix");
                System.out.println("9. Singular Matrix");
                System.out.println("10. Diagonal Matrix");
                System.out.println("11. Scalar Matrix");
                System.out.println("12. Identity Matrix");
                System.out.println("13. Singleton Matrix");
                System.out.println("14. Ones Matrix");
                System.out.println("15. Null MAtrix");
                System.out.print("Enter ID: ");
                Integer Mt_id = Integer.parseInt(scn.readLine());
                Integer real_id = 0;
                if (Mt_id==1){
                    real_id = 1;
                }
                else if(Mt_id==2){
                    real_id = 2;
                }
                else if(Mt_id==3){
                    real_id = 3;
                }
                else if(Mt_id==4){
                    real_id = 6;
                }
                else if(Mt_id==5){
                    real_id = 9;
                }
                else if(Mt_id==6){
                    real_id = 13;
                }
                else if(Mt_id==7){
                    real_id = 14;
                }
                else if(Mt_id==8){
                    real_id = 15;
                }
                else if(Mt_id==9){
                    real_id = 7;
                }
                else if(Mt_id==10){
                    real_id = 10;
                }
                else if(Mt_id==11){
                    real_id = 11;
                }
                else if(Mt_id==12){
                    real_id = 12;
                }
                else if(Mt_id==13){
                    real_id = 8;
                }
                else if(Mt_id==14){
                    real_id = 4;
                }
                else if(Mt_id==15){
                    real_id = 5;
                }
                else {
                    System.out.println("Wrong type entered!!");
                    continue;
                }

                for (int i=0; i<All_Matrices.size(); i++){
                    matrix crnt = All_Matrices.get(i);
                    ArrayList<Integer> lbl = Check_Labels(crnt.getGrid(), crnt.getMatType(), crnt.getRow(), crnt.getColumn());
                    if (lbl.contains(real_id)){
                        System.out.println(crnt.getName() + " = ");
                        print_matrix(crnt.getGrid(), crnt.getRow(), crnt.getColumn());
                    }
                }
            }

        }










        //scn.close(); uncomment after completion



    }


}
