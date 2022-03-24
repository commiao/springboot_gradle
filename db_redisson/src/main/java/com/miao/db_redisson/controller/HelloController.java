package com.miao.db_redisson.controller;


import com.alibaba.fastjson.JSONObject;
import com.miao.db_redisson.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

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

    @RequestMapping(value = "/testGetRList", method = RequestMethod.GET)
    public List<UserBean> testGetRList() {
        RList<UserBean> rList = redissonClient.getList("jingmiao_list");
        List<UserBean> result = rList.readAll();
        return result;
    }

    @RequestMapping(value = "/testAddRList", method = RequestMethod.GET)
    public List<UserBean> testAddRList() {
        RList<UserBean> rList = redissonClient.getList("jingmiao_list");
        UserBean userBean1 = buildUserBean("张三", 18);
        rList.add(userBean1);
        UserBean userBean2 = buildUserBean("李四", 19);
        rList.add(userBean2);
        List<UserBean> result = rList.readAll();
        return result;
    }

    @RequestMapping(value = "/testRemoveRList", method = RequestMethod.GET)
    public String testRemoveRList() {
        RList<UserBean> rList = redissonClient.getList("jingmiao_list");
        rList.removeIf(userBean -> userBean.getAge() == 18);
        return "ok";
    }

    @RequestMapping(value = "/testClearRList", method = RequestMethod.GET)
    public String testClearRList() {
        RList<UserBean> rList = redissonClient.getList("jingmiao_list");
        rList.clear();
        return "ok";
    }

    private UserBean buildUserBean(String userName, Integer age) {
        UserBean userBean = new UserBean();
        userBean.setName(userName);
        userBean.setAge(age);
        userBean.setCount(BigDecimal.ONE);
        userBean.setBirthday(new Date());
//        UserBean userBeanF = UserBean.builder().name(userName+"爸爸").age(age+24).birthday(new Date()).count(BigDecimal.ZERO).build();
//        UserBean userBeanM = UserBean.builder().name(userName+"妈妈").age(age+22).birthday(new Date()).count(BigDecimal.ZERO).build();
//        List<UserBean> parents = new ArrayList<>();
//        parents.add(userBeanF);
//        parents.add(userBeanM);
//        userBean.setParents(parents);
//        Map<Integer,UserBean> map = new HashMap<>();
//        map.put(0,userBean);
//        map.put(1,userBeanF);
//        map.put(2,userBeanM);
//        userBean.setCountMap(map);
        return userBean;
    }

}
