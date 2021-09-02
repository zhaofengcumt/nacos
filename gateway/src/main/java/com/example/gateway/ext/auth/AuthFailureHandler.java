package com.example.gateway.ext.auth;

import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/1 10:53
 */
public class AuthFailureHandler {

    Mono<Void> redirect(ServerWebExchange exchange, AuthException e) {
        return Mono.fromRunnable(() -> {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(e.status);
            response.getHeaders().setLocation(null);
        });
    }
}
