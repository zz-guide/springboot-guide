package org.zz.demo1.domain.api.user;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderListRequest {
    @Min(value = 1, message = "user_id必须大于0")
    @NotNull(message = "用户id不能为空")
    private Long userId;
}
