package com.example.wenmanager.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.example.wenmanager.bean.User;
import com.example.wenmanager.common.R;
import com.example.wenmanager.service.UserService;
import com.example.wenmanager.vo.WeChatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${wechat.config.AppID}")
    private String appid;

    @Value("${wechat.config.AppSecret}")
    private String appSecret;

    @PostMapping("/get_wechat_code")
    public R getWechatCode(@RequestBody WeChatVo weChatVo){
        String s = HttpUtil.get(String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code", appid, appSecret, weChatVo.getCode()));
        JSONObject jsonObject = new JSONObject(s);
        return R.SUCCESS(jsonObject);
    }

    @PostMapping("/wechat_login")
    public R weChatLogin(@RequestBody User user){
        return this.userService.wxLogin(user.getOpenId());
    }

}
