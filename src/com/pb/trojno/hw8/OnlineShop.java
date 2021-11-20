package com.pb.trojno.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth();
        String login;
        String password;
        String confirmPassword;

        int trycnt = 3;
        int i = 1;
        int answ = 1;
        boolean result = false;

        Scanner in = new Scanner(System.in);

        System.out.println("Регистрация (3 попытки)");
        while (i <= trycnt && answ == 1) {
            answ = 0;
            System.out.print("Введите логин (должен содержать только латинские буквы и цифры): ");
            login = in.next();
            System.out.print("Введите пароль (должен содержать латинские буквы, цифры или символ подчерка): ");
            password = in.next();
            System.out.print("Повторите пароль: ");
            confirmPassword = in.next();
            try {
                auth.signUp(login, password, confirmPassword);
                result = true;
            } catch (WrongLoginException el) {
                System.out.println("Exception: " + el.getMessage());
                result = false;
            } catch (WrongPasswordException ep) {
                System.out.println("Exception: " + ep.getMessage());
                result = false;
            }
            if (!result) {
                i++;
                if (i <= trycnt) {
                    System.out.print("Попробовать еще раз (1-да, 0-нет)? ");
                    answ = in.nextInt();
                } else {
                    System.out.println("Попытки исчерпаны!");
                }
                if (answ == 0) {
                    i = 4;
                }
            } else {break;}
        }

        i = 1;
        answ = 1;

        if (result) {
            System.out.println("Авторизация (3 попытки)");
            while (i <= trycnt && answ == 1) {
                answ = 0;
                System.out.print("Введите логин: ");
                login = in.next();
                System.out.print("Введите пароль: ");
                password = in.next();
                try {
                    auth.signIn(login, password);
                } catch (WrongLoginException el) {
                    System.out.println(el.getMessage());
                    i++;
                    if (i <= trycnt) {
                        System.out.print("Попробовать еще раз (1-да, 0-нет)? ");
                        answ = in.nextInt();
                    } else {
                        System.out.println("Попытки исчерпаны!");
                    }
                    if (answ == 0) {
                        i = 4;
                    }
                }
            }
        }

    }
}
