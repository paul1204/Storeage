package com.Reserve;
import com.Storage.Room.Room;
import com.Utilites.handTruck;

public class Reservation {

    Receipt receipt;
    int uid = 0;
    Room room;
    Room[] rooms;
    public Reservation(){
    }


    public Receipt clientReserve(Room r, handTruck truck) {
        this.uid++;
        this.room = r;
        receipt = new Receipt(uid, room, truck);
        createReservation();
        return receipt.generateReceipt();
    }

    private void createReservation(){
        //Talk to the DB. This is where you will update the Repo
    }


}
