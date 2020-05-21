package com.dfec.hotel.auth;

import org.apache.shiro.authc.AuthenticationToken;

public class OAuth2Token implements AuthenticationToken {
    private static final long serialVersionUID = 1L;
    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    public String getPrincipal() {
        return this.token;
    }

    public Object getCredentials() {
        return this.token;
    }
}
