package com.pb.trojno.hw5;

import java.util.Calendar;

public class Book {
    private String name;
    private String author;
    private int year;
    int yearCurr = Calendar.getInstance().get(Calendar.YEAR);

    public Book(String name, String author, int year){
        this(name, author);
        this.year = year;
    }

    public Book(String name, String author){
        this.name = name;
        this.author = author;
        this.year = yearCurr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void getInfo(){
        System.out.println(this.name + " " + this.author + " " + this.year);
    }

}
