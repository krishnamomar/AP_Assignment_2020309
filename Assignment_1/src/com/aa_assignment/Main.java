package com.aa_assignment;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        //Database starts here
        HashMap<Long, Patient> patient_list = new HashMap<>();
        HashMap<Integer, Hospital> hospital_pin = new HashMap<>();
        HashMap<Integer, Hospital> hospital_ids = new HashMap<>();
        HashMap<String, Vaccine> vaccines_list = new HashMap<>();
        Integer create_ids = 100000;
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
                    gp = 0;
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

                System.out.println("Vaccine Name: " + vax.getName() + ", Number of Doses: " + vax.getNoDoses() + ", Gap Between Doses: " + vax.getDoseGap());
                System.out.println("---------------------------------------------");
                System.out.println();
            }

            else if (inp==2){
                String nn;
                Integer pn;
                System.out.print("Hospital Name: ");
                nn = scn.readLine();
                System.out.print("PinCode: ");
                pn = Integer.parseInt(scn.readLine());

                Hospital hspt = new Hospital();
                hspt.Name = nn;
                hspt.PinCode = pn;
                hspt.Hosp_iD = create_ids;

                hospital_pin.put(pn, hspt);
                hospital_ids.put(create_ids, hspt);

                create_ids +=1;

                System.out.println("Hospital Name: " + hspt.getName() + ", PinCode: " + hspt.getPin() + ", Unique ID: " + hspt.getID());
                System.out.println("---------------------------------------------");
                System.out.println();
            }

            else if (inp==3){
                String nn;
                Integer ag;
                Long ui;
                System.out.print("Citizen Name: ");
                nn = scn.readLine();
                System.out.print("Age: ");
                ag = Integer.parseInt(scn.readLine());
                System.out.print("Unique ID: ");
                ui = Long.parseLong(scn.readLine());

                if (ag<18){
                    System.out.println("Citizen Name: " + nn + ", Age: " + ag + ", Unique ID: " + ui);
                    System.out.println("Only above 18 are allowed");
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    continue;
                }

                Patient pnt = new Patient();
                pnt.name = nn;
                pnt.age = ag;
                pnt.unqID = ui;

                patient_list.put(ui, pnt);

                System.out.println("Citizen Name: " + pnt.getName() + ", Age: " + pnt.getAge() + ", Unique ID: " + pnt.getUnqID());
                System.out.println("---------------------------------------------");
                System.out.println();

            }

            else if (inp==4){
                Integer hsid;
                System.out.print("Enter Hospital ID: ");
                hsid = Integer.parseInt(scn.readLine());

                if (hsid<=create_ids){
                    System.out.println("Sorry, Hospital Not Found!");
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    continue;
                }
            }





            //break;
        }



        //scn.close(); call in the last

    }
}
