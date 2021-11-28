package com.pb.trojno.hw10;

public class Main {

    public static void main(String[] args) {
        NumBox<Float> f = new NumBox<>(3);
        NumBox<Integer> integ = new NumBox<>(4);

        f.add(new Float(2.2));
        f.add(new Float(2.3));
        f.add(new Float(1.3));
        f.add(new Float(3.5));
        integ.add(new Integer(2));
        integ.add(new Integer(1));
        integ.add(new Integer(5));

        f.info();
        integ.info();
    }
}
