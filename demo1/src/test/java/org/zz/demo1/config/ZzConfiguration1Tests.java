package org.zz.demo1.config;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ZzConfiguration1Tests {

    @Autowired
    private ZzConfiguration1 configuration;

    @Test
    void test() {
        System.out.println(configuration.toString());
    }
}
