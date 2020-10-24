package com.zy.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zy 1716457206@qq.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixPaymentAPP8100 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentAPP8100.class,args);
    }
}
