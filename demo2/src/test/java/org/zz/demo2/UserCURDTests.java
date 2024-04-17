package org.zz.demo2;

import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.relation.RelationManager;
import com.mybatisflex.core.row.Db;
import com.mybatisflex.core.update.UpdateChain;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.demo2.domain.Order;
import org.zz.demo2.domain.User;
import org.zz.demo2.mapper.UserMapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.zz.demo2.domain.table.UserTableDef.USER;


@SpringBootTest
class UserCURDTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void helloWorld() {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(USER.ID.eq(14));
        User user = userMapper.selectOneByQuery(queryWrapper);
        System.out.println(user);
    }

    @Test
    void testInsert() {
        int size = 10;
        List<User> users = new ArrayList<>();
        for (int i =0; i < size; i++) {
            int sn = i+1;
            User user = User.builder().name("仔仔"+sn).username("zz"+sn).password("123456").build();
            users.add(user);
        }

        int[] affectRows = Db.executeBatch(users, 200, UserMapper.class, BaseMapper::insertSelective);
        System.out.println("affectRows:"+ Arrays.toString(affectRows));
        for (User user : users) {
            System.out.println("user:" + user);
        }
    }

    @Test
    void testDelete() {
        Long userId = 1L;
        int i = userMapper.deleteById(userId);
        if (i == 0) {
            System.out.println("删除失败");
            return;
        }

        System.out.println("删除成功");
    }

    @Test
    void testUpdate() {
        Long userId = 11L;
        LocalDateTime parse = LocalDateTime.parse("2024-02-02 22:22:22", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        boolean res = UpdateChain.of(User.class).
                 set(User::getUsername, "张三").
                 set(User::getUpdatedAt, Date.from(parse.atZone(ZoneId.systemDefault()).toInstant())).
                where(User::getId).eq(userId).
                update();
        if (!res) {
            System.out.println("更新失败");
            return;
        }
        System.out.println("更新成功");
    }

    @Test
    void testGetById() {
        Long userId = 14L;
        QueryWrapper queryWrapper = QueryWrapper.create().select().where(USER.ID.eq(userId));
        User user = userMapper.selectOneByQuery(queryWrapper);
        if (user == null) {
            System.out.println("查询失败");
            return;
        }

        System.out.println("user:" + user);
    }

    @Test
    void testGetByIds() {
        Long[] userIds = {14L, 12L};
        if (userIds.length == 0) {
            System.out.println("user ids 不能wield空");
            return;
        }

        QueryWrapper queryWrapper = QueryWrapper.create().select().where(USER.ID.in((Object) userIds));
        List<User> users = userMapper.selectListByQuery(queryWrapper);
        if (users == null || users.isEmpty()) {
            System.out.println("查询失败");
            return;
        }

        for (User user: users) {
            System.out.println("user:" + user);
        }
    }

    @Test
    void testRelationOneToMany() {
        Long userId = 14L;
        RelationManager.addQueryRelations("orders");
        // 添加忽略relation，防止多查
        RelationManager.addIgnoreRelations("Order.user");
        QueryWrapper qw = QueryWrapper.create().select().where(USER.ID.eq(userId));
        User user = userMapper.selectOneWithRelationsByQueryAs(qw, User.class);
        if (user == null) {
            System.out.println("用户不存在");
            return;
        }

        List<Order> orders = user.getOrders();
        if (orders == null || orders.isEmpty()) {
            System.out.println("订单为空");
            return;
        }

        for (Order order: orders) {
            System.out.println("order:" + order);
        }

    }
}
