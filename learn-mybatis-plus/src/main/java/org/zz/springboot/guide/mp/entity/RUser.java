package org.zz.springboot.guide.mp.entity;

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
@TableName("r_user")
public class RUser {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String  password;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime  updatedAt;
}
