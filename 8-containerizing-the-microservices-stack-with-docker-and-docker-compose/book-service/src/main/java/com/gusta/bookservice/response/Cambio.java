package com.gusta.bookservice.response;

import lombok.*;

import java.io.*;
import java.math.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cambio implements Serializable {
    private Long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double convertedValue;
    private String environment;
}
