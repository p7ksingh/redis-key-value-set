package com.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.p1.service.RedisService;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/getValue/{key}")
    public String getValue(@PathVariable String key) {
    	
    	
        return redisService.getValueByKey(key);
    }

    @PostMapping("/setValue")
    public void setValue(@RequestParam String key, @RequestParam String value) {
        redisService.setValueByKey(key, value);
    }
}