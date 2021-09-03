package com.example.gateway.ext.auth;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/2 16:22
 */
public class HttpPathMatcher {
    public Mono<MatchResult> match(ServerWebExchange exchange) {
        return Mono.just(new MatchResult(true));
    }

    class MatchResult {
        private final boolean match;

        private MatchResult(boolean match) {
            this.match = match;
        }

        public boolean isMatch() {
            return match;
        }
    }
}
