package org.zz.demo1.domain.request.valid;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidGet4 {
    private String name;
    private Integer age;
}
