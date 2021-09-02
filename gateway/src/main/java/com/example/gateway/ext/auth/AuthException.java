package com.example.gateway.ext.auth;

/**
 * @Author: zhaofeng
 * @Date: 2021/9/2 10:58
 */
abstract class AuthException extends RuntimeException {

    protected Code code;

    public AuthException(String msg, Throwable t) {
        super(msg, t);
    }


    public AuthException(String msg) {
        super(msg);
    }

    protected enum Code {
        AuthenticationFailed(401),

        AuthorizationFailed(402);

        int num;

        Code(int num) {
            this.num = num;
        }
    }
}
