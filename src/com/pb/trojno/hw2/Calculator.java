package com.pb.trojno.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        double operand1 = 0;
        double operand2 = 0;
        double operand3 = 0;
        String sign;

        System.out.print("Введите первое число:");
        operand1 = in.nextInt();
        System.out.print("Введите знак (+, -, *, /) :");
        sign = in.next();
        System.out.print("Введите второе число:");
        operand2 = in.nextInt();

        if (sign.equals("/") && (operand2 == 0)) {System.out.println("Нельзя делить на 0!");}
        else {
            switch (sign) {
                case "+":
                    operand3 = operand1 + operand2;
                    break;
                case "-":
                    operand3 = operand1 - operand2;
                    break;
                case "*":
                    operand3 = operand1 * operand2;
                    break;
                case "/":
                    operand3 = operand1 / operand2;
                    break;
                default: System.out.println("Некорректній знак, попробуйте еще раз.");
            }

            System.out.println(operand1 + sign + operand2 + "=" + operand3);
        }
    }

}
