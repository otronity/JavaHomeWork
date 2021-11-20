package com.pb.trojno.hw8;

public class Auth {

    public String login;
    public String password;

    public void signUp (String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        if (login.length() >= 5 && login.length() <= 20 && login.matches("[0-9a-zA-Z]+")) {
            this.login = login;
            if (password.length() > 5 && password.matches("[0-9a-zA-Z_]+") && password.equals(confirmPassword)) {
                this.password = password;
                System.out.println("Вы зарегистрированы!");
            } else {
                throw new WrongPasswordException("Пароль должен содержать латинские буквы цифры или символ подчерка, либо пароли не сопадают.");
            }
        } else {
            throw new WrongLoginException("Логин некорректный (должен содержать латинские буквы и цифры).");
        }
    }

    public void signIn (String login, String password) throws WrongLoginException {
        if (this.login.equals(login) && this.password.equals(password)) {
            System.out.println(login + " вошел.");
        } else {throw new WrongLoginException("Логин или пароль не совпадают!");}
    }

}
