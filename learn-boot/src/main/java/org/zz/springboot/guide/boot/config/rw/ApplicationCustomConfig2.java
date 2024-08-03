package org.zz.springboot.guide.boot.config.rw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 第二种方式: 读取自定义properties配置文件，不是默认的application文件
 * 通过 @ConfigurationProperties+@EnableConfigurationProperties(ApplicationCustomConfig2.class)
 * 配置文件中必须有存在的项，否则会有提示
 */

@ConfigurationProperties("custom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationCustomConfig2 {
    private String name;
}
