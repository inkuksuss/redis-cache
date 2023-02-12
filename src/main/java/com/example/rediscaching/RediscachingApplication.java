package com.example.rediscaching;

import com.example.rediscaching.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RediscachingApplication implements CommandLineRunner {

//	@Autowired
//	private ChatService chatService;

	public static void main(String[] args) {
		SpringApplication.run(RediscachingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("run");
//
//		chatService.enterChatRoom("room1");
	}
}
