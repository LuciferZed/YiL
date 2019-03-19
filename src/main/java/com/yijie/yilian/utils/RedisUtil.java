package com.yijie.yilian.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
	
	/**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(RedisTemplate<String, Object> redisTemplate, final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    /**
     * 写入存在有效时间的缓存(秒级)
     * @param key
     * @param value
     * @return
     */
    public boolean set(RedisTemplate<String, Object> redisTemplate, final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    /**
     * 判断缓存中是否有对应的数据
     * @param key
     * @return
     */
    public boolean exists(RedisTemplate<String, Object> redisTemplate, final String key) {
        return redisTemplate.hasKey(key);
    }
    
    
    /**
     * 删除缓存数据
     * @param key
     */
    public void remove(RedisTemplate<String, Object> redisTemplate, final String key) {
        if (exists(redisTemplate, key)) {
            redisTemplate.delete(key);
        }
    }
    
    
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(RedisTemplate<String, Object> redisTemplate, final String key) {
        Object result = null;
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

}
