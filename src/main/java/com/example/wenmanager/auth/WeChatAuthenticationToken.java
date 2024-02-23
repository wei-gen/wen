package com.example.wenmanager.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class WeChatAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = -6231962326068951783L;


    public WeChatAuthenticationToken(Object principal) {
        super(principal, "");
    }


    public WeChatAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(principal, "", authorities);
    }

}
