package org.zz.demo1.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ApplicationConfig {
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${server.port}")
    private Integer port;

    @Value("${server.address}")
    private String address;

    @Value("${uploads}")
    private String uploads;
}
