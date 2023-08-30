package com.Reserve;
import com.Storage.Room.Room;
import com.Utilites.handTruck;

public class Receipt {

    int uid;
    Room r;
    String data;
    handTruck truck;


    public Receipt(int uid, Room r, handTruck t){
        this.uid = uid;
        this.r = r;
        this.truck = t;
    }

    public Receipt generateReceipt(){
        toString(uid, r);
        return null;
    }

    void toString(int uid, Room r){

    }
}
