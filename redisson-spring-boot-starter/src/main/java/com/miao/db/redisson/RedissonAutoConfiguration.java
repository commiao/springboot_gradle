package com.miao.db.redisson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonAutoConfiguration {

    @Bean
    public RedisListHander redisListHander() {
        return new RedisListHander();
    }

}
