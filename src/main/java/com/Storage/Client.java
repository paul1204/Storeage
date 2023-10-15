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
    //Client can have a one-to-many relationship
    //with the Storage Space they can reserve
    //Room<Room> rooms;


 //   Room[] rooms;
  private  String phone;
   private String firstName;
    private String lastName;

    Client(){}


     Client(String name, String driversLicenseNumber,String phone){
                String[] parts = name.split(" ");
//                this.firstName = parts[0];
//                this.lastName = parts[1];
            this.name = name;
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


