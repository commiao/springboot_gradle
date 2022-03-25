package com.miao.db.redisson;

import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisListHander {
    @Autowired
    private RedissonClient redissonClient;

    public <T> List<T> get(String key) {
        RList<T> rList = redissonClient.getList(key);
        return rList.readAll();
    }

    public <T> boolean add(String key, T bean) {
        RList<T> rList = redissonClient.getList(key);
        return rList.add(bean);
    }

    public boolean expire(String key, long timeToLive, TimeUnit timeUnit) {
        RList rList = redissonClient.getList(key);
        return rList.expire(timeToLive, timeUnit);
    }

    public void clear(String key) {
        RList rList = redissonClient.getList(key);
        rList.clear();
    }

    public <T> T remove(String key, int index) {
        RList<T> rList = redissonClient.getList(key);
        return rList.remove(index);
    }

    public <T> boolean addAll(String key, List<T> list) {
        RList<T> rList = redissonClient.getList(key);
        return rList.addAll(rList);
    }

    public <T> boolean set(String key, List<T> list) {
        RList<T> rList = redissonClient.getList(key);
        rList.clear();
        return rList.addAll(list);
    }

    public <T> boolean set(String key, List<T> list, long timeToLive, TimeUnit timeUnit) {
        RList<T> rList = redissonClient.getList(key);
        rList.clear();
        rList.addAll(list);
        return rList.expire(timeToLive, timeUnit);
    }
}
