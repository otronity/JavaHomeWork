package com.pb.trojno.hw5;

public class Reader {

    private String fio;
    private int ticket;
    private String facultet;
    private String birthday;
    private String phone;
    static int bookcount = 0;

    static int getBookcount(){
        return bookcount;
    }

    public Reader(String fio, int ticket, String facultet, String birthday, String phone){
        this(fio);
        this.ticket = ticket;
        this.facultet = facultet;
        this.birthday = birthday;
        this.phone = phone;
    }

    public Reader(String fio){
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public String getFacultet() {
        return facultet;
    }

    public void setFacultet(String facultet) {
        this.facultet = facultet;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void getInfo(){
        System.out.println(this.fio + " " + this.ticket + " " + this.facultet + " " + this.birthday + " " + this.phone);
    }
    //принимает количество взятых книг
    public void takeBook(int cnt){
        bookcount = bookcount + cnt;
        System.out.println(this.fio + " взял(а) " + cnt + " книг(и)");
    }

    public void takeBook(String... books){
        String booklist = "";
        for (String book : books) {
            bookcount ++;
            if(booklist != "") { booklist = booklist + ", " + book;} else {booklist = booklist + book;}
        }
        System.out.println(this.fio + " взял(а) книги: " + booklist);
    }

    public void takeBook(Book... books){
        String booklist = "";
        for (Book book : books) {
            bookcount ++;
            if(booklist != "") { booklist = booklist + ", " + book.getName() + " (" + book.getAuthor() + " " + book.getYear() + ")";}
            else {booklist = booklist + book.getName() + " (" + book.getAuthor() + " " + book.getYear() + ")";}
        }
        System.out.println(this.fio + " взял(а) книги: " + booklist);
    }


    public void returnBook(int cnt){
        bookcount = bookcount - cnt;
        System.out.println(this.fio + " вернул(а) " + cnt + " книг(и)");
    }

    public void returnBook(String... books){
        int returnbook = 0;
        String booklist = "";
        for (String book : books) {
            bookcount --;
            returnbook ++;
            if(booklist != "") { booklist = booklist + ", " + book;} else {booklist = booklist + book;}
        }
        System.out.println(this.fio + " вернул(а): " + returnbook + " книгу(и) " + booklist);
    }

    public void returnBook(Book... books){
        int returnbook = 0;
        String booklist = "";
        for (Book book : books) {
            bookcount --;
            returnbook ++;
            if(booklist != "") { booklist = booklist + ", " + book.getName() + " (" + book.getAuthor() + " " + book.getYear() + ")";}
            else {booklist = booklist + book.getName() + " (" + book.getAuthor() + " " + book.getYear() + ")";}
        }
        System.out.println(this.fio + " вернул(а) " + returnbook + " книгу(и): " + booklist);
    }
}
