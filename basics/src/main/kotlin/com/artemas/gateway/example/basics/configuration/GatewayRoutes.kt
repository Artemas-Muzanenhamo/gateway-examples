package com.artemas.gateway.example.basics.configuration

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GatewayRoutes {
    @Bean
    fun gateway(routeLocatorBuilder: RouteLocatorBuilder): RouteLocator =
        routeLocatorBuilder.routes {
            route {
                path("/hello") // 👈 client requests this
                filters { setPath("/guides") }
                uri("https://spring.io/") // 👈 the downstream service that our service will access.
            }

            route {
                path("/twitter/**")
                filters { rewritePath("/twitter/(?<handle>.*)", "/\${handle}") }
                uri("http://twitter.com/@")
            }
        }
}