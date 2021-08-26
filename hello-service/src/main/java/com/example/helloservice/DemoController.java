package com.example.helloservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhaofeng
 * @Date: 2021/8/24 14:54
 */


@RestController
public class DemoController {
    @Autowired
    DemoProperties propertiesDemo;

    @RequestMapping({"/hello"})
    String hello() {
        return this.propertiesDemo.getName();
    }
}
