package org.zz.springboot.guide.mybatis.flex.entity;

import com.mybatisflex.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("orders")
public class Order {
    @Id(keyType = KeyType.Auto)
    private Long id;
    private String sn;
    private Long userId;
    private Date createdAt;
    private Date updatedAt;

    @RelationOneToOne(selfField = "userId", targetField = "id")
    @Column(ignore = true)
    private User user;
}
