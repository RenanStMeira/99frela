package com.studs.demo.infrastructure.repository;

import com.studs.demo.cache.model.ICacheModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CacheRepositoryImpl<T extends ICacheModel> implements CacheRepository<T> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(T cacheModel) {
        redisTemplate.opsForValue().set(cacheModel.getKey(), cacheModel);
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
