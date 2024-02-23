package com.example.wenmanager.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wenmanager.bean.Book;
import com.example.wenmanager.bean.User;
import com.example.wenmanager.common.R;
import com.example.wenmanager.exception.WeChatLoginException;
import com.example.wenmanager.mapper.BookMapper;
import com.example.wenmanager.mapper.UserMapper;
import com.example.wenmanager.util.JWTUtils;
import org.springframework.stereotype.Service;

@Service
public class BookService extends ServiceImpl<BookMapper, Book> {

}
