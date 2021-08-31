package com.example.gateway.ext.filter;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaofeng
 * @Date: 2021/8/27 13:29
 */
public class AuthenticatingFilter implements WebFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        Flux.just(1, 2, 3, 4)
                .log()
                .flatMap(e -> Flux.just(e * 2).delayElements(Duration.ofSeconds(1)))
                .subscribe(e -> System.out.println("get " + e));
        TimeUnit.SECONDS.sleep(100);






     /*   Flux.just().filter(e->e.equals("2")).switchIfEmpty(Flux.just("1","2")).filter(e->e.equals("1")).subscribe(e -> System.out.println("get " + e));
        TimeUnit.SECONDS.sleep(100);*/
    }
}
