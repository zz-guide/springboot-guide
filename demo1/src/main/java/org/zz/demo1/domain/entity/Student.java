package org.zz.demo1.domain.entity;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String createdAt;
    private String updatedAt;
}