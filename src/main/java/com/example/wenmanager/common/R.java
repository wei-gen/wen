package com.example.wenmanager.common;

public class R {
    public int code;
    public String message;
    public Object data;
    public static R SUCCESS(){
        R r = new R();
        r.code = REnum.SUCCESS.getCode();
        r.message = REnum.SUCCESS.getMessage();
        return r;
    }
    public static R SUCCESS(REnum rEnum){
        R r = new R();
        r.code = rEnum.getCode();
        r.message = rEnum.getMessage();
        return r;
    }
    public static R SUCCESS(Object Data){
        R r = new R();
        r.code = REnum.SUCCESS.getCode();
        r.message = REnum.SUCCESS.getMessage();
        r.data = r.data;
        return r;
    }

    public static R FAIL(REnum rEnum){
        R r = new R();
        r.code = rEnum.getCode();
        r.message = rEnum.getMessage();
        return r;
    }
}
