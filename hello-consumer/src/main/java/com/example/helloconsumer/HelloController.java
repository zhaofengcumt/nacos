package com.example.helloconsumer;

import com.example.helloapi.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhaofeng
 * @Date: 2021/8/24 16:15
 */
@RestController
public class HelloController {
    @Autowired
    IHelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        return "success: " + helloService.hello();
    }


}
