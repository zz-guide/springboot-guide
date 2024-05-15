package org.zz.demo5.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("orders")
public class Orders {
    @TableId(type=IdType.AUTO)
    private Long id;
    private String sn;
    private Long  userId;
    private LocalDateTime createdAt;
    private LocalDateTime  updatedAt;
}
