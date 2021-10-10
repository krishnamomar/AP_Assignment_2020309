package com.aa_assignment;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        //Database starts here
        HashMap<Long, Patient> patient_list = new HashMap<>(); //unique id and patient object
        HashMap<Integer, Hospital> hospital_ids = new HashMap<>(); //unique id and hospital object
        HashMap<String, Vaccine> vaccines_list = new HashMap<>();  //vaccine name and Vaccine object
        ArrayList<Hospital> hospital_list = new ArrayList<>(); //list of hospitals
        HashMap<Integer, ArrayList<Hospital>> hospital_pincode_hash = new HashMap<>();  //pincode with list of hospitals
        HashMap<Vaccine, ArrayList<Hospital>> hospital_vaxName_hash = new HashMap<>(); //vaccine name and list of hospitals
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

                hospital_ids.put(create_ids, hspt);
                hospital_list.add(hspt);

                if (hospital_pincode_hash.containsKey(pn)){
                    (hospital_pincode_hash.get(pn)).add(hspt);
                }
                else{
                    ArrayList<Hospital> lltmph = new ArrayList<>();
                    lltmph.add(hspt);
                    hospital_pincode_hash.put(pn, lltmph);
                }

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

                if (hsid >= create_ids || hsid<100000){
                    System.out.println("Sorry, Hospital Not Found!");
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    continue;
                }

                Hospital hspt = hospital_ids.get(hsid);
                System.out.print("Enter number of Slots to be added: ");
                Integer slt = Integer.parseInt(scn.readLine());

                for (int slotss=0; slotss<slt; slotss++) {
                    System.out.print("Enter Day Number: ");
                    Integer dy = Integer.parseInt(scn.readLine());
                    System.out.print("Enter Quantity: ");
                    Integer qn = Integer.parseInt(scn.readLine());
                    HashMap<Integer, Vaccine> tmp_vax = new HashMap<>();
                    System.out.println("Select Vaccine");
                    int i = 0;
                    for (String xn : vaccines_list.keySet()) {
                        System.out.println(i + ". " + xn);
                        tmp_vax.put(i, vaccines_list.get(xn));
                        i++;
                    }
                    Integer vxnumber = Integer.parseInt(scn.readLine());

                    hspt.add_slot(tmp_vax.get(vxnumber), qn, dy);
                    System.out.println("Slot added by Hospital " + hspt.getID() + " for Day: " + dy + ", Available Quantity: " + qn + " of Vaccine " + (tmp_vax.get(vxnumber)).getName());

                    if (hospital_vaxName_hash.containsKey(tmp_vax.get(vxnumber))){
                        (hospital_vaxName_hash.get(tmp_vax.get(vxnumber))).add(hspt);
                    }
                    else{
                        ArrayList<Hospital> lltmph = new ArrayList<>();
                        lltmph.add(hspt);
                        hospital_vaxName_hash.put(tmp_vax.get(vxnumber), lltmph);
                    }
                }

                System.out.println("---------------------------------------------");
                System.out.println();

            }

            else if (inp==5) {
                Long pid;
                System.out.print("Enter patient Unique ID: ");
                pid = Long.parseLong(scn.readLine());

                if (patient_list.containsKey(pid)==false){
                    System.out.println("Citizen not Registered");
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    continue;
                }

                Patient vax_pnt = patient_list.get(pid);

                System.out.println("1. Search by Area");
                System.out.println("2. Search by Vaccine");
                System.out.println("3. Exit");
                System.out.print("Enter Option: ");
                int srh_opt = Integer.parseInt(scn.readLine());

                if (srh_opt==1){
                    System.out.print("Enter PinCode: ");
                    Integer pn = Integer.parseInt(scn.readLine());

                    if (hospital_pincode_hash.containsKey(pn)==false){
                        System.out.println("No Hospital Available at given PinCode");
                        System.out.println("---------------------------------------------");
                        System.out.println();
                        continue;
                    }

                    ArrayList<Hospital> llarh = hospital_pincode_hash.get(pn);
                    for (int hpi=0; hpi<llarh.size(); hpi++){
                        Hospital xtmp = llarh.get(hpi);
                        System.out.println(xtmp.getID() + " " + xtmp.getName());
                    }

                    System.out.print("Enter hospital ID: ");
                    Integer hsid = Integer.parseInt(scn.readLine());
                    Hospital now_hptl = hospital_ids.get(hsid);
                    ArrayList<Vaccine> hptl_vax = now_hptl.getVaccine_list();
                    ArrayList<Integer> hptl_day = now_hptl.getDay_number();
                    ArrayList<Integer> hptl_qun = now_hptl.getQuantity_day();

                    for (int slt=0; slt<hptl_vax.size(); slt++){
                        System.out.println(slt + "-> Day: " + hptl_day.get(slt) + " Available Qty: " + hptl_qun.get(slt) + " Vaccine: " + hptl_vax.get(slt).getName());

                    }

                    System.out.print("Choose Slot: ");
                    Integer xslty = Integer.parseInt(scn.readLine());

                    if (hptl_qun.get(xslty)>0) {
                        if (vax_pnt.getvaccine() == null) {
                            vax_pnt.vax = hptl_vax.get(xslty);
                            vax_pnt.doses_done = 1;
                            vax_pnt.day_of_first = hptl_day.get(xslty);
                            now_hptl.book_slot(xslty);
                            System.out.println(vax_pnt.getName() + " vaccinated with " + hptl_vax.get(xslty).getName());
                            System.out.println("---------------------------------------------");
                            System.out.println();
                            continue;
                        } else if (vax_pnt.getvaccine() != hptl_vax.get(xslty)) {
                            System.out.println("Sorry! Vaccine Mixing is Not Allowed");
                            System.out.println("---------------------------------------------");
                            System.out.println();
                            continue;
                        }
                        vax_pnt.doses_done = vax_pnt.getDoses_done() + 1;
                        now_hptl.book_slot(xslty);
                        System.out.println(vax_pnt.getName() + " vaccinated with " + hptl_vax.get(xslty).getName());
                        System.out.println("---------------------------------------------");
                        System.out.println();
                        continue;
                    }

                    else {
                        System.out.println("No Slots Available");
                        System.out.println("---------------------------------------------");
                        System.out.println();
                        continue;
                    }

                }

                else if (srh_opt==2){
                    System.out.print("Enter Vaccine name: ");
                    String vaxnme = scn.readLine();
                    Vaccine vv_now = vaccines_list.get(vaxnme);

                    if (hospital_vaxName_hash.containsKey(vv_now)==false){
                        System.out.println("No Hospital Available at given Vaccine");
                        System.out.println("---------------------------------------------");
                        System.out.println();
                        continue;
                    }

                    ArrayList<Hospital> llarh = hospital_vaxName_hash.get(vv_now);
                    for (int hpi=0; hpi<llarh.size(); hpi++){
                        Hospital xtmp = llarh.get(hpi);
                        System.out.println(xtmp.getID() + " " + xtmp.getName());
                    }

                    System.out.print("Enter hospital ID: ");
                    Integer hsid = Integer.parseInt(scn.readLine());
                    Hospital now_hptl = hospital_ids.get(hsid);
                    ArrayList<Vaccine> hptl_vax = now_hptl.getVaccine_list();
                    ArrayList<Integer> hptl_day = now_hptl.getDay_number();
                    ArrayList<Integer> hptl_qun = now_hptl.getQuantity_day();

                    for (int slt=0; slt<hptl_vax.size(); slt++){
                        System.out.println(slt + "-> Day: " + hptl_day.get(slt) + " Available Qty: " + hptl_qun.get(slt) + " Vaccine: " + hptl_vax.get(slt).getName());

                    }

                    System.out.print("Choose Slot: ");
                    Integer xslty = Integer.parseInt(scn.readLine());

                    if (hptl_qun.get(xslty)>0) {
                        if (vax_pnt.getvaccine() == null) {
                            vax_pnt.vax = hptl_vax.get(xslty);
                            vax_pnt.doses_done = 1;
                            vax_pnt.day_of_first = hptl_day.get(xslty);
                            now_hptl.book_slot(xslty);
                            System.out.println(vax_pnt.getName() + " vaccinated with " + hptl_vax.get(xslty).getName());
                            System.out.println("---------------------------------------------");
                            System.out.println();
                            continue;
                        } else if (vax_pnt.getvaccine() != hptl_vax.get(xslty)) {
                            System.out.println("Sorry! Vaccine Mixing is Not Allowed");
                            System.out.println("---------------------------------------------");
                            System.out.println();
                            continue;
                        }
                        vax_pnt.doses_done = vax_pnt.getDoses_done() + 1;
                        vax_pnt.day_of_first = hptl_day.get(xslty);
                        now_hptl.book_slot(xslty);
                        System.out.println(vax_pnt.getName() + " vaccinated with " + hptl_vax.get(xslty).getName());
                        System.out.println("---------------------------------------------");
                        System.out.println();
                        continue;
                    }
                    else {
                        System.out.println("No Slots Available");
                        System.out.println("---------------------------------------------");
                        System.out.println();
                        continue;
                    }

                }

                else {
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    continue;
                }
            }

            else if (inp==6) {
                System.out.print("Enter Hospital ID: ");
                Integer hsid = Integer.parseInt(scn.readLine());

                if (hospital_ids.containsKey(hsid)==false){
                    System.out.println("Sorry, Hospital Not Found");
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    continue;
                }

                Hospital hptxl = hospital_ids.get(hsid);
                ArrayList<Vaccine> hst_vax = hptxl.getVaccine_list();
                ArrayList<Integer> hst_day = hptxl.getDay_number();
                ArrayList<Integer> hst_qnt = hptxl.getQuantity_day();

                for (int hi=0; hi<hst_vax.size(); hi++){
                    System.out.println("Day: " + hst_day.get(hi) + " Vaccine: " + hst_vax.get(hi).getName() + " Available Qty: " + hst_qnt.get(hi));

                }

                System.out.println("---------------------------------------------");
                System.out.println();
            }

            else if (inp==7){
                System.out.print("Enter Patient ID: ");
                Long pit = Long.parseLong(scn.readLine());

                if (patient_list.containsKey(pit)==false){
                    System.out.println("Citizen NOT-REGISTERED");
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    continue;
                }

                Patient pntx = patient_list.get(pit);

                if (pntx.getvaccine()==null){
                    System.out.println("Citizen REGISTERED");
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    continue;
                }

                Vaccine pnt_vax = pntx.getvaccine();

                if (pnt_vax.getNoDoses() > pntx.getDoses_done()){
                    System.out.println("PARTIALLY VACCINATED");
                    System.out.println("Vaccine Given: " + pnt_vax.getName());
                    System.out.println("Number of Doses given: " + pntx.getDoses_done());
                    Integer ztmp = pnt_vax.getDoseGap() + pntx.getDay_of_first();
                    System.out.println("Next Dose due date: " + ztmp);
                    System.out.println("---------------------------------------------");
                    System.out.println();
                }

                else{
                    System.out.println("FULLY VACCINATED");
                    System.out.println("Vaccine Given: " + pnt_vax.getName());
                    System.out.println("Number of Doses given: " + pntx.getDoses_done());
                    System.out.println("---------------------------------------------");
                    System.out.println();
                }
            }

            else{
                System.out.println("Menu Option Doesn't Exist");
                System.out.println("---------------------------------------------");
                System.out.println();
            }


        }

        scn.close(); //closing the buffer reader

    }
}
