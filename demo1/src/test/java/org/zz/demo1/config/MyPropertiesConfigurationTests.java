package org.zz.demo1.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MyPropertiesConfigurationTests {

    @Resource
    private MyPropertiesConfiguration configuration;

    @Test
    void test() {
        System.out.println(configuration.toString());
    }
}
