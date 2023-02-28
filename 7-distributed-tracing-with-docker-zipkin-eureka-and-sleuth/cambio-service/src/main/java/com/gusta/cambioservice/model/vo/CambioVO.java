package com.gusta.cambioservice.model.vo;

import lombok.*;

import javax.persistence.*;
import java.io.*;
import java.math.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CambioVO implements Serializable {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String environment;
}
