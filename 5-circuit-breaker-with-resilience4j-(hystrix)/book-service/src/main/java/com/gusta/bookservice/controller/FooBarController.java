package com.gusta.bookservice.controller;

import io.github.resilience4j.bulkhead.annotation.*;
import io.github.resilience4j.circuitbreaker.annotation.*;
import io.github.resilience4j.ratelimiter.annotation.*;
import io.github.resilience4j.retry.annotation.*;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

@RestController
@RequestMapping(value = "book-service")
public class FooBarController {

    private Logger logger = LoggerFactory.getLogger(FooBarController.class);

    @GetMapping("/foo-bar")
//    @Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
//    @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
//    @RateLimiter(name = "default", fallbackMethod = "fallbackMethod") // limita quantas requisições podem ser feitas por um certo periodo
    @Bulkhead(name = "default", fallbackMethod = "fallbackMethod") //
    public String fooBar() {
        logger.info("Request received!");

//        var response =
//                new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);

        return "foo-bar";
//      return response.getBody();
    }

    public String fallbackMethod(Exception e){
        return "fallbackMethod foo-bar";
    }

}
