package org.zz.springboot.guide.mp.user;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

/**
 * SimpleQuery 方便的将结果集转换为map或者list
 */

@SpringBootTest
class SimpleQueryTests {

    @Test
    void testToMap() {
        // 查出来的结果自动转成id为key,value为实体类的 map, 省去了自己动手转map
        Map<Long, User> userMap = SimpleQuery.keyMap(Wrappers.lambdaQuery(), User::getId);
        System.out.println(userMap);

        // 第三个参数表示value只要name
        Map<Long, String> idNameMap = SimpleQuery.map(Wrappers.lambdaQuery(), User::getId, User::getName);
        System.out.println(idNameMap);
    }

    @Test
    void testQueryColumn() {
        // 只查询某一列
        List<Long> ids = SimpleQuery.list(Wrappers.lambdaQuery(), User::getId);
        System.out.println(ids);

        // 可叠加后续操作, 比如转为大写
        List<String> names = SimpleQuery.list(Wrappers.lambdaQuery(), User::getName,
                e -> Optional.ofNullable(e.getName())
                        .map(String::toUpperCase)
                        .ifPresent(e::setName));
        System.out.println(names);
    }

    @Test
    void testGroup() {
        // group 以name分组
        Map<String, List<User>> nameUsersMap = SimpleQuery.group(Wrappers.lambdaQuery(), User::getName);
        // key为名字，value为相同名称记录组成的list
        System.out.println(nameUsersMap);

        // key为名字，value为相同名称记录id列组成的list
        Map<String, List<Long>> idsMap = SimpleQuery.group(Wrappers.lambdaQuery(), User::getName, mapping(User::getId, toList()));
        System.out.println(idsMap);

        // 获取Map<name,个数>
        Map<String, Long> nameCountMap = SimpleQuery.group(Wrappers.lambdaQuery(), User::getName, counting());
        System.out.println(nameCountMap);
    }
}
