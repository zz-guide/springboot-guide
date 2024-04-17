package org.zz.demo2;

import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.row.Db;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.demo2.domain.Order;
import org.zz.demo2.domain.User;
import org.zz.demo2.mapper.OrderMapper;
import org.zz.demo2.mapper.UserMapper;

import java.util.*;

import static org.zz.demo2.domain.table.OrderTableDef.ORDER;
import static org.zz.demo2.domain.table.UserTableDef.USER;


@SpringBootTest
class OrderCURDTests {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserMapper userMapper;

    List<User> getUserList(){
        return userMapper.selectAll();
    }

    public static Long getRandomListElement(List<Long> list) {
        return list.stream()
                .skip(new Random().nextInt(list.size()))
                .findFirst()
                .orElse(null);
    }


    @Test
    void testInsert(){
        int size = 10;
        // 获取所有的user_id
        List<Long> userIds = getUserList().stream().map(User::getId).toList();

        List<Order> orders = new ArrayList<>();
        for (int i =0; i < size; i++) {
            Long randomUserId = getRandomListElement(userIds);
            String uuid = UUID.randomUUID().toString().replace("-", "");
            Order order = Order.builder().sn(uuid).userId(randomUserId).build();
            orders.add(order);
        }

        int[] affectRows = Db.executeBatch(orders, 200, OrderMapper.class, BaseMapper::insertSelective);
        System.out.println("affectRows:"+ Arrays.toString(affectRows));
        for (Order order : orders) {
            System.out.println("order:" + order);
        }
    }

    @Test
    void testLeftJoin() {
        Long orderId = 1L;
        List<Order> orders = QueryChain.of(orderMapper)
                .select(ORDER.DEFAULT_COLUMNS, USER.DEFAULT_COLUMNS)
                .from(ORDER)
                .leftJoin(USER).on(ORDER.USER_ID.eq(USER.ID))
                .where(ORDER.ID.eq(orderId))
                .listAs(Order.class);
        for (Order order: orders) {
            System.out.println(order);
        }
    }

    @Test
    void testRelationOneToOne() {
        List<Order> orders = orderMapper.selectAllWithRelations();
        for (Order order: orders) {
            System.out.println(order);
        }
    }
}
