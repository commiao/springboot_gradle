package com.miao.db.redisson;

import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisSetHander {
    @Autowired
    private RedissonClient redissonClient;

    public <T> Set<T> get(String key) {
        RSet<T> rSet = redissonClient.getSet(key);
        return rSet.readAll();
    }

    public <T> boolean add(String key, T bean) {
        RSet<T> rSet = redissonClient.getSet(key);
        return rSet.add(bean);
    }

    public <T> boolean addAll(String key, Set<T> set) {
        RSet<T> rSet = redissonClient.getSet(key);
        return rSet.addAll(set);
    }

    public boolean expire(String key, long timeToLive, TimeUnit timeUnit) {
        RSet rSet = redissonClient.getSet(key);
        return rSet.expire(timeToLive, timeUnit);
    }

    public void clear(String key) {
        RSet rSet = redissonClient.getSet(key);
        rSet.clear();
    }

    public <T> boolean set(String key, Set<T> set, long timeToLive, TimeUnit timeUnit) {
        RSet rSet = redissonClient.getSet(key);
        rSet.clear();
        rSet.addAll(set);
        return rSet.expire(timeToLive, timeUnit);
    }

}
