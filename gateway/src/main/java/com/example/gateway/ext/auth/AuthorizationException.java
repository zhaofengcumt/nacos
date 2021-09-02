package com.example.gateway.ext.auth;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/2 10:51
 */
public class AuthorizationException extends AuthException {

    public AuthorizationException(Code code, String msg) {
        super(msg);
        this.code = code;
    }
}
