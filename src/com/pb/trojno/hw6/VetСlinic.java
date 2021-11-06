package com.pb.trojno.hw6;

import java.lang.reflect.Constructor;
import java.sql.Array;

public class VetСlinic {
    public static void main(String[] args) throws Exception {

        Dog animals1 = new Dog("Котя", 4, "кошка");
        Dog animals2 = new Dog("Бублик", 1, "кобель");
        Cat animals3 = new Cat("Барсик", 5, "кот");
        Dog animals4 = new Dog("Джек", 2, "кобель");
        Cat animals5 = new Cat("Мурка", 3, "кошка");
        Horse animals6 = new Horse("Молния", 3, "мерин");

        Class docClass = Class.forName("com.pb.trojno.hw6.Veterinarian");
        Constructor constr = docClass.getConstructor();
        Object doc = constr.newInstance();

        Animal[] animals = new Animal[] {animals1, animals2, animals3, animals4, animals5, animals6};
        for (Animal a: animals) {
            if (a instanceof Dog) {
                System.out.print("Пациент: " + ((Dog) a).getName() + ", пол " + ((Dog) a).getSex() + ", возраст " + ((Dog) a).getAge() + ". ");}
            if (a instanceof Cat) {
                System.out.print("Пациент: " + ((Cat) a).getName() + ", пол " + ((Cat) a).getSex() + ", возраст " + ((Cat) a).getAge() + ". ");}
            if (a instanceof Horse) {
                System.out.print("Пациент: " + ((Horse) a).getName() + ", пол " + ((Horse) a).getSex() + ", возраст " + ((Horse) a).getAge() + ". ");}
            ((Veterinarian) doc).treatAnimal(a);
        }
    }

}
