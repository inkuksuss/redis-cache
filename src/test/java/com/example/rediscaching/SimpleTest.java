package com.example.rediscaching;

import com.example.rediscaching.service.RankingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class SimpleTest {

    @Autowired
    private RankingService rankingService;

    @Test
    void inMemorySortPerformance() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            int score = (int) (Math.random() * 1000000);
            list.add(score);
        }

        Instant before = Instant.now();
        Collections.sort(list);
        Duration between = Duration.between(before, Instant.now());
        System.out.println("between = " + between.getNano() / 1000000 + "ms");
    }

    @Test
    void insertScore() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            int score = (int) (Math.random() * 1000000);
            String userId = "user_" + i;

            rankingService.setUserScore(userId, score);
        }
    }

    @Test
    void getRanks() {
        // connect을 하기 위한 더미 로직
        rankingService.getTopLank(1);


        Instant before = Instant.now();
        Long userRank = rankingService.getUserRanking("user_100");
        Duration between = Duration.between(before, Instant.now());
        System.out.println(String.format("Rank(%d) - Took %d ms", userRank, between.getNano() / 1000000));

        before = Instant.now();
        List<String> topLank = rankingService.getTopLank(10);
        between = Duration.between(before, Instant.now());

        System.out.println(String.format("Range - Took %d ms", between.getNano() / 1000000));
    }
}
