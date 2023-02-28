package com.gusta.apigateway.config;

import org.springdoc.core.*;
import org.springframework.cloud.gateway.route.*;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
public class OpenAPIConfig {

    @Bean
    @Lazy(value = false)
    public List<GroupedOpenApi> apis(SwaggerUiConfigParameters config, RouteDefinitionLocator locator) {

        var definitions = locator.getRouteDefinitions().collectList().block();
        definitions.stream()
                .filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
                .forEach(routeDefinition -> {
                    String name = routeDefinition.getId();
                    config.addGroup(name);
                    GroupedOpenApi.builder()
                            .pathsToMatch("/" + name + "/**")
                            .group(name)
                            .build();
                });

        return new ArrayList<>();
    }

}
