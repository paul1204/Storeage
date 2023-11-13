package com.Storage;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Entity
public class Receipt {


    private @Id
    @GeneratedValue Long uid;
//Long uid;
@OneToMany(cascade = CascadeType.ALL)
 private Room[] r;
  private  String data;
  //private  handTruck truck;
  private Long userId;

  double cost;

    public Receipt(Long idUser, Room[] r , double cost){
        this.userId = idUser;
        this.r = r;
        this.cost = cost;
        //this.truck = t;
    }

    public Receipt generateReceipt(){
        //toString();
        return this;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "uid=" + uid +
                ", r=" + Arrays.toString(r) +
                ", data='" + data + '\'' +
                ", userId=" + userId +
                '}';
    }
}
