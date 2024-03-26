package com.back.demo.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import com.back.demo.controller.UserController;
import com.back.demo.model.ApiKeyAuthentication;

import jakarta.servlet.http.HttpServletRequest;

public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
    private static String AUTH_TOKEN;

    

    public static Authentication getAuthentication(HttpServletRequest request) {
        
        if (UserController.MI_VARIABLE == ""){
            AUTH_TOKEN = "Baeldung";
        }else{
            AUTH_TOKEN = UserController.MI_VARIABLE;
        }

        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}