package org.zz.springboot.guide.redisson;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class LearnDistributedLockApplicationTests {
    @Resource
    protected RedissonClient redissonClient;

    @Test
    void t1() {
        // 获取锁，默认锁的最多等待时间是30s，自动续期10s
        RLock lock = redissonClient.getLock("anyLock");

        try {
            // 尝试获取锁，最多等待10秒，锁定之后10秒自动解锁
            boolean isLocked = lock.tryLock(10, 10, TimeUnit.SECONDS);
            if (isLocked) {
                // 业务逻辑
            } else {
                // 获取锁失败，执行其他业务逻辑或者直接返回
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}
