package org.zz.springboot.guide.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.zz.springboot.guide.boot.config.rw.ApplicationCustomConfig2;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationCustomConfig2.class)
public class LearnBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnBootApplication.class, args);
    }
}
