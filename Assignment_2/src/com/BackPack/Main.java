package com.BackPack;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {

    public static String date_generator() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        String strDate = formatter.format(date);

        return strDate;
    }

    public static void main(String[] args) throws IOException{
	// write your code here
    }
}
