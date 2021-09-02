package com.example.gateway.ext.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
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

    private String usernameParameter = "username";

    private String passwordParameter = "password";

    private AuthFailureHandler failureHandler;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return exchange.getFormData().flatMap(request -> this.convert(exchange)).
                       flatMap(authentication -> authenticate(exchange, chain, authentication)).
                       onErrorResume(AuthenticationException.class, e -> failureHandler.redirect(exchange, e));
    }


    public Mono<Authentication> convert(ServerWebExchange exchange) {
        return exchange.getFormData().map(parameters -> createAuthentication(parameters));
    }

    private Authentication createAuthentication(MultiValueMap<String, String> parameters) {
        String username = parameters.getFirst(usernameParameter);
        String password = parameters.getFirst(passwordParameter);
        return new Authentication(username, password);
    }


    private Mono<Void> authenticate(ServerWebExchange exchange, WebFilterChain chain, Authentication authentication) {
        return doAuthenticate(authentication).then(chain.filter(exchange)).subscriberContext(ctx -> ctx.put(Authentication.class, authentication));
    }

    /***
     *  TODO("增加认证逻辑")
     * @param authentication
     * @return
     */
    private Mono<Void> doAuthenticate(Authentication authentication) {
        if (true) {
            return Mono.empty();
        }
        throw new AuthenticationException(HttpStatus.UNAUTHORIZED, "");
    }

    @Autowired
    public void setFailureHandler(AuthFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }
}
