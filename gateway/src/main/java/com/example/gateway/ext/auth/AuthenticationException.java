package com.example.gateway.ext.auth;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/1 10:52
 */
public class AuthenticationException extends AuthException {

    public AuthenticationException(Code code, String msg) {
        super(msg);
        this.code = code;
    }
}
