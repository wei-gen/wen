package com.example.wenmanager.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.wenmanager.bean.Book;
import com.example.wenmanager.bean.User;
import com.example.wenmanager.common.R;
import com.example.wenmanager.service.BookService;
import com.example.wenmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/get_books")
    public R getBooks(@RequestBody Book book){
        List<Book> list = this.bookService.list(Wrappers.<Book>lambdaQuery()
                .eq(Book::getIsDelete, 0)
                .eq(Book::getUserId, book.getUserId())
                .orderByDesc(Book::getCreateTime)
        );

        return R.SUCCESS(list);
    }

    @PostMapping("/release_book")
    public R releaseBook(@RequestBody Book book){
        this.bookService.save(book);
        return R.SUCCESS();
    }

    @PostMapping("/delete_book")
    public R deleteBook(@RequestBody Book book){
        this.bookService.update(Wrappers.<Book>lambdaUpdate()
                .eq(Book::getIsDelete,0)
                .set(Book::getIsDelete,1)
        );
        return R.SUCCESS();
    }
}
