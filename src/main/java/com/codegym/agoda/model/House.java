package com.codegym.agoda.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "house")
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String description;
    private double price;
    private int numberOfBedRoom;
    private int numberOfBathRoom;
    private int status;

    @ManyToOne
    @JoinColumn(name = "idImage")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "idHouseRoom")
    private HouseRoom houseRoom;

}
