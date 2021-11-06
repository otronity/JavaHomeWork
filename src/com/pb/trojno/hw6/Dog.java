package com.pb.trojno.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private String name;
    private float age;
    private String sex;

    public Dog(String name, float age, String sex){
        super("сухой корм", "дом");
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
        System.out.println(this.name + " гавкает и скулит");
    }

    @Override
    public void eat(){
        System.out.println(this.name + " ест " + getFood());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age && Objects.equals(name, dog.name) && Objects.equals(sex, dog.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "Dog {" + "name =" + name + ", age = " + age + ", sex = " + sex + '}';
    }
}
