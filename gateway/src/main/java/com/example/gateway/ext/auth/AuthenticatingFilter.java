package com.example.gateway.ext.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;


/**
 * @Author: zhaofeng
 * @Date: 2021/8/27 13:29
 */
@Component
public class AuthenticatingFilter implements WebFilter {

    private HttpRedirectHandler httpRedirectHandler;

    private HttpPathMatcher httpPathMatcher;

    private AuthCenter authCenter;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return httpPathMatcher.match(exchange).filter(matchResult -> matchResult.isMatch()).
                              switchIfEmpty(chain.filter(exchange).then(Mono.empty())).
                              flatMap(authentication -> authCenter.auth(exchange)).
                              flatMap(authentication -> onSuccess(exchange, chain, authentication)).
                              onErrorResume(AuthenticationException.class, e -> httpRedirectHandler.redirect(exchange));

    }


    private Mono<Void> onSuccess(ServerWebExchange exchange, WebFilterChain chain, Authentication authentication) {
        return chain.filter(exchange).subscriberContext(ctx -> ctx.put(Authentication.class, authentication));
    }


    @Autowired
    private void setFailureHandler(HttpRedirectHandler httpRedirectHandler) {
        this.httpRedirectHandler = httpRedirectHandler;
    }
}
