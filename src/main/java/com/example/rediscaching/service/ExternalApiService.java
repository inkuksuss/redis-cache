package com.example.rediscaching.service;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {

    public String getUserName(String userId) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }

        if (userId.equals("A")) {
            return "Adam";
        } else if (userId.equals("B")) {
            return "Bob";
        } else {
            return "";
        }
    }

    @Cacheable(cacheNames = "userAgeCache", key = "#userId")
    public int getUserAge(String userId) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }

        if (userId.equals("A")) {
            return 32;
        } else if (userId.equals("B")) {
            return 27;
        } else {
            return 21;
        }
    }
}
