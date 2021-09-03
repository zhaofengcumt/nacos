package com.example.gateway.ext.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;


/**
 * @Author: zhaofeng
 * @Date: 2021/9/1 10:53
 */
public class HttpRedirectHandler {

    private final URI location;

    private HttpStatus httpStatus = HttpStatus.FOUND;

    public HttpRedirectHandler(URI location) {
        this.location = location;
    }

    public Mono<Void> redirect(ServerWebExchange exchange) {
        return Mono.fromRunnable(() -> {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(httpStatus);
            response.getHeaders().setLocation(null);
        });
    }
}
