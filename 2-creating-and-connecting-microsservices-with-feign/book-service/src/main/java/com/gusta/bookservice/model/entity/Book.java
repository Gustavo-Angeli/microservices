package com.gusta.bookservice.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    @Temporal(TemporalType.DATE)
    private Date launchDate;
    private Double price;
    private String title;
    @Transient
    private String currency;
    @Transient
    private String environment;
}
