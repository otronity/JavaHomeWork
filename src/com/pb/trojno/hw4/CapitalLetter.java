package com.pb.trojno.hw4;

import java.sql.Array;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CapitalLetter {

    static String toUpper (String str){
        String upperStr;
        upperStr = str.substring(0,1).toUpperCase() + str.substring(1);
        return upperStr;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String Phrase1, phrase2 = "";

        System.out.print("Введите строку: ");
        Phrase1 = in.nextLine();

        int i=0;
        StringTokenizer str1 = new StringTokenizer(Phrase1);
        while (str1.hasMoreElements()){
            if (i>0) {phrase2 = phrase2 + " ";}
            phrase2 = phrase2 + toUpper(str1.nextElement().toString());
            i++;
        }
        System.out.print("Итоговая строка: " + phrase2);

    }


}
