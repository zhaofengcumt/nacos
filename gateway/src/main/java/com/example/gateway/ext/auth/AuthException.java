package com.example.gateway.ext.auth;

import org.springframework.http.HttpStatus;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/2 10:58
 */
abstract class AuthException extends RuntimeException {

    HttpStatus status;

    public AuthException(String msg, Throwable t) {
        super(msg, t);
    }


    public AuthException(String msg) {
        super(msg);
    }

}
