package com.Library;

import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
	// write your code here

        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Library");
        System.out.println("=============================================");
        System.out.println("");

        BookRack<Book> Book_Rack = new BookRack<>();

        System.out.println("Enter the Number of Books (N) and Number of Racks (K) : ");
        System.out.print("N: ");
        Integer N = Integer.parseInt(scn.readLine());
        System.out.print("K: ");
        Integer K = Integer.parseInt(scn.readLine());
        System.out.println("=============================================");
        System.out.println("");

        System.out.println("Enter all the Book Details: ");
        System.out.println("");
        for (int i=1; i<=N; i++){
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



        scn.close();
    }
}
