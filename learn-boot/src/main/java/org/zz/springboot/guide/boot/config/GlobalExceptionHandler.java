package org.zz.springboot.guide.boot.config;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zz.springboot.guide.boot.common.ResponseResult;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseResult<?> handleException(Exception e) {
        System.out.println(e.toString());
        return ResponseResult.fail(e.getMessage());
    }

    /* 添加校验参数异常处理 */
    @ExceptionHandler(BindException.class)
    public ResponseResult<?> bindExceptionHandler(BindException e) {
        return ResponseResult.fail(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}