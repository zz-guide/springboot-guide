package org.zz.demo1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {
    private Long id;
    private String sn;
    private Long userId;
    private String createdAt;
    private String updatedAt;

    // 关联属性，一对一
    private User user;
}