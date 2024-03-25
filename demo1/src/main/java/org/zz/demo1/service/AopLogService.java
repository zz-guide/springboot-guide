package org.zz.demo1.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * AOP统一日志管理测试服务
 */
@Service
@Slf4j
public class AopLogService {

    public String test(Integer id) {
        return "传入的参数是：" + id;
    }
}