package com.Storage;

//import com.Storage.Room.Room;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Client {

    private @Id @GeneratedValue Long id;
    private String name;
    private String driversLicenseNumber;

    private  String phone;
    private String firstName;
    private String lastName;

    Client(){}


     public Client(String firstName, String lastName,String driversLicenseNumber,String phone){
                this.firstName = firstName;
                this.lastName = lastName;
                this.driversLicenseNumber = driversLicenseNumber;
                this.phone = phone;
    }

    //Call Client Register, this will register the Client with the DB
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.driversLicenseNumber, this.phone);
    }

    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
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


