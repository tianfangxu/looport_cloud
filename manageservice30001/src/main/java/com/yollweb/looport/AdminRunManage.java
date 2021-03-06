package com.yollweb.looport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient      //服务发现
@EnableCircuitBreaker       //支持服务熔断
@EnableFeignClients         //feign调用
public class AdminRunManage {

    public static void main(String[] args) {
        SpringApplication.run(AdminRunManage.class);
    }
}
