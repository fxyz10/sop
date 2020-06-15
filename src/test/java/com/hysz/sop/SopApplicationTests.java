package com.hysz.sop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

@SpringBootTest
class SopApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.boundListOps("k2").leftPush("v5");
        redisTemplate.opsForValue().set("k4", "v4");
        redisTemplate.rename("k4", "key4");

        boolean b = redisTemplate.hasKey("k3");
        boolean b2 = redisTemplate.delete("k3");
        String type = Objects.requireNonNull(redisTemplate.type("key5")).toString();
        System.out.println(b);
        System.out.println(b2);
        System.out.println(type);

        System.out.println(redisTemplate.opsForValue().get("key4"));
        System.out.println(redisTemplate.opsForList().index("k2", 2));
    }


    @Test
    void encrypt() {
        System.out.println(111);

    }

}
