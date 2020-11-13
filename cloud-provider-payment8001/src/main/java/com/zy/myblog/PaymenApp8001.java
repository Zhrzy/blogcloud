package com.zy.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//该注解用于服务发现
@EnableDiscoveryClient
public class PaymenApp8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymenApp8001.class, args);
    }
}
