package com.pb.trojno.hw3;

import java.util.Scanner;

public class BubbleMethod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = new int[10];
        boolean result = false;
        int x, cntPodmen, sumElements, sumElementsPositiv;

        //вводим значения для массива
        for (int i = 0; i < array.length; i++){
            System.out.print("Введите " + (i+1) + " значение массива: ");
            array[i] = in.nextInt();
        }
        sumElements = 0;
        sumElementsPositiv = 0;

        System.out.print("\nВведенный массив: {");
        for (int i = 0; i < array.length; i++){
            System.out.print(" " + array[i]);
            sumElements = sumElements + array[i];
            if (array[i] > 0) {sumElementsPositiv = sumElementsPositiv + array[i];}
        }
        System.out.println(" }\n");

        System.out.println("Сумма всех элементов массива = " + sumElements);
        System.out.println("Сумма всех положительных элементов массива = " + sumElementsPositiv);
        //сортируем
        while (!result) {
            cntPodmen = 0;

            for (int i = 0; i < array.length-1; i++){
                if (array[i] > array[i+1]) {
                    x = array[i];
                    array[i] = array[i+1];
                    array[i+1] = x;
                    cntPodmen++;
                }
            }

            if (cntPodmen == 0) {result = true;}

        }

        System.out.print("Отсортированный массив: {");
            for (int i = 0; i < array.length; i++){
            System.out.print(" " + array[i]);
        }
        System.out.print(" }\n");
    }
}
