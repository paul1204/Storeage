package com.Storage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {


    private @Id Long id;
    String name;
    double price;
    int totalRooms;
    int availableRooms;



    public Room(){}

    public Room(Long id, String name, double price, int totalRooms, int availableRooms) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
    }

    public Room(Long id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalRooms=" + totalRooms +
                ", availableRooms=" + availableRooms +
                '}';
    }
}
