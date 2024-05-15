package org.zz.demo5;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.demo5.domain.User;
import org.zz.demo5.mapper.UserMapper;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
class DBTests {
    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        // 静态调用，有个缺点就是不能动态设置字段
        List<User> users = Db.listByIds(Arrays.asList(1L, 2L), User.class);
        System.out.println(users);
    }
}
