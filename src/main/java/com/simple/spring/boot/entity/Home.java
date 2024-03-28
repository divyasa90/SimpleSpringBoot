package com.simple.spring.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Home {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String address;
    private int sell;
    private int list;
    private int living;
    private int rooms;
    private int beds;
    private int baths;
    private int age;
    private double acres;
    private int taxes;
}

