package com.example.redisson_demo.controller;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class HelloController {

    @Autowired
    private RedissonClient redissonClient;

    private static int count = 0;

    private String TEST_FLAG = "test:jing:redisson";
    private String LOCK_FLAG = "test:jing:redisson_lock";

    @RequestMapping("/index")
    public String index() {
        RBucket<Object> bucket = redissonClient.getBucket(TEST_FLAG);
        count = 0;
        return JSONObject.toJSONString(bucket.get());
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int count() {
        //对数据进行加锁
        RLock lock = redissonClient.getLock(LOCK_FLAG);
        //加锁
        lock.lock();
        count++;
        //解锁
        lock.unlock();
        log.info(String.valueOf(count));
        RBucket<Object> bucket = redissonClient.getBucket(TEST_FLAG);
        bucket.set(count);
        return count;
    }

}
