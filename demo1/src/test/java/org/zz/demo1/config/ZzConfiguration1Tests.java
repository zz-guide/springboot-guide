package org.zz.demo1.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ZzConfiguration1Tests {

    @Resource
    private ZzConfiguration1 configuration;

    @Test
    void test() {
        System.out.println(configuration.toString());
    }
}
