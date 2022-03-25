package com.miao.db.redisson;

import org.redisson.api.RFuture;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class RedisMapHander {
    @Autowired
    private RedissonClient redissonClient;

    public <T> Map<String, T> get(String key) {
        RMap<String, T> rMap = redissonClient.getMap(key);
        return rMap.readAllMap();
    }

    public <T> T put(String key, T bean) {
        RMap<String, T> rMap = redissonClient.getMap(key);
        return rMap.put(key, bean);
    }

    public <T> void putAll(String key, Map<String, T> map) {
        RMap<String, T> rMap = redissonClient.getMap(key);
        rMap.putAll(map);
    }

    //添加并返回之前关联过的值
    public <T> T putIfAbsent(String key, T bean) {
        RMap<String, T> rMap = redissonClient.getMap(key);
        return rMap.putIfAbsent(key, bean);
    }

    //添加数据，如果已经有key 返回false
    public <T> boolean fastPut(String key, T bean) {
        RMap<String, T> rMap = redissonClient.getMap(key);
        return rMap.fastPut(key, bean);
    }

    //异步添加数据，如果已经有key 返回false
    public <T> Boolean fastPutAsync(String key, String mapKey, T mapValue) throws ExecutionException, InterruptedException {
        RMap<String, T> rMap = redissonClient.getMap(key);
        RFuture<Boolean> booleanRFuture = rMap.fastPutAsync(mapKey, mapValue);
        return booleanRFuture.get();
    }

    public boolean expire(String key, long timeToLive, TimeUnit timeUnit) {
        RMap rMap = redissonClient.getMap(key);
        return rMap.expire(timeToLive, timeUnit);
    }

    public void clear(String key) {
        RMap rMap = redissonClient.getMap(key);
        rMap.clear();
    }

    public <T> boolean set(String key, Map<String, T> map, long timeToLive, TimeUnit timeUnit) {
        RMap rMap = redissonClient.getMap(key);
        rMap.clear();
        rMap.putAll(map);
        return rMap.expire(timeToLive, timeUnit);
    }

    //移除key
    public <T> T remove(String key, String mapKey) {
        RMap<String, T> rMap = redissonClient.getMap(key);
        return rMap.remove(mapKey);
    }

    // 异步移除key
    public long fastRemove(String key, String mapKey) {
        RMap rMap = redissonClient.getMap(key);
        return rMap.fastRemove(mapKey);
    }


}
