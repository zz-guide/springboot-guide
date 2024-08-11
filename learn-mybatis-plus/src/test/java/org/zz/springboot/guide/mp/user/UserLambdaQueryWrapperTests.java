package org.zz.springboot.guide.mp.user;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

import java.util.List;


/**
 * LambdaQueryWrapper 可以与 QueryWrapper互相转化
 * 1. 字段不用写死，可以利用实体类::getXXX方法替代
 * 2. 碰见自定义sql可能不支持
 */

@SpringBootTest
class UserLambdaQueryWrapperTests {
    @Resource
    UserMapper userMapper;

    @Test
    void testSelectOne() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery();
        // 可以指定查哪些字段
        lambdaQueryWrapper
                .select(User::getId, User::getName)
                .eq(User::getId, "1");
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println("user:" + user);
    }

    @Test
    void testSelectList() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.orderByAsc(User::getId); // 排序
        queryWrapper.last("limit 5"); // limit 限制
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println("user list:"+list);
    }

    @Test
    void testGroupBy() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.groupBy(User::getName).having("count(*) > 0"); // group by 分组
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println("user list:"+list);
    }

    @Test
    void testCount() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        Long l = userMapper.selectCount(queryWrapper);
        System.out.println("user count:"+l);
    }

    @Test
    void testDistinct() {
        // LambdaQueryWrapper 不直接支持distinct
        // 需要先用queryWrapper，然后转换成 LambdaQueryWrapper
        QueryWrapper<User> query = Wrappers.query();

        LambdaQueryWrapper<User> lambdaQueryWrapper = query.select("DISTINCT name").lambda();
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users:" + users);
        List<String> names = users.stream().map(User::getName).toList();
        System.out.println("names:"+names);
    }

}
