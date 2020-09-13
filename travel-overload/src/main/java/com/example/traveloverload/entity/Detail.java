package com.example.traveloverload.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countries;
    private String cities;
    private String accommodation;
    private String visitedPlaces;
    private double totalCost;
    private double travelTime;

}
