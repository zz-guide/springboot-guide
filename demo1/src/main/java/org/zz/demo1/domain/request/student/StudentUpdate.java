package org.zz.demo1.domain.request.student;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdate {
    @Min(value = 1, message = "id必须大于0")
    @NotNull(message = "id不能为空")
    private Long id;

    private String name;

    @Min(value=1, message = "年龄必须大于0")
    @Max(value=150, message = "年龄必须小于150")
    private int age;
}
