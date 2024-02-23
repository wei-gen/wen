package com.example.wenmanager.exception;

import com.example.wenmanager.common.R;
import com.example.wenmanager.common.REnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = WeChatLoginException.class)
    @ResponseBody
    public R dataRepetitionException(HttpServletRequest request, HttpServletResponse response, WeChatLoginException e) {
        return R.FAIL(REnum.LOGIN_FAIL);
    }

    @ExceptionHandler(value = FileException.class)
    @ResponseBody
    public R dataRepetitionException(HttpServletRequest request, HttpServletResponse response, FileException e) {
        return R.FAIL(REnum.UPLOAD_FILE_FAIL);
    }
}
