package com.Storage.model;

//import com.Storage.model.Room.Room;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Client {

    private @Id int id;
    private String name;
    private String driversLicenseNumber;

    private String phone;
    private String firstName;
    private String lastName;

    @OneToMany
    private List<Receipt> roomsBooked;
    Client(){}


     public Client(int id, String firstName, String lastName,String driversLicenseNumber,String phone, List<Receipt> receipts){
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.driversLicenseNumber = driversLicenseNumber;
                this.phone = phone;
                this.roomsBooked = receipts;
    }

    //Call Client Register, this will register the Client with the DB
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.driversLicenseNumber, this.phone);
    }

    public int getId() {
        return this.id;
    }

    public String getDriversLicenseNumber() {
        return this.driversLicenseNumber;
    }

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Receipt> getReceipts() {
        return roomsBooked;
    }

    public void addReceipt(Receipt r) {
        this.roomsBooked.add(r);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + this.id +
                ", driversLicenseNumber='" + this.driversLicenseNumber + '\'' +
                ", phone='" + this.phone + '\'' +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                '}';
    }
}


