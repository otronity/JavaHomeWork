package com.pb.trojno.hw11;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import sun.plugin2.message.Serializer;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

 class PhoneBook implements Comparable<PhoneBook>, Serializable {

    String fio;
    String birthDate;
    ArrayList<String> phonesnum = new ArrayList<>();
    String address;
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    LocalDateTime dlm;

    public PhoneBook(String fio, String birthDate, List<String> phonesnum,
                     String address, LocalDateTime dlm){
        this.fio = fio;
        this.birthDate = birthDate;
        for (String pn : phonesnum){ this.phonesnum.add(pn);}
        this.address = address;
        this.dlm = dlm;
    }

    public PhoneBook(String fio){
        this.fio = fio;
    }

     public String getFio() {
         return fio;
     }

     public String getAddress() {
         return address;
     }

     public String getBirthDate() {
         return birthDate;
     }

     public LocalDateTime getDlm() {
         return dlm;
     }

     public ArrayList<String> getPhonesnum() {
         return phonesnum;
     }

     @Override
    public String toString() {
        return "PhoneBook{" +
                "fio='" + fio + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phonesnum=" + phonesnum.toString() +
                ", address=" + address +
                ", dlm=" + dlm +
                '}';
    }

    @Override
     public int compareTo(PhoneBook o){
        return 0;
    }

     public PhoneBook setFio(String fio) {
         this.fio = fio;
         this.dlm = LocalDateTime.now();
         return this;
     }
 }
