package com.zy.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zy 1716457206@qq.com
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApp3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp3344.class, args);
    }
}
