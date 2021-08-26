package com.example.helloprovider.api;

import com.example.helloapi.IHelloService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhaofeng
 * @Date: 2021/8/24 16:14
 */
@RestController
public class HelloController implements IHelloService {
    @Override
    public String hello() {
        return "HELLO";
    }
}
