package com.example.rediscaching.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ChatService implements MessageListener {

//    @Autowired
//    private RedisMessageListenerContainer redisMessageListenerContainer;
//
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("message = " + message.toString());
    }

//    public void enterChatRoom(String chatRoomName) {
//        redisMessageListenerContainer.addMessageListener(this, new ChannelTopic(chatRoomName));
//
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            if (line.equals("q")) {
//                System.out.println("Quit...");
//                break;
//            }
//
//            redisTemplate.convertAndSend(chatRoomName, line);
//        }
//
//        redisMessageListenerContainer.removeMessageListener(this);
//    }
}
