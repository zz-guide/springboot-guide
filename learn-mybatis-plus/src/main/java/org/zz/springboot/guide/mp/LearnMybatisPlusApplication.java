package org.zz.springboot.guide.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.zz.springboot.guide.mp.mapper")
public class LearnMybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnMybatisPlusApplication.class, args);
    }
}
