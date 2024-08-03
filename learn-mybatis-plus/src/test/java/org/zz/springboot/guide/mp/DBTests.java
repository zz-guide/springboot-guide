package org.zz.springboot.guide.mp;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

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
