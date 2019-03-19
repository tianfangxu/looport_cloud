package com.yollweb.looport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class AdminRunMonitor {

    //监控地址：http://localhost:9001/hystrix
    public static void main(String[] args) {
        SpringApplication.run(AdminRunMonitor.class);
    }
}
