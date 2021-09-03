package com.example.gateway.ext.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/3 9:20
 */
public class AuthCenter {
    public Mono<Authentication> auth(ServerWebExchange exchange) {
        ServerHttpRequest request       = exchange.getRequest();
        String            authorization = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authorization == null) {
            throw new AccessDenyException(null, null);
        }
        return Mono.just(new Authentication());
    }
}
