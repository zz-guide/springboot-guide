package org.zz.springboot.guide.mp.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

import java.util.*;

@SpringBootTest
class UserDeleteTests {
    @Resource
    UserMapper userMapper;

    @Test
    void tDelete1() {
        long userId = 90;
        // 直接传入主键删除
        int res = userMapper.deleteById(userId);
        System.out.println("delete res:" + res);
    }

    @Test
    void tDelete2() {
        long userId = 90;
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery(User.class).eq(User::getId, userId);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if (user == null) {
            System.out.println("查询失败");
            return;
        }

        // 传入一个实体类，通过主键删除
        int res = userMapper.deleteById(user);
        System.out.println("delete res:" + res);
    }

    @Test
    void tDelete3() {
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        // 直接传入多个主键删除
        // 经过测试发现不用担心传null,空数组会把整张表删除
        int res = userMapper.deleteByIds(ids);
        System.out.println("delete res:" + res);
    }


    @Test
    void tDelete4() {
        // 给定一个map, key为字段，value为字段值，根据条件删除
        // 不用担心 null会删除全表
        Map<String, Object> map = new HashMap<>();
        map.put("id", 3);
        int res = userMapper.deleteByMap(map);
        System.out.println("delete res:" + res);
    }

    @Test
    void tDelete5() {
        // 通过query指定条件删除
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 3);
        int res = userMapper.delete(queryWrapper);
        System.out.println("delete res:" + res);
    }
}
