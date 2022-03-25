package com.miao.db.redisson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonAutoConfiguration {

    @Bean
    public RedisListHander redisListHander() {
        return new RedisListHander();
    }

    @Bean
    public RedisSetHander redisSetHander() {
        return new RedisSetHander();
    }

    @Bean
    public RedisMapHander redisMapHander() {
        return new RedisMapHander();
    }
}
