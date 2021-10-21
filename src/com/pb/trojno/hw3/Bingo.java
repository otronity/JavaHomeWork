package com.pb.trojno.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        //Загадываем число
        int x = random.nextInt(101);
        System.out.println( x);

        int y, tryCnt;
        boolean result = false;
        tryCnt = 0;

        while (!result){
            tryCnt++;
            System.out.print("Попытка "+ tryCnt + ": введите число от 0 до 100 (для выхода введите -1) : ");
            y = in.nextInt();

            if (y == x) {System.out.print("Ура, Вы угвдвли!!!"); result = true;}
            else {
                if (y == -1) { result = true;}
                else { if (y > x) {System.out.println("К сожалению вы не угадали, загаданное число меньше введенного. Попробуйте еще раз ;) ");}
                       if (y < x) {System.out.println("К сожалению вы не угадали, загаданное число больше введенного. Попробуйте еще раз ;) ");}
                }
            }
        }
    }
}
