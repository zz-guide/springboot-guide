package org.zz.demo5;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.zz.demo5.domain.RUser;
import org.zz.demo5.domain.User;
import org.zz.demo5.mapper.RUserMapper;
import org.zz.demo5.mapper.UserMapper;

/**
 * 事务方法不能直接调用，必须包裹在一个可被代理的类中调用，本质上是通过aop实现的
 */
@Service
class TransactionService {
    @Resource
    UserMapper userMapper;

    @Resource
    RUserMapper rUserMapper;

    @Resource
    TransactionTemplate transactionTemplate;

    //    @Transactional(rollbackFor = {Exception.class})
    @Transactional()
    public void auto() {
        User user = User.builder().name("张三").username("zhangsan").password("123456").build();
        userMapper.insert(user);
//        int res = 1/0;
        RUser rUser = RUser.builder().name("张三").username("zhangsan").password("123456").build();
        rUserMapper.insert(rUser);
    }

    public void manual() {
        try {
            transactionTemplate.execute(status -> {
                // 内部一旦抛出异常代表事务失败
                System.out.println("status:" + status);
                User user = User.builder().name("张三").username("zhangsan1").password("123456").build();
                userMapper.insert(user);
                int res = 1 / 0;
                RUser rUser = RUser.builder().name("张三1").username("zhangsan1").password("123456").build();
                rUserMapper.insert(rUser);
                return null;
            });
        } catch (Exception e) {
            System.out.println("e:"+e);
        }

    }
}

@SpringBootTest
class TransactionTests {
    @Resource
    TransactionService transactionService;

    @Test
    void contextLoads() {
    }

    @Test
    void testAutoTransaction() {
        System.out.println("=== 声明式事务 ===");
        try {
            transactionService.auto();
            System.out.println("事务提交成功");
        } catch (Exception e) {
            System.out.println("事务提交失败");
            System.out.println("e:" + e);
        }
    }

    @Test
    void testManualTransaction() {
        System.out.println("=== 编程式事务 ===");
        try {
            transactionService.manual();
            System.out.println("事务提交成功");
        } catch (Exception e) {
            System.out.println("事务失败");
            System.out.println("e:" + e);
        }
    }
}
