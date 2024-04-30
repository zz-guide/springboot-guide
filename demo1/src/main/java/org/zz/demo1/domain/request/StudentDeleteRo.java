package org.zz.demo1.domain.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDeleteRo {
    @Min(value = 1, message = "id必须大于0")
    @NotNull(message = "id不能为空")
    private Long id;
}
