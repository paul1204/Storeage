package com.Storage;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Entity
public class Receipt {
    private @Id @GeneratedValue Long uid;
    private  String data;
    private Long userId;
    Long[] roomId;
    double cost;

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

    @Override
    public String toString() {
        return "Receipt{" +
                "uid=" + uid +
                ", r=" + Arrays.toString(this.roomId) +
                ", data='" + data + '\'' +
                ", userId=" + userId +
                '}';
    }
}
