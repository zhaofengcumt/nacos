package com.example.gateway.ext.auth;

import org.springframework.http.HttpStatus;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/2 10:51
 */
public class AuthenticationException extends AuthException {

    public AuthenticationException(HttpStatus status, String msg) {
        super(msg);
        this.status = status;
    }
}
