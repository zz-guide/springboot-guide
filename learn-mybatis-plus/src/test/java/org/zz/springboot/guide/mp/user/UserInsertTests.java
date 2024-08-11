package org.zz.springboot.guide.mp.user;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

import java.util.Random;

@SpringBootTest
class UserInsertTests {
    @Resource
    UserMapper userMapper;

    @Test
    void tInsert() {
        Random random = new Random();
        User user = User.builder().name("张三_" + random.nextInt(100)).age(random.nextInt(100)).build();

        int res = userMapper.insert(user);
        System.out.println("insert res:" + res + ";id:" + user.getId());
    }
}
