package org.zz.demo1;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class Demo1RedisSampleTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void TextRedisXX() {
        String key = "user:token:1";
        stringRedisTemplate.opsForValue().set(key, "info", 30, TimeUnit.MINUTES);
        String val = stringRedisTemplate.opsForValue().get(key);
        System.out.println("读取到的值："+ val);
    }

}
