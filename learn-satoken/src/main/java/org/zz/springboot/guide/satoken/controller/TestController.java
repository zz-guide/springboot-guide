package org.zz.springboot.guide.satoken.controller;

import cn.dev33.satoken.util.SaResult;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class TestController {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    // 测试业务缓存
    @RequestMapping("test")
    public SaResult test() {
        System.out.println("--------------- 测试业务缓存");
        stringRedisTemplate.opsForValue().set("hello", "Hello World");
        return SaResult.ok();
    }
}
