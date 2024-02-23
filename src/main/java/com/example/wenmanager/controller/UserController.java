package com.example.wenmanager.controller;

import com.example.wenmanager.bean.User;
import com.example.wenmanager.common.R;
import com.example.wenmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/wechat_login")
    public R weChatLogin(@RequestBody User user){
        return this.userService.wxLogin(user.getOpenId());
    }

}
