package org.zz.springboot.guide.boot.config.rw;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


/**
 * 第一种方式: 读取自定义properties配置文件，不是默认的application文件
 * 通过 @PropertySources + @PropertySource
 * 配置文件中必须有存在的项，否则会有提示
 */

@Data
@PropertySources({@PropertySource(value = "classpath:custom.properties", encoding = "utf-8")})
@Configuration
public class PropertiesConfiguration {
    @Value("${name}")
    private String name;
}
