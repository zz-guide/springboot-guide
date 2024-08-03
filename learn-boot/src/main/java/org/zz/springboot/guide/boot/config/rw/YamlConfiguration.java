package org.zz.springboot.guide.boot.config.rw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 第一种方式：读取自定义yaml配置文件，不是默认的application文件
 * 通过 @Value 绑定
 * 配置文件中必须有存在的项，否则会有提示
 */

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YamlConfiguration {

    @Value("${name}")
    private String name;
}
