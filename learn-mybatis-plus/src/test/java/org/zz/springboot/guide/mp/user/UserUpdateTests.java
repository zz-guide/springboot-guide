package org.zz.springboot.guide.mp.user;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

import java.time.LocalDateTime;

@SpringBootTest
class UserUpdateTests {
    @Resource
    UserMapper userMapper;

    @Test
    void testUpdate() {
        // 不为null的属性都会修改，不推荐
        long userId = 1;
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery(User.class).eq(User::getId, userId);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if (user == null) {
            System.out.println("查询失败");
            return;
        }

        user.setName("u1仔仔");
        int res = userMapper.updateById(user);
        System.out.println("修改后结果:"+res);
    }

    @Test
    void testUpdate2() {
        // 只修改指定的属性
        long userId = 1;
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = Wrappers.lambdaUpdate(User.class)
                .eq(User::getId, userId)
                .set(User::getName, "u2仔仔");
        int res = userMapper.update(lambdaUpdateWrapper);
        System.out.println("修改后结果:"+res);
    }
}
