package com.example.wenmanager.common;

import lombok.Getter;

@Getter
public enum REnum {
    SUCCESS(200,"SUCCESS"),
    FAIL(500,"FAIL"),
    LOGIN_FAIL(1000,"登陆失败"),
    UPLOAD_FILE_FAIL(1100,"上传文件失败"),
    ;

    private int code;
    private String message;

    REnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


}
