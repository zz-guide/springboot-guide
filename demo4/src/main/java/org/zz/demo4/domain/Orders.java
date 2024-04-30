package org.zz.demo4.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private Long id;

    private String sn;

    private Integer userId;

    private Date createdAt;

    private Date updatedAt;
}