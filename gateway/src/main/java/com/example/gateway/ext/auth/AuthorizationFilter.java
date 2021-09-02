package com.example.gateway.ext.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/1 10:18
 */
public class AuthorizationFilter implements WebFilter {

    private AuthFailureHandler authFailureHandler;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return Mono.subscriberContext().map(c -> c.get(Authentication.class)).
                   flatMap(this::authorize).onErrorResume(AuthorizationException.class, e -> authFailureHandler.redirect(exchange, e));
    }

    private Mono<Void> authorize(Authentication authentication) {
        if (true) {
            return Mono.empty();
        }
        throw new AuthorizationException();
    }

    @Autowired
    public void setFailureHandler(AuthFailureHandler failureHandler) {
        this.authFailureHandler = failureHandler;
    }
}
