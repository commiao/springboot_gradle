package com.miao.hello_world.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void getSayTest() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        long start = System.currentTimeMillis();
        ResponseEntity responseEntity = testRestTemplate.exchange("/hello/say", HttpMethod.GET, new HttpEntity<Object>(headers), String.class);
        long end = System.currentTimeMillis();
        System.out.println(responseEntity.getBody());
        System.out.println("selectEmpInfo耗时：" + (end - start) + "ms.");
    }

}
