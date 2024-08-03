package org.zz.springboot.guide.mybatis.flex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.zz.springboot.guide.mybatis.flex.mapper")
public class LearnMybatisFlexApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnMybatisFlexApplication.class, args);
    }
}
