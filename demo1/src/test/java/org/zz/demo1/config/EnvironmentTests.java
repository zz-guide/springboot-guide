package org.zz.demo1.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/**
 * 获取默认application配置
 * 第三种方式，使用Environment 动态获取配置项，通常用于插件，starter开发
 */
@SpringBootTest
class EnvironmentTests {

    @Resource
    private Environment environment;

    @Test
    void test() {
        System.out.println("name:" + environment.getProperty("zz.name"));
        System.out.println("age:" + environment.getProperty("zz.age"));
    }
}
