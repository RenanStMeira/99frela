package com.studs.demo.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepositoryImpl<T> implements RedisRepository<T> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public T findById(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
