package org.zz.demo1.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 获取默认application配置
 * 第一种方式：@Component + @Value
 * 必须存在配置才行，不存在话会导致应用无法启动
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZzConfiguration1 {
    @Value("${zz.name}")
    private String name;

    @Value("${zz.age}")
    private int age;
}
