package com.example.wenmanager.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.wenmanager.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User u = new User();
        u.setOpenId("test");
        u.setVxName("test");
        u.setAvatar("test");
        this.userMapper.insert(u);
    }

    @Test
    public void testSelectList(){
        System.out.println(this.userMapper.selectList(new QueryWrapper<>()));
    }
}