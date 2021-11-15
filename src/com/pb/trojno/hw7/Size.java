package com.pb.trojno.hw7;

import com.sun.org.apache.xpath.internal.objects.XString;

public enum Size {
    XXS("Детский размер", 32),
    XS("Взрослый размер", 34),
    S("Взрослый размер", 36),
    M("Взрослый размер", 38),
    L("Взрослый размер", 40);

    String description;
    int euroSize;

    Size(String description, int euroSize){
        this.description = description;
        this.euroSize = euroSize;
    };

    public String getDescription(Size size){
        return size.description;
    };

    public int getEuroSize(Size size){
        return size.euroSize;
    };
}
