package org.zz.springboot.guide.redis;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class LearnRediHashApplicationTests {
    @Resource
    RedisTemplate redisTemplate;

    @Test
    void t(){
    }
}
