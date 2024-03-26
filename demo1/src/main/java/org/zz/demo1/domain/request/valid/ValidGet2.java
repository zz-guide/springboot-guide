package org.zz.demo1.domain.request.valid;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. 参数不传默认都为null，传了以后会被相同名称的属性接收
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidGet2 {
    private String name;

    private Integer age;
}
