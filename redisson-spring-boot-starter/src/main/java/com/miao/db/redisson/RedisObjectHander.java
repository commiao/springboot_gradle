package com.miao.db.redisson;

import org.redisson.api.RBucket;
import org.redisson.api.RFuture;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class RedisObjectHander {
    @Autowired
    private RedissonClient redissonClient;

    public <T> T get(String key) {
        RBucket<T> rBucket = redissonClient.getBucket(key);
        return rBucket.get();
    }

    //异步异步读取数据
    public <T> T getAsync(String key) throws ExecutionException, InterruptedException {
        RBucket<T> rBucket = redissonClient.getBucket(key);
        RFuture<T> async = rBucket.getAsync();
        return async.get();
    }

    public <T> void set(String key, T bean) {
        RBucket<T> rBucket = redissonClient.getBucket(key);
        rBucket.set(bean);
    }

    //异步添加数据
    public <T> void setAsync(String key, T bean) {
        RBucket<T> rBucket = redissonClient.getBucket(key);
        rBucket.setAsync(bean);
    }

    public boolean expire(String key, long timeToLive, TimeUnit timeUnit) {
        RBucket rBucket = redissonClient.getBucket(key);
        return rBucket.expire(timeToLive, timeUnit);
    }

    public void delete(String key) {
        RBucket rBucket = redissonClient.getBucket(key);
        rBucket.delete();
    }

    public <T> boolean set(String key, T bean, long timeToLive, TimeUnit timeUnit) {
        RBucket rBucket = redissonClient.getBucket(key);
        rBucket.set(bean);
        return rBucket.expire(timeToLive, timeUnit);
    }
}
