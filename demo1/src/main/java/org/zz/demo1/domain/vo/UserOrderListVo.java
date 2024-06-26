package org.zz.demo1.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zz.demo1.domain.entity.Orders;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOrderListVo {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String createdAt;
    private String updatedAt;

    private List<Orders> orderList;
}
