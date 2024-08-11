package org.zz.springboot.guide.mp.user;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

/**
 * 流式查询 适用于数据跑批或处理大数据的业务场景
 */

@SpringBootTest
class StreamQueryTests {

    @Resource
    UserMapper userMapper;

    @Test
    void testStreamQuery() {
        Page<User> page = new Page<>(1, 20);
        userMapper.selectList(page, Wrappers.emptyWrapper(), new ResultHandler<User>() {
            int count = 0;
            @Override
            public void handleResult(ResultContext<? extends User> resultContext) {
                User user = resultContext.getResultObject();
                System.out.println("当前处理第" + (++count) + "条记录: " + user);
                // 在这里进行你的业务处理，比如分发任务
            }
        });
    }
}
