package org.zz.demo1.domain.request.valid;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidPost2 {
    @NotBlank(message = "name 不能为空")
    private String name;

    @Min(value = 1, message = "age 必须大于0")
    @Max(value= 125, message = "age 不能大于125")
    private Integer age;

    @NotEmpty(message = "list 不能为空")
    private List<String> list;

    @NotEmpty(message = "map 不能为空")
    private Map<String,String> map;
}
