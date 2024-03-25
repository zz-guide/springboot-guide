package org.zz.demo1.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Objects;


/**
 * 读取自定义yaml配置文件，不是默认的application文件
 *  通过 YamlPropertiesFactoryBean + PropertySourcesPlaceholderConfigurer+@Configuration
 * 配置文件中必须有存在的项，否则会有提示
 */

@Configuration
public class MyYamlConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer yamlConfigurer() {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("my.yaml"));
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setProperties(Objects.requireNonNull(yaml.getObject()));
        return configurer;
    }
}
