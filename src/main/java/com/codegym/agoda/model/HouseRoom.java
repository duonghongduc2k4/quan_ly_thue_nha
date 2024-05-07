package com.codegym.agoda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "house_room")
public class HouseRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int  numberofroom;

    @ManyToOne
    @JoinColumn(name = "idHouse")
    private House house;

    @ManyToOne
    @JoinColumn(name = "idRoom")
    private Room room;

    public HouseRoom(int id, int numberofroom, House house, Room room) {
        this.id = id;
        this.numberofroom = numberofroom;
        this.house = house;
        this.room = room;
    }

    public HouseRoom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberofroom() {
        return numberofroom;
    }

    public void setNumberofroom(int numberofroom) {
        this.numberofroom = numberofroom;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
