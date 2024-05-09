package com.codegym.agoda.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "house_room")
@Data
public class HouseRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numberOfRoom;


    @ManyToOne
    @JoinColumn(name = "id_house")
    private House house;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;


}
