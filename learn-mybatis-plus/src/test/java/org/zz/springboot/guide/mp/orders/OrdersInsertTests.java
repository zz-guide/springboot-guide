package org.zz.springboot.guide.mp.orders;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.Orders;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

@SpringBootTest
class OrdersInsertTests {
    @Resource
    UserMapper userMapper;

    @Test
    void tInsert() {
//        long sn = 20;
//        for (int i = 0;i<100;i++) {
//            User user = Orders.builder()
//                    .userId((long) i)
//                    .sn("asdasd")
//                    .build();
//            int res = userMapper.insert(user);
//            // 主键会自动映射到实体类
//            System.out.println("res:"+ res+";id:"+user.getId());
//        }

        System.out.println("插入成功");
    }
}
