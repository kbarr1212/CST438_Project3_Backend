package com.example.backend.controller;


import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("items")
@CrossOrigin(origins = "*")
public class ItemController {

    // temp database
    private List<Map<String, Object>> items = new ArrayList<>();

    // temp data for now
    public ItemController() {
        Map<String, Object> item1 = new HashMap<>();
        item1.put("id", 1);
        item1.put("title", "Vintage Jacket");
        item1.put("price", new BigDecimal("49.99"));
        item1.put("seller", "Alex");

        Map<String, Object> item2 = new HashMap<>();
        item2.put("id", 2);
        item2.put("title", "Retro Sneakers");
        item2.put("price", new BigDecimal("89.00"));
        item2.put("seller", "Jamie");

        items.add(item1);
        items.add(item2);
    }

    // GET items
    @GetMapping
    public List<Map<String, Object>> getAllItems() {
        return items;
    }

    // POST item
    @PostMapping
    public Map<String, Object> createItem(@RequestBody Map<String, Object> newItem) {
        newItem.put("id", items.size() + 1);
        items.add(newItem);
        return newItem;
    }
}

