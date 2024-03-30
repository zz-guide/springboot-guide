package org.zz.demo1.domain.api.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersCreateRequest {
    @JsonProperty("user_id")
    @NotNull(message = "用户不能为空")
    private Long userId;
}
