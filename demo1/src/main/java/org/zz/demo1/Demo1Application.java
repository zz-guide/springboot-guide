package org.zz.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.zz.demo1.config.ZzConfiguration2;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties(ZzConfiguration2.class)
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}
