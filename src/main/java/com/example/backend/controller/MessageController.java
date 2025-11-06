//package com.example.backend.controller;
/*
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "*")
public class MessageController {

    // temp database
    private final List<Map<String, Object>> messages = new ArrayList<>();
    private long nextId = 1;

    // It creates one example message so there's something to show
    public MessageController() {
        Map<String, Object> m = new HashMap<>();
        m.put("id", nextId++);
        m.put("chatId", 1);
        m.put("senderId", 1);
        m.put("content", "Hey, is this still available?");
        m.put("sentAt", Instant.now().toString());
        messages.add(m);
    }

    //gives back a list of messages
    @GetMapping
    public List<Map<String, Object>> getMessages(@RequestParam(required = false) Long chatId) {
        if (chatId == null) {
            return messages;
        }
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> m : messages) {
            if (Objects.equals(m.get("chatId"), chatId)) {
                result.add(m);
            }
        }
        return result;
    }

}
    */