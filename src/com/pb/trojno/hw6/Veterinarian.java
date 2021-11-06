package com.pb.trojno.hw6;

public class Veterinarian {

    public void treatAnimal(Animal animal){
        System.out.println("Животное ест " + animal.getFood() + ", живет в " + animal.getLocation() + ".");
    }

}
