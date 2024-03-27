package org.zz.demo1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    private Long id;
    private String name;
    private Integer age;
    private String createdAt;
    private String updatedAt;
}