package com.example.gateway.ext.auth;

import org.springframework.http.HttpStatus;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/1 10:52
 */
public class AccessDenyException extends AuthException {

    public AccessDenyException(HttpStatus status, String msg) {
        super(msg);
        this.status = status;
    }
}
