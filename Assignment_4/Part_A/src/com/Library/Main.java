package com.Library;

import java.lang.*;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
	// write your code here

        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Library");
        System.out.println("=============================================");
        System.out.println("");

        BookRack<Book> Book_Rack = new BookRack<>();

        System.out.println("Enter the Number of Books (N) and Number of Racks (K) : ");
        System.out.println("*note: N should be perfectly devisible by K else last few books will have no slot left to be placed");
        System.out.print("N: ");
        Integer N = Integer.parseInt(scn.readLine());
        System.out.print("K: ");
        Integer K = Integer.parseInt(scn.readLine());
        System.out.println("=============================================");
        System.out.println("");

        System.out.println("Enter all the Book Details: ");
        System.out.println("");
        for (int i=1; i<=N; i++){
            System.out.println(i + ": ");
            System.out.print("Enter Book Title: ");
            String name = scn.readLine();
            System.out.print("Enter ISBN: ");
            String Isbn = scn.readLine();
            System.out.print("Enter Barcode Number: ");
            Long barcode = Long.parseLong(scn.readLine());

            Book bko = new Book();
            bko.setName(name);
            bko.setBar_Code(barcode);
            bko.setISBN_number(Isbn);

            Book_Rack.addBook(bko);

        }

        System.out.println("");
        System.out.println("Sorting The Rack, Please StandBy!");
        System.out.println("");

        Book_Rack.Sort_();

        System.out.println("Rack has Been Sorted");
        System.out.println("=============================================");

        System.out.println("Showing the Rack: ");

        ArrayList<Book> the_rack = Book_Rack.getRacks();

        int str = 0;
        int X = N/K;
        for (int i=1; i<=K; i++){
            System.out.print("Rack " + i + ": | ");
            for (int j=0; j<X; j++){
                System.out.print(the_rack.get(str+j).getName() + " | ");
            }
            System.out.println("");
            str += X;
        }

        if (N%K!=0){
            System.out.print("Books with no slot: | ");
            for (int j=str; j< the_rack.size(); j++){
                System.out.print(the_rack.get(j).getName() + " | ");
            }
            System.out.println("");
        }

        System.out.println("=============================================");

        System.out.println("Thank You!");

        scn.close();
    }
}
