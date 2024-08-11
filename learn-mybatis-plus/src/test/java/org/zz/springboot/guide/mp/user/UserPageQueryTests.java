package org.zz.springboot.guide.mp.user;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

import java.util.List;

/**
 * 分页查询
 * 1. 通用，支持各种复杂sql
 * 2. 缺点 字段是写死的
 */
@SpringBootTest
class UserPageQueryTests {
    @Resource
    UserMapper userMapper;

    @Test
    void testPager() {
        Page<User> page = new Page<>(2,5); // p, pn
        QueryWrapper<User> wrapper = Wrappers.query();
        // selectMapsPage
        // selectPage
        IPage<User> userPage = userMapper.selectPage(page, wrapper);
        List<User> users = userPage.getRecords();
        System.out.println("users:" + users);
    }
}
