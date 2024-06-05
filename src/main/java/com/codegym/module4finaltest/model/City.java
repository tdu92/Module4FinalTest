package com.codegym.module4finaltest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class City {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long cityId;
    private String cityName;
    private double area;
    private int population;
    private double  gdp;
    private String  description;
    @ManyToOne
    private Country country;
}
