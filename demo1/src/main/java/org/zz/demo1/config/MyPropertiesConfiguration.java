package org.zz.demo1.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


/**
 * 读取自定义properties配置文件，不是默认的application文件
 * 通过 @PropertySources + @PropertySource
 * 配置文件中必须有存在的项，否则会有提示
 */

@Configuration
@Data
@PropertySources({@PropertySource(value = "classpath:my.properties", encoding = "utf-8")})
public class MyPropertiesConfiguration {

    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private int ag;
}
