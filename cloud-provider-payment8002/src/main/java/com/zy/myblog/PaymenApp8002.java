package com.zy.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymenApp8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymenApp8002.class, args);
    }
}
