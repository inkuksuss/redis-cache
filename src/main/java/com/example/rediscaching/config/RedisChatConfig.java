package com.example.rediscaching.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class RedisChatConfig {

//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory();
//    }
//
//    @Bean
//    RedisMessageListenerContainer redisContainer() {
//        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory());
//        return redisMessageListenerContainer;
//    }
}
