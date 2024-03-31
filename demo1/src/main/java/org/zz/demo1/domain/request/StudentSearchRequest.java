package org.zz.demo1.domain.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSearchRequest {
    @NotNull(message = "p不能为空")
    @Min(value=1, message = "年龄必须大于0")
    private Integer p;

    @NotNull(message = "pn不能为空")
    @Min(value=1, message = "pn必须大于0")
    private Integer pn;
}
