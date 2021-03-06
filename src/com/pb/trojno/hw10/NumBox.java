package com.pb.trojno.hw10;

import java.net.BindException;

public class NumBox <T extends Number> {

    private final T[] numbers;
    int maxelement = 0;

    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    public void add(T num) throws ArrayIndexOutOfBoundsException {
        try {
            numbers[maxelement] = num;
//            System.out.println("Попытка добавить " + maxelement + " элемент");
            maxtelement++;
        } catch (Exception e) {
            int nexelem = maxelement+1;
            System.out.println("Попытка добавить " + nextelem + " элемент из " + numbers.length + " возможных");
        }
    }

    public T get(int index){
        if (index >= 0 || index <= length()){
            return numbers[index];
        } else { System.out.println("Элемент под таким номером не существует!"); return null;}
    }

    public double sum(){
        double summ = 0;
        for(T  n : numbers){
            if (n != null) summ = summ + n.doubleValue();
        }
        return summ;
    }

    public int length(){
        return maxelement;
    }

    public double average(){
        return  (sum() / length());
    }

    public T max(){
        T maxvalue = get(0);
        for(T  n : numbers){
            if (n != null && n.doubleValue() > maxvalue.doubleValue()) maxvalue = n;
        }
        return maxvalue;
    }

    public void info(){
        System.out.print("Элементы массива: ");
        for(T  n : numbers){
            if (n != null) System.out.print(n.doubleValue() + " ");
        }
        System.out.println("");
        System.out.println("Кол-во созданных елементов " + length());
        System.out.println("Сумма элементов = " + sum());
        System.out.println("Среднее значение = " + average());
        System.out.println("Максимальный элемент = " + max());
    }
}
