package org.zz.springboot.guide.boot.config.rw;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 第一种方式：读取application.yml 自定义的部分
 * 使用 @Value 直接进行属性绑定
 * 必须存在，否则无法启动
 */
@Data
@Configuration
public class ApplicationCustomConfig {
    @Value("${custom.upload-path}")
    private String uploadPath;
}