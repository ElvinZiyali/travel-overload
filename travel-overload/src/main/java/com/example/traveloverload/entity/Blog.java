package com.example.traveloverload.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String thumbnail;
    @OneToOne
    private Content content;
    private String author;
    private LocalDateTime createdDate;
    @OneToOne
    private Detail detail;
    private Double countOfSeen;

}
