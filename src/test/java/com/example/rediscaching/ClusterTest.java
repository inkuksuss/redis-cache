package com.example.rediscaching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class ClusterTest {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    String dummyValue = "banana";

    @Test
    void setValues() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        for (int i = 0; i < 1000; i++) {
            String key = String.format("name:%d", i);
            ops.set(key, dummyValue);
        }
    }

    @Test
    void getValues() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        for (int i = 0; i < 1000; i++) {
            String key = String.format("name:%d", i);
            String value = ops.get(key);

            Assertions.assertThat(value).isEqualTo(dummyValue);
        }
    }
}
