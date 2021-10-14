package com.pb.trojno.hw2;
import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int operand1 = 0;
        System.out.print("Введите целое число:");
        operand1 = in.nextInt();
         //[0 -14] [15 - 35] [36 - 50] [51 - 100]
        if (operand1 >= 0 && operand1 <= 14) {System.out.println("Введенное число попадает в интервал [0 - 14]");}
        if (operand1 >= 15 && operand1 <= 35) {System.out.println("Введенное число попадает в интервал [15 - 35]");}
        if (operand1 >= 36 && operand1 <= 50) {System.out.println("Введенное число попадает в интервал [36 - 50]");}
        if (operand1 >= 51 && operand1 <= 100) {System.out.println("Введенное число попадает в интервал [51 - 100]");}
        if (operand1 < 0 || operand1 > 100) {System.out.println("Введенное число не попадает ни в один из интервалов");}

    }
}
