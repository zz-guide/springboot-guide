package org.zz.demo1.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ZzConfiguration2Tests {

    @Resource
    private ZzConfiguration2 configuration;

    @Test
    void test() {
        System.out.println(configuration.toString());
    }
}
