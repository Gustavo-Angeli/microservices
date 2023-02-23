package com.gusta.cambioservice.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.*;
import java.math.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "cambio")
public class Cambio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;

    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;

    @Column(nullable = false)
    private BigDecimal conversionFactor;

    @Transient
    private BigDecimal convertedValue;

    @Transient
    private String environment;
}
