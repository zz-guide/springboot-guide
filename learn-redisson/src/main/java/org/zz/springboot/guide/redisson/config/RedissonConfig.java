package org.zz.springboot.guide.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RedissonConfig {

    @Bean
    public CacheManager cacheManager(RedissonClient redissonClient) throws IOException {
        Map<String, CacheConfig> config = new HashMap<String, CacheConfig>();
        config.put("testCache", new CacheConfig(24*60*1000, 12*60*1000));
        return new RedissonSpringCacheManager(redissonClient, config);
    }

    @Bean(destroyMethod ="shutdown")
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.200.253:6379").setPassword("123456");
        return Redisson.create(config);
    }
}
