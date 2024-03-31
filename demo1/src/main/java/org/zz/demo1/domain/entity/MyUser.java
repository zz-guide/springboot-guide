package org.zz.demo1.domain.entity;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zz.demo1.domain.dto.UserDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AutoMapper(target = UserDto.class)
public class MyUser {
    private String username;
    private int age;
    private boolean young;
}