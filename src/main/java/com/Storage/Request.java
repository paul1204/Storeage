package com.Storage;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Entity
public class Request {

    private @Id Long idd;
    Long idUser;
    Long[] roomId;

    @OneToOne
    Receipt receipt;

    double cost;
    Request(){}
    public Request(Long id, Long idUser, Long[] roomID, double cost) {
        this.idd = id;
        this.idUser = idUser;
        //this.rooms = rooms;
        this.roomId  = roomId;
        this.cost = cost;
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

    public Long getId() {
        return idd;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setId(Long id) {
        this.idd = id;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getRoomId(int id) {
        return roomId[id];
    }

    public void setRoomId(Long[] roomId) {
        this.roomId = roomId;
    }

    public Receipt generateReceipt(Long userId, double cost){
        return receipt = new Receipt(userId, this.roomId, cost);
    }
    @Override
public String toString() {
    return "Request{" +
            "id=" + this.idd +
            ", idUser=" + this.idUser +
            ", roomId=" + Arrays.toString(this.roomId) +
            ", receipt=" + this.receipt +
            ", cost=" + this.cost +
            '}';
}
}
