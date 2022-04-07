package com.miao.db_redisson.controller;


import com.alibaba.fastjson.JSONObject;
import com.miao.db.redisson.RedisListHander;
import com.miao.db.redisson.RedisObjectHander;
import com.miao.db_redisson.entry.RemoteResponse;
import com.miao.db_redisson.entry.SonBean;
import com.miao.db_redisson.entry.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
@Slf4j
public class HelloController {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    RedisListHander redisListHander;
    @Autowired
    RedisObjectHander redisObjectHander;

    private static int count = 0;

    private String TEST_FLAG = "test:jing:redisson";
    private String LOCK_FLAG = "test:jing:redisson_lock";
    private String LIST_KEY = "test:jing:redisson_list";

    @RequestMapping("/index")
    public String index() {
        Integer str = redisObjectHander.get(TEST_FLAG);
        return JSONObject.toJSONString(str);
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
        redisObjectHander.set(TEST_FLAG, count);
        return count;
    }

    @RequestMapping(value = "/testGetRList", method = RequestMethod.GET)
    public List<UserBean> testGetRList() {
        List<UserBean> list = redisListHander.get(LIST_KEY);
        for (UserBean userBean : list) {
            log.info("count:" + userBean.getCount().toString());
            Map<Integer, UserBean> countMap = userBean.getCountMap();
            UserBean bean = countMap.get(1);
            log.info("countMap-name:" + bean.getName());
            SonBean sonBean = userBean.getSonBean();
            log.info("sonBean-sonname:" + sonBean.getSonName());
            List<SonBean> dataList = userBean.getDataList();
            log.info("dataList-sonname:" + dataList.get(0).getSonName());
        }
        return list;
    }

    @RequestMapping(value = "/testAddRList", method = RequestMethod.GET)
    public String testAddRList() {
        UserBean userBean1 = buildUserBean("张三", 18);
        redisListHander.add(LIST_KEY, userBean1);
        UserBean userBean2 = buildUserBean("李四", 19);
        redisListHander.add(LIST_KEY, userBean2);
        redisListHander.expire(LIST_KEY, 10, TimeUnit.MINUTES);
        return "ok";
    }

    @RequestMapping(value = "/testAddRList1", method = RequestMethod.GET)
    public String testAddRList1() {
        RemoteResponse<List<UserBean>> remoteResponse = new RemoteResponse<>();
        List<UserBean> list = new ArrayList<>();
        UserBean userBean1 = buildUserBean("张三", 18);
        redisListHander.add(LIST_KEY, userBean1);
        UserBean userBean2 = buildUserBean("李四", 19);
        list.add(userBean1);
        list.add(userBean2);
        remoteResponse.setData(list);
        redisObjectHander.set("test_jing_obj", remoteResponse);

        RemoteResponse<List<UserBean>> remoteResponseGet = redisObjectHander.get("test_jing_obj");

        RemoteResponse<List<?>> remoteResponseGet2 = redisObjectHander.get("test_jing_obj");

        return "ok";
    }

    @RequestMapping(value = "/testRemoveRList", method = RequestMethod.GET)
    public String testRemoveRList() {
        UserBean result = redisListHander.remove(LIST_KEY, 1);
        return JSONObject.toJSONString(result);
    }

    @RequestMapping(value = "/testClearRList", method = RequestMethod.GET)
    public String testClearRList() {
        redisListHander.clear(LIST_KEY);
        return "ok";
    }

    private UserBean buildUserBean(String userName, Integer age) {
        UserBean userBean = new UserBean();
        userBean.setName(userName);
        userBean.setAge(age);
        userBean.setCount(BigDecimal.ONE);
        userBean.setBirthday(new Date());
        UserBean userBeanF = UserBean.builder().name(userName + "爸爸").age(age + 24).birthday(new Date()).count(BigDecimal.ZERO).build();
        UserBean userBeanM = UserBean.builder().name(userName + "妈妈").age(age + 22).birthday(new Date()).count(BigDecimal.ZERO).build();
        List<UserBean> parents = new ArrayList<>();
        parents.add(userBeanF);
        parents.add(userBeanM);
        userBean.setParents(parents);
        Map<Integer, UserBean> map = new HashMap<>();
        map.put(1, userBeanF);
        map.put(2, userBeanM);
        userBean.setCountMap(map);

        SonBean sonBean = SonBean.builder().sonName(userName + "儿子").sonDay(-1).createTime(new Date()).build();
        userBean.setSonBean(sonBean);
        List<SonBean> dataList = new ArrayList<>();
        dataList.add(sonBean);
        dataList.add(sonBean);
        userBean.setDataList(dataList);
        return userBean;
    }

}
