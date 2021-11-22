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
        ArrayList<Image> All_Images = new ArrayList<>();
        int ascii_name = 97;
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
                if (inp2>2 || inp2<1){
                    System.out.println("Invalid Input!!");
                    continue;
                }

                else if (inp2==1){
                    System.out.print("Enter Size of Image (Row Column): ");
                    String[] rwcl = scn.readLine().split(" ");
                    Integer row = Integer.parseInt(rwcl[0]);
                    Integer column = Integer.parseInt(rwcl[1]);

                    ArrayList<ArrayList<Integer>> red_mat = new ArrayList<>();
                    System.out.println("Enter the Red Matrix (0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(Math.abs((Integer.parseInt(ln1[j]))%226));
                        }

                        red_mat.add(x);
                    }

                    ArrayList<ArrayList<Integer>> green_mat = new ArrayList<>();
                    System.out.println("Enter the Green Matrix(0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(Math.abs((Integer.parseInt(ln1[j]))%226));
                        }

                        green_mat.add(x);
                    }

                    ArrayList<ArrayList<Integer>> blue_mat = new ArrayList<>();
                    System.out.println("Enter the Blue Matrix(0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(Math.abs((Integer.parseInt(ln1[j]))%226));
                        }

                        blue_mat.add(x);
                    }

                    ArrayList<ArrayList<ArrayList<Integer>>> matrix = new ArrayList<>();
                    for (int i=0; i<row; i++){
                        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
                        for (int j=0; j<column; j++){
                            ArrayList<Integer> z = new ArrayList<>();
                            z.add(red_mat.get(i).get(j));
                            z.add(green_mat.get(i).get(j));
                            z.add(blue_mat.get(i).get(j));
                            x.add(z);
                        }
                        matrix.add(x);
                    }

                    Color_Image crnt_img = new Color_Image();
                    crnt_img.setRow(row);
                    crnt_img.setColumn(column);
                    crnt_img.setMatrix(matrix);

                    char nm_ch = (char)ascii_name;
                    String name = Character.toString(nm_ch);
                    ascii_name++;
                    crnt_img.setName(name);

                    All_Images.add(crnt_img);

                    Image_Printer_CL(crnt_img.getMatrix(), crnt_img.getRow(), crnt_img.getColumn(), crnt_img.getName());
                    System.out.println("");
                    continue;

                }

                else if (inp2==2){
                    System.out.print("Enter Size of Image (Row Column): ");
                    String[] rwcl = scn.readLine().split(" ");
                    Integer row = Integer.parseInt(rwcl[0]);
                    Integer column = Integer.parseInt(rwcl[1]);

                    ArrayList<ArrayList<Integer>> gray_mat = new ArrayList<>();
                    System.out.println("Enter the Grayscale Matrix(0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(Math.abs((Integer.parseInt(ln1[j]))%226));
                        }

                        gray_mat.add(x);
                    }

                    BW_Image crnt_img = new BW_Image();
                    crnt_img.setRow(row);
                    crnt_img.setColumn(column);
                    crnt_img.setMatrix(gray_mat);

                    char nm_ch = (char)ascii_name;
                    String name = Character.toString(nm_ch);
                    ascii_name++;
                    crnt_img.setName(name);

                    All_Images.add(crnt_img);

                    Image_Printer_BW(crnt_img.getMatrix(), crnt_img.getRow(), crnt_img.getColumn(), crnt_img.getName());
                    System.out.println("");
                    continue;
                }

            }

            else if (INP1==2){
                System.out.println("Enter Image Type: ");
                System.out.println("1. Coloured");
                System.out.println("2. Grayscale");
                Integer inp2 = Integer.parseInt(scn.readLine());
                if (inp2>2 || inp2<1){
                    System.out.println("Invalid Input!!");
                    continue;
                }

                else if (inp2==1){
                    System.out.print("Enter Size of Image (Row Column): ");
                    String[] rwcl = scn.readLine().split(" ");
                    Integer row = Integer.parseInt(rwcl[0]);
                    Integer column = Integer.parseInt(rwcl[1]);
                    System.out.println("Creating Default Image");

                    ArrayList<ArrayList<Integer>> red_mat = new ArrayList<>();
                    //System.out.println("Enter the Red Matrix (0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        //String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(0);
                        }

                        red_mat.add(x);
                    }

                    ArrayList<ArrayList<Integer>> green_mat = new ArrayList<>();
                    //System.out.println("Enter the Green Matrix(0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        //String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(0);
                        }

                        green_mat.add(x);
                    }

                    ArrayList<ArrayList<Integer>> blue_mat = new ArrayList<>();
                    //System.out.println("Enter the Blue Matrix(0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        //String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(0);
                        }

                        blue_mat.add(x);
                    }

                    ArrayList<ArrayList<ArrayList<Integer>>> matrix = new ArrayList<>();
                    for (int i=0; i<row; i++){
                        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
                        for (int j=0; j<column; j++){
                            ArrayList<Integer> z = new ArrayList<>();
                            z.add(red_mat.get(i).get(j));
                            z.add(green_mat.get(i).get(j));
                            z.add(blue_mat.get(i).get(j));
                            x.add(z);
                        }
                        matrix.add(x);
                    }

                    Color_Image crnt_img = new Color_Image();
                    crnt_img.setRow(row);
                    crnt_img.setColumn(column);
                    crnt_img.setMatrix(matrix);

                    char nm_ch = (char)ascii_name;
                    String name = Character.toString(nm_ch);
                    ascii_name++;
                    crnt_img.setName(name);

                    All_Images.add(crnt_img);

                    Image_Printer_CL(crnt_img.getMatrix(), crnt_img.getRow(), crnt_img.getColumn(), crnt_img.getName());
                    System.out.println("");
                    continue;

                }

                else if (inp2==2){
                    System.out.print("Enter Size of Image (Row Column): ");
                    String[] rwcl = scn.readLine().split(" ");
                    Integer row = Integer.parseInt(rwcl[0]);
                    Integer column = Integer.parseInt(rwcl[1]);
                    System.out.println("Creating Default Image");

                    ArrayList<ArrayList<Integer>> gray_mat = new ArrayList<>();
                    //System.out.println("Enter the Grayscale Matrix(0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        //String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(0);
                        }

                        gray_mat.add(x);
                    }

                    BW_Image crnt_img = new BW_Image();
                    crnt_img.setRow(row);
                    crnt_img.setColumn(column);
                    crnt_img.setMatrix(gray_mat);

                    char nm_ch = (char)ascii_name;
                    String name = Character.toString(nm_ch);
                    ascii_name++;
                    crnt_img.setName(name);

                    All_Images.add(crnt_img);

                    Image_Printer_BW(crnt_img.getMatrix(), crnt_img.getRow(), crnt_img.getColumn(), crnt_img.getName());
                    System.out.println("");
                    continue;
                }

            }

            else if (INP1==3){
                System.out.println("Chose an Image: ");
                for (int i=0; i<All_Images.size(); i++){
                    System.out.print(All_Images.get(i).getName() + " ");
                }
                System.out.println("");
                String xname = scn.readLine();
                Image crnt_img = null;

                for (int i=0; i<All_Images.size(); i++){
                    if (xname.equals(All_Images.get(i).getName())){
                        crnt_img = All_Images.get(i);
                        break;
                    }
                }

                if (crnt_img == null){
                    System.out.println("No such image with given Name!!");
                    continue;
                }

                if (crnt_img instanceof Color_Image){
                    Integer row = crnt_img.getRow();
                    Integer column = crnt_img.getColumn();

                    ArrayList<ArrayList<Integer>> red_mat = new ArrayList<>();
                    System.out.println("Enter the Red Matrix (0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(Math.abs((Integer.parseInt(ln1[j]))%226));
                        }

                        red_mat.add(x);
                    }

                    ArrayList<ArrayList<Integer>> green_mat = new ArrayList<>();
                    System.out.println("Enter the Green Matrix(0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(Math.abs((Integer.parseInt(ln1[j]))%226));
                        }

                        green_mat.add(x);
                    }

                    ArrayList<ArrayList<Integer>> blue_mat = new ArrayList<>();
                    System.out.println("Enter the Blue Matrix(0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(Math.abs((Integer.parseInt(ln1[j]))%226));
                        }

                        blue_mat.add(x);
                    }

                    ArrayList<ArrayList<ArrayList<Integer>>> matrix = new ArrayList<>();
                    for (int i=0; i<row; i++){
                        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
                        for (int j=0; j<column; j++){
                            ArrayList<Integer> z = new ArrayList<>();
                            z.add(red_mat.get(i).get(j));
                            z.add(green_mat.get(i).get(j));
                            z.add(blue_mat.get(i).get(j));
                            x.add(z);
                        }
                        matrix.add(x);
                    }

                    ((Color_Image) crnt_img).setMatrix(matrix);

                    Image_Printer_CL(((Color_Image) crnt_img).getMatrix(), crnt_img.getRow(), crnt_img.getColumn(), crnt_img.getName());
                    System.out.println("");
                    continue;

                }

                else if (crnt_img instanceof BW_Image){
                    Integer row = crnt_img.getRow();
                    Integer column = crnt_img.getColumn();

                    ArrayList<ArrayList<Integer>> gray_mat = new ArrayList<>();
                    System.out.println("Enter the Grayscale Matrix (0-255, else will be adjusted accordingly): ");
                    for (int i=0; i<row; i++){
                        ArrayList<Integer> x = new ArrayList<>();
                        String[] ln1 = scn.readLine().split(" ");

                        for (int j=0; j<column; j++){
                            x.add(Math.abs((Integer.parseInt(ln1[j]))%226));
                        }

                        gray_mat.add(x);
                    }


                    ((BW_Image) crnt_img).setMatrix(gray_mat);

                    Image_Printer_BW(((BW_Image) crnt_img).getMatrix(), crnt_img.getRow(), crnt_img.getColumn(), crnt_img.getName());
                    System.out.println("");
                    continue;

                }

                else {
                    System.out.println("Instance Error ");
                    continue;
                }


            }

            else if (INP1==4){
                System.out.println("Chose an Image: ");
                for (int i=0; i<All_Images.size(); i++){
                    System.out.print(All_Images.get(i).getName() + " ");
                }
                System.out.println("");
                String xname = scn.readLine();
                Image crnt_img = null;

                for (int i=0; i<All_Images.size(); i++){
                    if (xname.equals(All_Images.get(i).getName())){
                        crnt_img = All_Images.get(i);
                        break;
                    }
                }

                if (crnt_img == null){
                    System.out.println("No such image with given Name!!");
                    continue;
                }

                if (crnt_img instanceof Color_Image){
                    Image_Printer_CL(((Color_Image) crnt_img).getMatrix(), crnt_img.getRow(), crnt_img.getColumn(), crnt_img.getName());
                    System.out.println("");
                    continue;
                }

                else if (crnt_img instanceof BW_Image){
                    Image_Printer_BW(((BW_Image) crnt_img).getMatrix(), crnt_img.getRow(), crnt_img.getColumn(), crnt_img.getName());
                    System.out.println("");
                    continue;
                }

                else {
                    System.out.println("Instance Error ");
                    continue;
                }


            }

            else {
                System.out.println("Chose an Image: ");
                for (int i=0; i<All_Images.size(); i++){
                    System.out.print(All_Images.get(i).getName() + " ");
                }
                System.out.println("");
                String xname = scn.readLine();
                Image crnt_img = null;

                for (int i=0; i<All_Images.size(); i++){
                    if (xname.equals(All_Images.get(i).getName())){
                        crnt_img = All_Images.get(i);
                        break;
                    }
                }

                if (crnt_img == null){
                    System.out.println("No such image with given Name!!");
                    continue;
                }

                if (crnt_img instanceof Color_Image){
                    ArrayList<ArrayList<ArrayList<Integer>>> imgct = Compute_Inverse_CL(((Color_Image) crnt_img).getMatrix(), crnt_img.getRow(), crnt_img.getColumn());
                    Image_Printer_CL(imgct, crnt_img.getRow(), crnt_img.getColumn(), crnt_img.getName());
                    System.out.println("");
                    continue;
                }

                else if (crnt_img instanceof BW_Image){
                    ArrayList<ArrayList<Integer>> imgct = Compute_Inverse_BW(((BW_Image) crnt_img).getMatrix(), crnt_img.getRow(), crnt_img.getColumn());
                    Image_Printer_BW(imgct, crnt_img.getRow(), crnt_img.getColumn(), crnt_img.getName());
                    System.out.println("");
                    continue;
                }

                else {
                    System.out.println("Instance Error ");
                    continue;
                }


            }

        }

        scn.close();

    }
}
