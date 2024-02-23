package com.example.wenmanager.controller;

import com.example.wenmanager.common.R;
import com.example.wenmanager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload_image")
    public R uploadImage(@RequestParam("imgFile") MultipartFile file){
        return R.SUCCESS(this.fileService.uploadImage(file));
    }
}
