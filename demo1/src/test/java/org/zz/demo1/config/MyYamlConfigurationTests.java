package org.zz.demo1.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MyYamlConfigurationTests {

    @Value("${myyaml.name}")
    private String name;

    @Test
    void test() {
        System.out.println("name:" + name);
    }
}
