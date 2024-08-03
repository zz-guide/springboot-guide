package org.zz.springboot.guide.satoken.exception;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SaTokenException.class)
    public SaResult handlerSaTokenException(SaTokenException e) {

        // 根据不同异常细分状态码返回不同的提示
        if(e.getCode() == 30001) {
            return SaResult.error("redirect 重定向 url 是一个无效地址");
        }
        if(e.getCode() == 30002) {
            return SaResult.error("redirect 重定向 url 不在 allowUrl 允许的范围内");
        }
        if(e.getCode() == 30004) {
            return SaResult.error("提供的 ticket 是无效的");
        }
        // 更多 code 码判断 ...

        // 默认的提示
        return SaResult.error(e.getMessage());
    }
}