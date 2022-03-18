package com.example.redisson_demo.common;//package com.example.demo_gradle.common;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.ClusterServersConfig;
//import org.redisson.config.Config;
//import org.redisson.config.SingleServerConfig;
//import org.redisson.config.TransportMode;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RedissonConfig {
//    @Bean
//    public RedissonClient redissonClient(){
//        Config config = new Config();
////        config.setTransportMode(TransportMode.NIO);
////        SingleServerConfig singleServerConfig = config.useSingleServer();
////        //可以用"rediss://"来启用SSL连接
////        singleServerConfig.setAddress("redis://172.16.163.60:7000");
////        singleServerConfig.setPassword("123456");
//
//        ClusterServersConfig clusterConfig = config.useClusterServers();
//        clusterConfig.setScanInterval(2000)// 集群状态扫描间隔时间，单位是毫秒
//                .addNodeAddress("redis://172.16.163.60:7000")
//                .addNodeAddress("redis://172.16.163.60:7001","redis://172.16.163.61:7002","redis://172.16.163.61:7003","redis://172.16.163.62:7004","redis://172.16.163.62:7005");
//
//        RedissonClient redisson = Redisson.create(config);
//        return redisson;
//    }
//}
