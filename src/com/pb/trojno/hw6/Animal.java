package com.pb.trojno.hw6;

public class Animal {
    private String food;
    private String location;

    public Animal(String food, String location){
        this.food = food;
        this.location = location;
    }

    public Animal (String food){
        this.food = food;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void makeNoise(){
        System.out.println("шумит");
    }

    public void eat(){
        System.out.println("ест");
    }

    public void sleep(){
        System.out.println("спит");
    }
}
