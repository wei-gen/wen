package com.example.wenmanager.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.wenmanager.bean.Book;
import com.example.wenmanager.bean.Chat;
import com.example.wenmanager.common.R;
import com.example.wenmanager.service.BookService;
import com.example.wenmanager.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/get_chats")
    public R getChats(@RequestBody Chat chat){
        List<Chat> list = this.chatService.list(Wrappers.<Chat>lambdaQuery()
                .eq(Chat::getIsDelete, 0)
                .eq(Chat::getSendId, chat.getSendId())
                .eq(Chat::getAcceptId, chat.getAcceptId())
                .gt(chat.getNowId() !=null,Chat::getNowId,chat.getNowId())
                .orderByAsc(Chat::getCreateTime)
        );
        return R.SUCCESS(list);
    }

    @PostMapping("/send_chat")
    public R sendChat(@RequestBody Chat chat){
        this.chatService.save(chat);
        return R.SUCCESS();
    }

}
