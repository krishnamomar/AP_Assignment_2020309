package com.aa_assignment;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        //Database starts here
        HashMap<Integer, Patient> patient_list = new HashMap<>();
        HashMap<String, Hospital> hospital_name = new HashMap<>();
        HashMap<Integer, Hospital> hospital_pin = new HashMap<>();
        ArrayList<Integer> hospital_ids = new ArrayList<>();
        HashMap<String, Vaccine> vaccines_list = new HashMap<>();
        //Database ends here

        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("CoVin Portal Initialized....");
        System.out.println("=============================================");

        while (true){
            System.out.println("Menu Options: ");
            System.out.println();
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all Slots for a Hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------------------");

            //input
            Integer inp = Integer.parseInt(scn.readLine());

            //main if else working
            if (inp==8){
                System.out.println("Thank You for using CoVin Platform");
                System.out.println("---------------------------------------------");
                break;
            }

            else if (inp==1){
                String nn;
                Integer gp;
                Integer ds;
                System.out.print("Vaccine Name: ");
                nn = scn.readLine();
                System.out.print("Number of Doses: ");
                ds = Integer.parseInt(scn.readLine());
                if (ds==1){
                    gp = 1;
                }
                else{
                    System.out.print("Gap between Doses: ");
                    gp = Integer.parseInt(scn.readLine());
                }

                Vaccine vax = new Vaccine();
                vax.name = nn;
                vax.no_of_doses = ds;
                vax.gap_dose = gp;

                vaccines_list.put(nn, vax);
            }



            //break;
        }



        //scn.close(); call in the last

    }
}
