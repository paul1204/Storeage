package com.Client;

import com.Storage.Room.Room;

import java.util.List;

public class Client {
    String name;
    String driversLicenseNumber;
    //Client can have a one-to-many relationship
    //with the Storage Space they can reserve
    //Room<Room> rooms;

    Room[] rooms;
    String phone;




    public Client(String name, String driversLicenseNumber, Room[] room, String phone){
                this.name = name;
                this.driversLicenseNumber = driversLicenseNumber;
                this.rooms = room;
                this.phone = phone;
    }

    //Call Client Register, this will register the Client with the DB

}


