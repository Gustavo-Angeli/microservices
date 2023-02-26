package com.gusta.cambioservice.controller;

import com.gusta.cambioservice.model.entity.*;
import com.gusta.cambioservice.repository.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.env.*;
import org.springframework.web.bind.annotation.*;

import java.math.*;

@Tag(name = "Cambio endpoint")
@RestController
@RequestMapping(value = "cambio-service")
public class CambioController {

    @Autowired
    private Environment environment;
    @Autowired
    private CambioRepository repository;

    @Operation(summary = "Get cambio from currency")
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to
            ) {

        var cambio = repository.findByFromAndTo(from, to);
        if (cambio == null) throw new RuntimeException("Currency unsupported");

        var port = environment.getProperty("local.server.port");

        BigDecimal conversionFactor = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount).setScale(2, RoundingMode.CEILING);

        return Cambio.builder()
                .id(1L)
                .from(from)
                .to(to)
                .conversionFactor(cambio.getConversionFactor())
                .convertedValue(convertedValue)
                .environment(port)
                .build();
    }

}
