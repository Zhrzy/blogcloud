package com.zy.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zy 1716457206@qq.com
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerOrderApp80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApp80.class,args);
    }
}
