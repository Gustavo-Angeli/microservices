package com.gusta.bookservice.model.vo;

import lombok.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookVO implements Serializable {
    private Long id;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;
    private String currency;
    private String environment;
}
