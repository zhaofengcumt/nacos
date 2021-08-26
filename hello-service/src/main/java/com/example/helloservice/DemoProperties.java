package com.example.helloservice;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: zhaofeng
 * @Date: 2021/8/24 14:56
 */

@ConfigurationProperties(prefix = "config")
public class DemoProperties {
    String name;

    int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
