package com.zy.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zy 1716457206@qq.com
 */
@SpringBootApplication
@EnableFeignClients
public class FeignConsumerApp80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApp80.class,args);
    }
}
