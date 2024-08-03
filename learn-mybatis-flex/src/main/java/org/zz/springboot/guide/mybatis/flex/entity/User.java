package org.zz.springboot.guide.mybatis.flex.entity;

import com.mybatisflex.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("user")
public class User {
    @Id(keyType = KeyType.Auto)
    private Long id;
    private String name;
    private String username;
    private String password;
    private Date createdAt;
    private Date updatedAt;

    @Column(ignore = true)
    @RelationOneToMany(selfField = "id", targetField = "userId")
    private List<Order> orders;
}
