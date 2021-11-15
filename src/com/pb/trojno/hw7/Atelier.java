package com.pb.trojno.hw7;

import com.pb.trojno.hw6.Animal;

public class Atelier {
    public static void main(String[] args) {
        Tie clothes1 = new Tie("зеленый", Size.M, "200 грн");
        Skirt clothes2 = new Skirt("красная", Size.S, "750 грн");
        Pants clothes3 = new Pants("мокко", Size.M, "900 грн");
        Tshirt clothes4 = new Tshirt("белый", Size.L, "420 грн");

        Clothes[] clothes = new Clothes[]{clothes1, clothes2, clothes3, clothes4};
        dressMan(clothes);
        dressWomen(clothes);
    }

    public static void dressMan(Clothes[] clothes){
        System.out.println("Мужская одежда: ");
        for (Clothes c: clothes) {
            if (c instanceof ManClothes) {
                ((ManClothes) c).dressMan();
            }
        }
    }

    public static void dressWomen(Clothes[] clothes){
        System.out.println("Женская одежда: ");
        for (Clothes c: clothes) {
            if (c instanceof WomenClothes)  {
                ((WomenClothes) c).dressWomen();
            }
        }
    }

}
