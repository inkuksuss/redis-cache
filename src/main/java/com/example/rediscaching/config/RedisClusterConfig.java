package com.example.rediscaching.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;


@Configuration
public class RedisClusterConfig {

    @Autowired ClusterConfigurationProperties clusterConfigurationProperties;

    @Bean
    public RedisConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory(new RedisClusterConfiguration(clusterConfigurationProperties.getNodes()));
    }
}
