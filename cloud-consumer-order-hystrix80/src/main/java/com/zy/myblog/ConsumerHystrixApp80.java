package com.zy.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zy 1716457206@qq.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class ConsumerHystrixApp80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixApp80.class, args);
    }
}
