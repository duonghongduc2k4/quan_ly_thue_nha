package com.codegym.agoda.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    //doanh thu
    private double revenue;

    @OneToMany(mappedBy = "house")
    private List<HouseRoom> houseRooms;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<Image> images;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<Status> statuses;

}
