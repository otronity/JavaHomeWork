package com.pb.trojno.hw6;

import java.util.Objects;

public class Horse extends Animal{
    private String name;
    private float age;
    private String sex;


    public Horse(String name, float age, String sex){
        super("сено", "конюшня");
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public float getAge() {
        return age;
    }

    @Override
    public void makeNoise(){
        System.out.println(this.name + " ржет и топает");
    }

    @Override
    public void eat(){
        System.out.println(this.name + " ест " + getFood());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return age == horse.age && Objects.equals(name, horse.name) && Objects.equals(sex, horse.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "Horse {" + "name =" + name + ", age = " + age + ", sex = " + sex + '}';
    }
}
