package org.zz.demo1.domain.request.valid;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @NotNull 规定了传参时候的key必须存在，至于value是什么，不考虑
 * 2. @NotBlank 只能用在String，不能为 null，而且调用 trim() 后，长度必须大于 0，必须有实际的字符
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidGet3 {
    @NotBlank(message = "name 不能为空字")
    private String name;

    @Min(value = 1, message = "age 必须大于0")
    @Max(value= 125, message = "age 不能大于125")
    private Integer age;
}
