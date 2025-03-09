package com.studs.demo.infrastructure.repository;

import com.studs.demo.cache.model.ICacheModel;

public interface CacheRepository<T extends ICacheModel> {
    void save(T cacheModel);
    T findById(String key);
    void delete(String key);
}
