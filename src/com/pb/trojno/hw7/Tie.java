package com.pb.trojno.hw7;

public class Tie extends Clothes implements ManClothes{

    public Tie(String color, Size size, String price){
        super(color, size, price);
    }

    @Override
    public void dressMan() {
        System.out.println("галстук: цвет " + this.getColor() +
                ",размер " + this.getSize() + ", цена " + this.getPrice());
    }

}
