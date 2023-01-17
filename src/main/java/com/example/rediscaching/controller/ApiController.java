package com.example.rediscaching.controller;


import com.example.rediscaching.dto.UserProfile;
import com.example.rediscaching.service.RankingService;
import com.example.rediscaching.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final RankingService rankingService;
    private final UserService userService;

    @Autowired
    public ApiController(RankingService rankingService, UserService userService) {
        this.rankingService = rankingService;
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/profile")
    public UserProfile getUserProfile(@PathVariable(value = "userId") String userId) {
        return userService.getUserProfile(userId);
    }

    @GetMapping("/setScore")
    public Boolean setScore(@RequestParam String userId, @RequestParam int score) {
        return rankingService.setUserScore(userId, score);
    }

    @GetMapping("/getUserRank")
    public Long getUserRank(@RequestParam String userId) {
        return rankingService.getUserRanking(userId);
    }

    @GetMapping("/getTopUsers")
    public List<String> getTopUsers() {
        return rankingService.getTopLank(3);
    }
}
