package com.codegym.agoda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "house_room")
@Data
public class HouseRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "id_house")
    @JsonIgnore
    private House house;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;


}