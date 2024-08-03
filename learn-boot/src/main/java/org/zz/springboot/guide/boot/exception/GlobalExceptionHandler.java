package org.zz.springboot.guide.boot.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zz.springboot.guide.boot.common.ResponseResult;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseResult<?> handlerException(Exception e) {
        return ResponseResult.fail(e.getMessage());
    }
}