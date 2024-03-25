package org.zz.demo1.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 获取默认application配置
 * 第二种方式：@ConfigurationProperties + @EnableConfigurationProperties(ZzProperties.class)
 * 必须存在配置才行，不存在话会导致应用无法启动
 *
 * 不需要每个@Value注解写配置
 */
@ConfigurationProperties("zz")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZzConfiguration2 {
    private String name;
    private int age;
}
