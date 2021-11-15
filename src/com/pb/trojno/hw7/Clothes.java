package com.pb.trojno.hw7;

public abstract class Clothes {
    public String color;
    public Size size;
    public String price;

    public Clothes(String color, Size size, String price){
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getPrice() {
        return price;
    }
}
