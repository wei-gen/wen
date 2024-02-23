package com.example.wenmanager.auth;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.wenmanager.bean.User;
import com.example.wenmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class WeChatProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = this.userService.getOne(
                Wrappers.<User>lambdaQuery().eq(User::getOpenId,authentication.getPrincipal().toString())
        );
        if(user == null){
            throw new RuntimeException("授权失败");
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
