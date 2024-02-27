package com.example.wenmanager.util;

import cn.hutool.jwt.JWTUtil;
import com.example.wenmanager.bean.User;

import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    public static String createToken(User user){
        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;
            {
                put("id", user.getId());
                put("vxName", user.getNickName());
                put("avater", user.getAvatarUrl());
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
            }
        };

        return JWTUtil.createToken(map, "wen".getBytes());
    }

}
