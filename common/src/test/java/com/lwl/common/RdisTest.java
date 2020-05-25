package com.lwl.common;

import com.lwl.common.common.dao.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RdisTest {
    @Autowired
    RedisTemplate<String, Object> redisTemplatel;
    @Test
    void saveRdisTest() {
        RedisUtil redisUtil=new RedisUtil(redisTemplatel);
        redisUtil.set("lwl2","lanwenliang2");
        System.out.println("111111");
    }
}
