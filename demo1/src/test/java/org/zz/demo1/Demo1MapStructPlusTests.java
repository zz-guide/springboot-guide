package org.zz.demo1;

import io.github.linpeilie.Converter;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.demo1.domain.dto.UserDto;
import org.zz.demo1.domain.entity.MyUser;

@SpringBootTest
class Demo1MapStructPlusTests {

    @Resource
    private Converter converter;

    @Test
    void testMapStructPlus() {
        MyUser user = new MyUser();
        user.setUsername("jack");
        user.setAge(23);
        user.setYoung(false);

        UserDto userDto = converter.convert(user, UserDto.class);
        System.out.println(userDto);    // UserDto{username='jack', age=23, young=false}

        assert user.getUsername().equals(userDto.getUsername());
        assert user.getAge() == userDto.getAge();
        assert user.isYoung() == userDto.isYoung();

        MyUser newUser = converter.convert(userDto, MyUser.class);

        System.out.println(newUser);    // User{username='jack', age=23, young=false}

        assert user.getUsername().equals(newUser.getUsername());
        assert user.getAge() == newUser.getAge();
        assert user.isYoung() == newUser.isYoung();
    }

}
