package com.example.helloapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhaofeng
 * @Date: 2021/8/24 15:44
 */

@FeignClient(name = "myServiceName", url = "localhost:8888")
public interface IHelloService {
    @RequestMapping("/hello")
    String hello();

}
