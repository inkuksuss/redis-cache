package com.example.rediscaching.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RankingService {

    private static final String LEADED_BOARD_KEY = "leaderBoard";
    private final StringRedisTemplate redisTemplate;

    @Autowired
    public RankingService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean setUserScore(String userId, int score) {
        ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
        zSetOps.add(LEADED_BOARD_KEY, userId, score);
        return true;
    }

    public Long getUserRanking(String userId) {
        ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
        return zSetOps.reverseRank(LEADED_BOARD_KEY, userId);
    }

    public List<String> getTopLank(int limit) {
        ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
        Set<String> strings = zSetOps.reverseRange(LEADED_BOARD_KEY, 0, limit - 1);

        return new ArrayList<>(strings);
    }
}
