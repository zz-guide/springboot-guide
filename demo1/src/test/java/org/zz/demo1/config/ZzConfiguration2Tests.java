package org.zz.demo1.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ZzConfiguration2Tests {

    @Autowired
    private ZzConfiguration2 configuration;

    @Test
    void test() {
        System.out.println(configuration.toString());
    }
}
