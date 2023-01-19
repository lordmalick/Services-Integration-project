package com.intro.microservices.apigateway.conf;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter (RouteLocatorBuilder builder){
        return builder.routes()
                .route(
                p -> p.path("/get").filters(
                        f -> f
                                .addRequestHeader("myHeaderParam","HeaderParamValue")
                                .addRequestParameter("MyParameter","ParamValue"))
                        .uri("http://httpbin.org:80"))
                        .route(p -> p
                                    .path("/currency-conversion/**")
                                    .uri("lb://currency-conversion")
                        ).route(p -> p
                        .path("/currency-exchange/**")
                        .uri("lb://currency-exchange")
                ).route(p -> p
                        .path("/authentication-service/**")
                        .uri("lb://authentication-service")
                )
                .build();
    }
}
