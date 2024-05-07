package com.codegym.agoda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String description;
    private double price;
    private int numberofbedroom;
    private int numberofbathroom;

    public House(int id, String name, String address, String description, double price, int numberofbedroom, int numberofbathroom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.price = price;
        this.numberofbedroom = numberofbedroom;
        this.numberofbathroom = numberofbathroom;
    }

    public House() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberofbedroom() {
        return numberofbedroom;
    }

    public void setNumberofbedroom(int numberofbedroom) {
        this.numberofbedroom = numberofbedroom;
    }

    public int getNumberofbathroom() {
        return numberofbathroom;
    }

    public void setNumberofbathroom(int numberofbathroom) {
        this.numberofbathroom = numberofbathroom;
    }
}
