package com.example.BE_Ecommerce.Network;


import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.WebFilter;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Configuration
@Order(1)
public class HttpsRedirectConfig {
    @Bean
    public WebFilter httpsRedirectFilter() {
        return (exchange, chain) -> {
            if (exchange.getRequest().getURI().getScheme().equals("http")) {
                URI httpsUri = UriComponentsBuilder.fromUri(exchange.getRequest().getURI())
                        .scheme("https")
                        .port(8080)
                        .build()
                        .toUri();
                exchange.getResponse().setStatusCode(HttpStatus.PERMANENT_REDIRECT);
                exchange.getResponse().getHeaders().setLocation(httpsUri);
                return exchange.getResponse().setComplete();
            }
            return chain.filter(exchange);
        };
    }
}
