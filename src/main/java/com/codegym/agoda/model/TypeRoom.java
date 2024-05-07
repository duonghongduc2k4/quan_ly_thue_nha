package com.codegym.agoda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "typeroom")
public class TypeRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    public TypeRoom(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeRoom() {
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
}
