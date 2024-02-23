package com.example.wenmanager.service;

import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wenmanager.bean.User;
import com.example.wenmanager.common.R;
import com.example.wenmanager.exception.WeChatLoginException;
import com.example.wenmanager.mapper.UserMapper;
import com.example.wenmanager.util.JWTUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    /**
     * 微信登陆
     * @param openId
     * @return
     */
    public R wxLogin(String openId){
        User user = this.getOne(
                Wrappers.<User>lambdaQuery().eq(User::getOpenId,openId)
        );
        if (user == null){
            throw new WeChatLoginException();
        }
        return R.SUCCESS(JWTUtils.createToken(user));
    }

}
