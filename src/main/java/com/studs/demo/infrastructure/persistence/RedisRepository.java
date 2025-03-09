package com.studs.demo.infrastructure.persistence;

public interface RedisRepository<T> {
    void save(String key, T value);
    T findById(String key);
    void delete(String key);
}
