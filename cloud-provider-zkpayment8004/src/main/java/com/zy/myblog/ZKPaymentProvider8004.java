package com.zy.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zy 1716457206@qq.com
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class ZKPaymentProvider8004 {
    public static void main(String[] args) {
        SpringApplication.run(ZKPaymentProvider8004.class, args);
    }
}
