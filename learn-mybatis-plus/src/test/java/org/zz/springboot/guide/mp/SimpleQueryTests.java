package org.zz.springboot.guide.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@SpringBootTest
class SimpleQueryTests {

    @Test
    void testSimpleQueryKeyMap() {
        // 查出来的结果自动转成id为key的 map, 省去了自己动手转map
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 还可一选动态字段查询，很不错
//        lambdaQueryWrapper.select(User::getId, User::getName);
        Map<Long, User> userMap = SimpleQuery.keyMap(lambdaQueryWrapper, User::getId);
        System.out.println(userMap);

        // 只想要id,name的Map
        // 或者只想要id为key，name为value组成的map
        Map<Long, String> idNameMap = SimpleQuery.map(lambdaQueryWrapper, User::getId, User::getName);
        System.out.println(idNameMap);
    }

    @Test
    void testSimpleQueryList() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<Long> ids = SimpleQuery.list(lambdaQueryWrapper, User::getId);
        System.out.println(ids);

        // 可叠加后续操作
        List<String> names = SimpleQuery.list(lambdaQueryWrapper, User::getName,
                e -> Optional.ofNullable(e.getName())
                        .map(String::toUpperCase)
                        .ifPresent(e::setName));
        System.out.println(names);
    }

    @Test
    void testSimpleQueryGroup() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Map<String, List<User>> nameUsersMap = SimpleQuery.group(lambdaQueryWrapper, User::getName);
        // key为名字，value为相同名称记录组成的list
        System.out.println(nameUsersMap);

        // key为名字，value为相同名称记录id列组成的list
        Map<String, List<Long>> idsMap = SimpleQuery.group(lambdaQueryWrapper, User::getName,
                mapping(User::getId, toList()));
        System.out.println(idsMap);

        // 获取Map<name,个数>
        Map<String, Long> nameCountMap = SimpleQuery.group(lambdaQueryWrapper, User::getName, counting());
        System.out.println(nameCountMap);
    }
}
