package org.zz.springboot.guide.mp.user;

import com.baomidou.mybatisplus.core.batch.MybatisBatch;
import com.baomidou.mybatisplus.core.toolkit.MybatisBatchUtils;
import jakarta.annotation.Resource;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;
import org.zz.springboot.guide.mp.service.UserService;
import org.zz.springboot.guide.mp.service.impl.UserServiceImpl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootTest
class UserBatchInsertTests {
    @Resource
    UserMapper userMapper;

    @Resource
    UserServiceImpl2 userServiceImpl2;

    @Resource
    SqlSessionFactory sqlSessionFactory;

    @Test
    void tBatch1() {
        int size = 100;
        Random random = new Random();
        for (int i = 1; i <= size; i++) {
            User user = User.builder().name("仔仔_" + i).age(random.nextInt(100)).build();
            int res = userMapper.insert(user);
            System.out.println("res:" + res + ";id:" + user.getId());
        }

        System.out.println("插入成功");
    }

    @Test
    void tBatch2() {
        int size = 100;
        List<User> userList = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            User user = User.builder().name("仔仔_" + i).age(random.nextInt(100)).build();
            userList.add(user);
        }

        List<BatchResult> execute = MybatisBatchUtils.execute(sqlSessionFactory, userList, new MybatisBatch.Method<User>(UserMapper.class).insert());
        for (BatchResult batchResult : execute) {
            System.out.println("batchResult:"+ Arrays.toString(batchResult.getUpdateCounts()));
        }

        System.out.println("批量插入成功");
    }

    @Test
    void tBatch3() {
        int size = 100;
        List<User> userList = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= size; i++) {
            User user = User.builder().name("仔仔_" + i).age(random.nextInt(100)).build();
            userList.add(user);
        }

        boolean res = userServiceImpl2.saveBatch(userList, 20); // 20个一批
        System.out.println("saveBatch 结果:"+res);
    }

    @Test
    void tSaveOrUpdate() {
        int size = 100;
        List<User> userList = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            User user = User.builder().id((long) i).name("仔仔_new_" + i).age(random.nextInt(100)).build();
            userList.add(user);
        }

        MybatisBatch.Method<User> userMethod = new MybatisBatch.Method<>(UserMapper.class);
        List<BatchResult> execute = MybatisBatchUtils.saveOrUpdate(
                sqlSessionFactory,
                userList,
                userMethod.insert(),
                ((sqlSession, user) -> userMapper.selectById(user.getId()) == null), // 判断条件
                userMethod.updateById()
        );

        for (BatchResult batchResult : execute) {
            System.out.println("batchResult:"+ Arrays.toString(batchResult.getUpdateCounts()));
        }

        System.out.println("批量插入成功");
    }
}
