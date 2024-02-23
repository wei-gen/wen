package com.example.wenmanager.exception;

import com.example.wenmanager.common.R;
import com.example.wenmanager.common.REnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = WeChatLoginException.class)
    public R dataRepetitionException(HttpServletRequest request, HttpServletResponse response, WeChatLoginException e) {
        log.error("微信登陆：{}",e.getLocalizedMessage());
        return R.FAIL(REnum.LOGIN_FAIL);
    }

    @ExceptionHandler(value = FileException.class)
    public R dataRepetitionException(HttpServletRequest request, HttpServletResponse response, FileException e) {
        log.error("文件上传：{}",e.getLocalizedMessage());
        return R.FAIL(REnum.UPLOAD_FILE_FAIL);
    }
}
