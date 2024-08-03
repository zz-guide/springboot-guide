package org.zz.springboot.guide.mp;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.RUser;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.RUserMapper;
import org.zz.springboot.guide.mp.mapper.UserMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
class UserCURDTests {
    @Resource
    UserMapper userMapper;

    @Resource
    RUserMapper rUserMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testRUserEmptyList() {
        LambdaQueryWrapper<RUser> queryWrapper = new LambdaQueryWrapper<>();
        List<RUser> list = rUserMapper.selectList(queryWrapper);
        // 结论: 数据表为空的时候，返回的是空集合，而不是null
        System.out.println(list);
    }

    @Test
    void testInsertUser() {
        for (int i = 0;i<100;i++) {
            User user = User.builder()
                    .name("仔仔:"+i)
                    .username("zz:"+i)
                    .password("123456")
                    .build();
            int res = userMapper.insert(user);
            // 主键会自动映射到实体类
            System.out.println("res:"+ res+";id:"+user.getId());
        }

        System.out.println("插入成功");
    }

    @Test
    void testUpdateUser() {
        User user = User.builder().build();
        user.setId(1L);
        user.setName("hahah");
        user.setCreatedAt(LocalDateTime.now());
        // 如果属性值为null，sql中不会出现这个字段
        int res = userMapper.updateById(user);
        System.out.println("修改user结果:"+res);
    }

    @Test
    void testGetList() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    @Test
    void testGetOneById() {
        // QueryWrapper 可以转换成 LambdaQueryWrapper
        // 优先使用LambdaQueryWrapper，避免硬编码
        // 一些特殊场景再使用QueryWrapper, 比如 distinct
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
//                .select(User::getId, User::getName)
                .eq(User::getId, "1");
        // 如果返回的不是结合，需要判断为null的情况
        User user = userMapper.selectOne(queryWrapper);
        System.out.println("user:" + user);
        System.out.println(user.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // 缺点，不能控制查询字段
        User user1 = userMapper.selectById(1);
        System.out.println("user1:" + user1);
    }

    @Test
    void testDistinct() {
        // 测试 distinct
        // LambdaQueryWrapper 不直接支持distinct
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .select("DISTINCT name")
                .lambda();
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users:" + users);
        List<String> names = users.stream().map(User::getName).toList();
        System.out.println("names:"+names);
    }

    @Test
    void testWrapper() {
        // 多种方式构造wrapper
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery();
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users:" + users);
    }

    @Test
    void testPager() {
        // 分页功能由插件提供
        // 最基础的由offset limit方式实现
        Page<User> page = new Page<>(2,5);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        IPage<User> userPage = userMapper.selectPage(page, wrapper);
        List<User> users = userPage.getRecords();
        System.out.println("users:" + users);
    }
}
