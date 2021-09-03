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

    private HttpRedirectHandler authFailureHandler;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return Mono.subscriberContext().map(ctx -> ctx.get(Authentication.class)).
                   flatMap(authentication -> checkAuthorities(authentication, exchange)).
                   switchIfEmpty(chain.filter(exchange)).
                   onErrorResume(AuthenticationException.class, e -> Mono.error(e));
    }

    private Mono<Void> checkAuthorities(Authentication authentication, ServerWebExchange exchange) {
        if (true) {
            return Mono.empty();
        }
        throw new AuthenticationException(null, null);
    }


    @Autowired
    private void setFailureHandler(HttpRedirectHandler failureHandler) {
        this.authFailureHandler = failureHandler;
    }
}
