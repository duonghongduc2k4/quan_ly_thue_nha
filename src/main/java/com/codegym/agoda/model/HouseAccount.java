package com.codegym.agoda.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "house_account")
public class HouseAccount {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id ;
    private String timeStart;
    private String timeEnd;
    private String total ;
    private String status;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


}
