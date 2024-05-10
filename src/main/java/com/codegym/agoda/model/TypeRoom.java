package com.codegym.agoda.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "typeroom")
@Data
public class TypeRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne
    @JoinColumn(name = "id_room")
    private Room room;
}
