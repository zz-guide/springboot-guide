package org.zz.springboot.guide.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
@SpringBootApplication
public class LearnBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnBootApplication.class, args);
    }
}
