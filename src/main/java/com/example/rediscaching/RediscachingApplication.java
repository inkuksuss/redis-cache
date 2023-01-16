package com.example.rediscaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RediscachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RediscachingApplication.class, args);
	}

}
