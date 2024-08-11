package org.zz.springboot.guide.redis;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class LearnRedisStringApplicationTests {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Test
    void tSet(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        String key = "name";
        String value = "仔仔123";
        operations.set(key, value, 3600, TimeUnit.SECONDS);

        String s = operations.get(key);
        System.out.println("get 结果:"+s);
        Assertions.assertEquals(s, value);

        Long expire = stringRedisTemplate.getExpire(key);
        System.out.println("ttl 结果:"+expire);
    }

    @Test
    void tSetNx(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        String key = "name";
        String value = "仔仔123";
        // setnx 不存在则set
        operations.setIfAbsent(key, value, 3600, TimeUnit.SECONDS);

        String s = operations.get(key);
        System.out.println("get 结果:"+s);
        Assertions.assertEquals(s, value);

        Long expire = stringRedisTemplate.getExpire(key);
        System.out.println("ttl 结果:"+expire);
    }
}
