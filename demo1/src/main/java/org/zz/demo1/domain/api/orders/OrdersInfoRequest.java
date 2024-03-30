package org.zz.demo1.domain.api.orders;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersInfoRequest {
    @NotNull(message = "用户不能为空")
    private Long id;
}
