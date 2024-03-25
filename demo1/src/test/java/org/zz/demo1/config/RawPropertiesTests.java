package org.zz.demo1.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;


@SpringBootTest
class RawPropertiesTests {

    @Test
    void test() {
        Properties props = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(
                    Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("my.properties")), StandardCharsets.UTF_8);
            props.load(inputStreamReader);
        } catch (IOException el) {
            System.out.println(el.toString());
        }

        System.out.println("name:" + props.getProperty("my.name"));
    }
}
