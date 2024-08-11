package org.zz.springboot.guide.mp.user;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

import java.util.List;
import java.util.Map;

/**
 * QueryWrapper 可以与LambdaQueryWrapper互相转化
 * 1. 通用，支持各种复杂sql
 * 2. 缺点 字段是写死的
 */
@SpringBootTest
class UserQueryWrapperTests {
    @Resource
    UserMapper userMapper;

    @Test
    void testSelectOne() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper
                .select("id", "name")
                .eq("id", "1");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println("user:" + user);
    }

    @Test
    void testSelectList() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.orderByAsc("id"); // 排序
        queryWrapper.last("limit 5"); // limit 限制
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println("user list:"+list);
    }

    @Test
    void testGroupBy() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.groupBy("name").having("count(*) > 0"); // group by 分组
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println("user list:"+list);
    }

    @Test
    void testCount() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        Long l = userMapper.selectCount(queryWrapper);
        System.out.println("user count:"+l);
    }

    @Test
    void testDistinct() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.select("DISTINCT name");

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users:" + users);

        List<String> names = users.stream().map(User::getName).toList();
        System.out.println("names:"+names);
    }

    @Test
    void testSelectMaps() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.orderByAsc("id"); // 排序
        queryWrapper.last("limit 5"); // limit 限制
        // selectMaps 接收对象可以不是实体类，而是一个一个的map
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println("user map list:"+maps);
    }

    @Test
    void testSelectObjs() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.orderByAsc("id"); // 排序
        queryWrapper.last("limit 5"); // limit 限制
        // selectObjs 只返回每个记录的第一个字段的值
        List<Object> list = userMapper.selectObjs(queryWrapper);
        System.out.println("user map list:"+list);
    }
}
