package com.codegym.agoda.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "room")
    private List<HouseRoom> houseRooms;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<TypeRoom> typeRooms;

}
