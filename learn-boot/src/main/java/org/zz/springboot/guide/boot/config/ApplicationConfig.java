package org.zz.springboot.guide.boot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 映射application.yml 中的值到类中的属性
 * 通过 @Value 进行绑定
 * 配置文件中必须有存在的项，否则会有提示
 */

@Data
@Configuration
public class ApplicationConfig {
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${server.port}")
    private Integer port;

    @Value("${server.address}")
    private String address;
}
