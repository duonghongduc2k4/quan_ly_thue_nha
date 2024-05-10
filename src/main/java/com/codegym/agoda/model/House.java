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

    private int numberOfRoom;


    @OneToOne(mappedBy = "house", cascade = CascadeType.ALL)
    private Image image;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<Status> statuses;
//    @OneToMany(mappedBy = "house_rooms",cascade = CascadeType.ALL)
//    private HouseRoom houseRoom;

}
