package com.artemas.gateway.example.basics.configuration

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GatewayRoutes {
    @Bean
    fun gateway(routeLocatorBuilder: RouteLocatorBuilder): RouteLocator {
        return routeLocatorBuilder
            .routes()
            .route { routeSpec ->
                routeSpec
                    .path("/hello")
                    .filters { routeFilter -> routeFilter.setPath("/guides") }
                    .uri("https://spring.io/")
            }
            .build()
    }
}