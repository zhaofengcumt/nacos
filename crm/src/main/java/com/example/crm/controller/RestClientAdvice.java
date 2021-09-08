package com.example.crm.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestClientAdvice {

    String handleException(Exception exception) {
        return "error";
    }


}