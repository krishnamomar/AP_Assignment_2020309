package com.aa_assignment;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        //Database starts here
        ArrayList<Patient> patient_list = new ArrayList<>();
        ArrayList<Integer> patient_ids = new ArrayList<>();
        HashMap<String, Hospital> hospital_name = new HashMap<>();
        ArrayList<Integer> hospital_pin = new ArrayList<>();
        ArrayList<Integer> hospital_ids = new ArrayList<>();
        ArrayList<Vaccine> vaccine_list = new ArrayList<>();
        ArrayList<String> vaccine_name = new ArrayList<>();
        //Database ends here

        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("CoVin Portal Initialized....");
        System.out.println("=============================================");

        while (true){
            System.out.println("Menu Options: ");
            System.out.println("---------------------------------------------");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all Slots for a Hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------------------");

            Integer inp = Integer.parseInt(scn.readLine());

            //break;
        }



        //scn.close(); call in the last

    }
}
