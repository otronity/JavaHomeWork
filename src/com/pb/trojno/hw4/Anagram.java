package com.pb.trojno.hw4;

import java.util.Locale;
import java.util.Scanner;

public class Anagram {

    static int num (String charecter, String phrase){
        int count = 0;
        for (int i = 0; i < phrase.length(); i++){
             if (phrase.substring(i,i+1).equals(charecter)) count++;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String Phrase1, Phrase2, Phrase1Char, Phrase2Char;
        boolean resultCompare = true;

        System.out.print("Введите первую фразу: ");
        Phrase1 = in.nextLine();
        System.out.print("Введите вторую фразу: ");
        Phrase2 = in.nextLine();

        Phrase1Char = Phrase1.replaceAll("[^а-яА-Я]", "").toLowerCase();
        Phrase2Char = Phrase2.replaceAll("[^а-яА-Я]", "").toLowerCase();

        int numchar1 = Phrase1Char.length();
        int numchar2 = Phrase2Char.length();

        if (numchar1 != numchar2) {resultCompare = false;}

        if (resultCompare) {
            for (int i = 0; i < Phrase1Char.length(); i++) {
                int num1 = 0, num2 = 0;
                String character = Phrase1Char.substring(i, i+1);
                num1 = num(character, Phrase1Char);
                num2 = num(character, Phrase2Char);
                if (num1 != num2) {
                    resultCompare = false;
                }
            }
        }
        if (resultCompare) {System.out.println("Фразы являются анаграммами друг друга");}
            else {System.out.println("Фразы НЕ являются анаграммами друг друга");}
    }


}

