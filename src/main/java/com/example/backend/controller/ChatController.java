package com.example.backend.controller;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/chats")
@CrossOrigin(origins = "*")
public class ChatController {

    private final List<Map<String, Object>> chats = new ArrayList<>();
    private long nextId = 1;

    public ChatController() {
        Map<String, Object> chat = new HashMap<>();
        chat.put("id", nextId++);
        chat.put("buyerId", 1);
        chat.put("sellerId", 2);
        chat.put("itemId", 1);
        chat.put("createdAt", Instant.now().toString());
        chats.add(chat);
    }

    // GET
    @GetMapping
    public List<Map<String, Object>> getAllChats() {
        return chats;
    }

}
