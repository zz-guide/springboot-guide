package org.zz.springboot.guide.mp.address;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

@SpringBootTest
class AddressInsertTests {
    @Resource
    UserMapper userMapper;

    @Test
    void tInsert() {
        for (int i = 0;i<100;i++) {
            User user = User.builder()
                    .name("仔仔:"+i)
                    .age(32)
                    .build();
            int res = userMapper.insert(user);
            // 主键会自动映射到实体类
            System.out.println("res:"+ res+";id:"+user.getId());
        }

        System.out.println("插入成功");
    }
}
