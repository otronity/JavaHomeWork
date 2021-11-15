package com.pb.trojno.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {

    public Tshirt(String color, Size size, String price){
        super(color, size, price);
    }

    @Override
    public void dressMan() {
        System.out.println("футболка: цвет " + this.getColor() +
                ",размер " + this.getSize() + ", цена " + this.getPrice());
    }

    @Override
    public void dressWomen() {
        System.out.println("футболка: цвет " + this.getColor() +
                ",размер " + this.getSize() + ", цена " + this.getPrice());
    }
}
