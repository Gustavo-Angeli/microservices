package com.gusta.cambioservice.config;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.models.*;
import org.springframework.context.annotation.*;

@OpenAPIDefinition(
    info = @Info(
        title = "Cambio-Service-API",
        version = "v1",
        description = "Cambio service documentation"
    )
)
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                        .title("Cambio-Service-API")
                        .version("v1")
                        .license(
                                new io.swagger.v3.oas.models.info.License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")
                        )
                );
    }

}
