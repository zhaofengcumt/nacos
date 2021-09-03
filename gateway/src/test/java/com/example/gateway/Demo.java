package com.example.gateway;

import com.example.gateway.ext.auth.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/2 11:31
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {


        //  Mono.fromRunnable(() -> System.out.println("1")).subscribe(System.out::println);



  /*      String key = "message";
        Mono.subscriberContext()
            .map(ctx -> ctx.get(Authentication.class))
            .subscriberContext(ctx -> ctx.put(Authentication.class, new Authentication("2", "2")))
            //订阅上下文,核心操作
            .subscribe(System.out::println);*/


     /*   Context.empty().put(Authentication.class, new Authentication("2", "2"));

        System.out.println(Context.empty().get(Authentication.class).getUsername());

        Mono.just(1).doOnNext(x -> System.out.println(x + 1)).
                then(Mono.subscriberContext()).subscriberContext(ctx -> ctx.put(key, "World")).subscribe(System.out::println);*/

        /*
       String key = "message";
        Mono.subscriberContext()
                .map(ctx -> "Hello " + ctx.get(key))
                .subscriberContext(ctx -> ctx.put(key, "World"))
                //订阅上下文,核心操作
                .subscribe(System.out::println);

         Mono.subscriberContext().flatMap(ctx-> ctx.get(key)).subscribe(System.out::println);
        */
        //    Mono.subscriberContext().flatMap(ctx -> ctx.get(key)).subscribe(System.out::println);

        /*
        Flux.just(1, 2, 3, 4).flatMap(AuthenticatingFilter::test).
                onErrorResume(EmptyStackException.class, e -> Flux.just(10)).
                filter(e -> e == 10).subscribe(System.out::println);
        */


       /* Flux.just(1, 2, 3, 4)
            .log()
            .flatMap(e -> Flux.just(e * 2).delayElements(Duration.ofSeconds(1)))
            .subscribe(e -> System.out.println("get " + e));
        TimeUnit.SECONDS.sleep(100);

        Flux.just().filter(e -> e.equals("2")).switchIfEmpty(Flux.just("1", "2")).filter(e -> e.equals("1")).subscribe(e -> System.out.println("get " + e));
        TimeUnit.SECONDS.sleep(100);
*/


    /*    Mono.just(1).doOnNext(x -> System.out.println(x + 1)).doOnSuccess(x-> System.out.println(22)).
            then(Mono.just(20)).subscribe(System.out::println);*/

        Mono.empty().flatMap(x->null).subscribe(System.out::println);

        Mono.empty().switchIfEmpty(Mono.just(2).doOnNext(x -> System.out.println(1/0)).doOnSuccess(x-> System.out.println(22)).
                                       then(Mono.just(10))). onErrorResume(ArithmeticException.class, e -> Mono.just(100)).
            doOnNext(m -> System.out.println(m+"---")).subscribe(System.out::println);

  /*      Mono.just(CollectionUtils.unmodifiableMultiValueMap(new LinkedMultiValueMap<String, String>(0)))
           .map(data -> createAuthentication(data)).subscribe(System.out::println);*/

    }

    private static Object createAuthentication(MultiValueMap<String, String> data) {
        String username = data.getFirst("");
        String password = data.getFirst("");
        return new UsernamePasswordAuthenticationToken(username, password);
    }
       /*
   private static Flux<Integer> test(int n) {
        int i = 1 / 0;
        return Flux.just(n * 2);
    }
   */


}
