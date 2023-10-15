package com.Storage;

import jakarta.persistence.*;

@Entity
public class Request {

    private @Id
    @GeneratedValue Long id;

    Long idUser;

    //@OneToMany(cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    Room[] rooms;

    Request(){}
    public Request(Long id, Long idUser, Room[] rooms) {
        this.id = id;
        this.idUser = idUser;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
}
