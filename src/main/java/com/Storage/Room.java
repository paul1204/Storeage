package com.Storage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Room {


    private @Id
    @GeneratedValue Long id;
    String name;
    double price;


    Room(){}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    Room(String n, double p){
        this.name = n;
        this.price = p;
    }

}
