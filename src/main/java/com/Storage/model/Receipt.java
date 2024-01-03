package com.Storage.model;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Receipt {
    private @Id @GeneratedValue Long uid;
    private  String data;
    private Long userId;
    Long[] roomId;
    double cost;


    String pin;
    public Receipt(){}
    public Receipt(Long idUser, Long[] roomId , double cost){
        this.userId = idUser;
       // this.r = r;
        this.roomId = roomId;
        this.cost = cost;
        //this.truck = t;
    }

    public Receipt generateReceipt(){
        //toString();
        return this;
    }

    public Long[] getRoomId() {
        return roomId;
    }

    public void setRoomId(Long[] roomId) {
        this.roomId = roomId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }


    @Override
    public String toString() {
        return "Receipt{" +
                "uid=" + uid +
                ", r=" + Arrays.toString(this.roomId) +
                ", data='" + data + '\'' +
                ", userId=" + userId +
                ", pin=" + pin +
                '}';
    }
}
