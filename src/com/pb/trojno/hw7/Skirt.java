package com.pb.trojno.hw7;

public class Skirt extends Clothes implements WomenClothes {

    public Skirt(String color, Size size, String price){
        super(color, size, price);
    }

    @Override
    public void dressWomen() {
        System.out.println("юбка: цвет " + this.getColor() +
                ",размер " + this.getSize() + ", цена " + this.getPrice());
    }
}
