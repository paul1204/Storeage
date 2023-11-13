package com.Storage;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Entity
public class Request {


    private @Id Long idd;

    Long idUser;


    @Autowired
    @OneToMany(cascade = CascadeType.MERGE)
    //@OneToOne
    Room[] rooms;

    @OneToOne
    Receipt receipt;

    double cost;
    Request(){}
    public Request(Long id, Long idUser, Room[] rooms, double cost) {
        this.idd = id;
        this.idUser = idUser;
        this.rooms = rooms;
        this.cost = cost;
    }
    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Long getIdd() {
        return idd;
    }

    public void setIdd(Long idd) {
        this.idd = idd;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }



    public Receipt generateReceipt(){
        return receipt = new Receipt(this.idUser, this.rooms, this.cost);
    }
    public Long getId() {
        return idd;
    }

    public Long getIdUser() {
        return idUser;
    }

//    public Room[] getRooms() {
//        return
//                null;
//    }

    public void setId(Long id) {
        this.idd = id;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

//    public void setRooms(Room[] rooms) {
//        //this.rooms = rooms;
//    }
@Override
public String toString() {
    return "Request{" +
            "id=" + this.idd +
            ", idUser=" + this.idUser +
            ", rooms=" + Arrays.toString(rooms) +
            ", receipt=" + this.receipt +
            ", cost=" + this.cost +
            '}';
}
}
