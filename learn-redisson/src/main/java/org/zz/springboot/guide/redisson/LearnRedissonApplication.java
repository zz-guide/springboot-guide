package org.zz.springboot.guide.redisson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.zz.springboot.guide.mp.mapper")
public class LearnRedissonApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnRedissonApplication.class, args);
    }
}
