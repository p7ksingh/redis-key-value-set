package com.p1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    public String getValueByKey(String key) {
//        return stringRedisTemplate.opsForValue().get(key);
//    }
//    public void setValueByKey(String key, String value) {
//        stringRedisTemplate.opsForValue().set(key, value);
//    }

	private final StringRedisTemplate stringRedisTemplate;

	@Autowired
	public RedisService(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	public String getValueByKey(String key) {
		if (stringRedisTemplate.hasKey(key)) {
			return stringRedisTemplate.opsForValue().get(key);
		} else {
			return "Key not found";
		}
	}

	public void setValueByKey(String key, String value) {
		stringRedisTemplate.opsForValue().set(key, value);
	}
}