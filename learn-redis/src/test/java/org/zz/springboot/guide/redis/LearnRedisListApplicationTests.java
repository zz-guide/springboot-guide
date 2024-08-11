package org.zz.springboot.guide.redis;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class LearnRedisListApplicationTests {
    @Resource
    RedisTemplate redisTemplate;

    @Test
    void tSet(){
        ListOperations operations = redisTemplate.opsForList();
        String key = "z_list";
        operations.leftPush(key, 1);
    }
}
