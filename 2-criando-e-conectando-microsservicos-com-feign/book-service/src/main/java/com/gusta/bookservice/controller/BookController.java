package com.gusta.bookservice.controller;

import com.gusta.bookservice.model.entity.*;
import com.gusta.bookservice.model.vo.*;
import com.gusta.bookservice.proxy.*;
import com.gusta.bookservice.repository.*;
import com.gusta.bookservice.response.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.env.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import java.util.*;

@RestController
@RequestMapping(value = "book-service")
public class BookController {

    @Autowired
    private Environment environment;
    @Autowired
    private BookRepository repository;
    @Autowired
    private CambioProxy cambioProxy;

    @GetMapping(value = "/{id}/{currency}")
    public BookVO findById(
            @PathVariable(value = "id") Long id,
            @PathVariable(value = "currency") String currency
    ) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);


        var port = environment.getProperty("local.server.port");

        return BookVO.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .launchDate(book.getLaunchDate())
                .price(cambio.getConvertedValue())
                .title(book.getTitle())
                .currency(book.getCurrency())
                .environment(port)
                .build();
    }


}

/*
    @GetMapping(value = "/{id}/{currency}")
        public BookVO findById(
                @PathVariable(value = "id") Long id,
                @PathVariable(value = "currency") String currency
        ) {
            Book book = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException());

            HashMap<String, String> params = new HashMap<>();
            params.put("amount", book.getPrice().toString());
            params.put("from", "USD");
            params.put("to", currency);

            var response = new RestTemplate().getForEntity(
                    "http://localhost:8000/cambio-service/{amount}/{from}/{to}",
                    Cambio.class,
                    params
            );

            var port = environment.getProperty("local.server.port");

            return BookVO.builder()
                    .id(book.getId())
                    .author(book.getAuthor())
                    .launchDate(book.getLaunchDate())
                    .price(response.getBody().getConvertedValue())
                    .title(book.getTitle())
                    .currency(book.getCurrency())
                    .environment(port)
                    .build();
        }
 */
