package com.codegym.agoda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameImage;


    @ManyToOne
    @JoinColumn(name = "id_House")
    private House house;

    public Image(int id, String nameImage, House house) {
        this.id = id;
        this.nameImage = nameImage;
        this.house = house;
    }

    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
