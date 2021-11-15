package com.pb.trojno.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {

    public Pants(String color, Size size, String price){
        super(color, size, price);
    }

    @Override
    public void dressMan() {
        System.out.println("джинсы: цвет " + this.getColor() +
                ",размер " + this.getSize() + ", цена " + this.getPrice());
    }

    @Override
    public void dressWomen() {
        System.out.println("джинсы: цвет " + this.getColor() +
                ",размер " + this.getSize() + ", цена " + this.getPrice());
    }
}
